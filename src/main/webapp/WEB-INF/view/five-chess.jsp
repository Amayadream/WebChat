<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title> 五子棋 </title>
    <meta charset="utf-8"/>
    <script type="text/javascript" src="${ctx}/static/source/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/source/js/jcanvas.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/source/js/board.js"></script>
    <script type="text/javascript" src="${ctx}/static/source/js/ai2.min.js"></script>
    <style>
        .button{
            width:150px;
            height: 30px;
            font-size: 20px;
            border: 1px solid #b3b3b3;
            margin-top: 3%;
            background: #ccc;
        }
    </style>
    <script>
        var bd = new Board();
        var br = new Brain();
        var CW = 40; //CELL WIDTH
        var OS = 40; //OFFSET
        var bgColor = "darkorange";
        var cellColor = "#000";
        var highlightCellColor = "red";
        var humanSide,computerSide;
        var lastStep = [0,0];
        var manual = false;
        var showOrder = false;

        function drawChess(cx,cy,player){
            if(player == 0) return;
            var size = CW*5/6;
            $("canvas").drawEllipse({
                fillStyle: (player == BLACK?"black":"white"),
                x: (cx-1)*CW+OS, y:(cy-1)*CW+OS,
                width: size, height: size
            });
        }

        function drawStar(cx,cy){
            $("canvas").drawEllipse({
                fillStyle: "black",
                x: (cx-1)*CW+OS, y:(cy-1)*CW+OS,
                width: 8, height: 8
            });
        }

        function drawOrder(){
            var history = bd.getHistory();
            if(history.length>0){
                var x = CENTER , y = CENTER;
                $("canvas").drawText({
                    fillStyle: "red",
                    strokeStyle: "red",
                    strokeWidth: 1,
                    x: (x-1)*CW+OS, y:(y-1)*CW+OS,
                    font: "8pt Arial",
                    text: 1
                });
                for(var i=0;i<history.length;++i){
                    var step = history[i];
                    var x = step[0];
                    var y = step[1];
                    $("canvas").drawText({
                        fillStyle: "red",
                        strokeStyle: "red",
                        strokeWidth: 1,
                        x: (x-1)*CW+OS, y:(y-1)*CW+OS,
                        font: "8pt Arial",
                        text: i+2
                    });
                }
            }
        }

        function drawBoard(){
            $("canvas").drawRect({
                fillStyle: "darkorange",
                x:OS-CW/2, y:OS-CW/2,
                width: CW*BS,
                height: CW*BS,
                fromCenter: false
            });

            //draw lines
            for(var x = 0; x < BS; ++x){
                $("canvas").drawLine({
                    strokeStyle: cellColor,
                    strokeWidth: 2,
                    x1: x*CW+OS, y1: OS,
                    x2: x*CW+OS, y2: (BS-1)*CW+OS
                });
            }
            for(var y = 0; y < BS; ++y){
                $("canvas").drawLine({
                    strokeStyle: cellColor,
                    strokeWidth: 2,
                    x1: OS, y1: y*CW+OS,
                    x2: (BS-1)*CW+OS, y2: y*CW+OS
                });
            }

            //mark the star position
            drawStar(CENTER,CENTER);
            drawStar((BS+1)/4,(BS+1)/4);
            drawStar((BS+1)/4,(BS+1)*3/4);
            drawStar((BS+1)*3/4,(BS+1)/4);
            drawStar((BS+1)*3/4,(BS+1)*3/4);

            for(var x = 1; x <= BS; ++x){
                for(var y = 1; y <= BS; ++y){
                    drawChess(x,y,bd.getChess(x,y));
                }
            }

            if(showOrder){
                drawOrder();
            }
            else {//mark the last chess
                if(lastStep[0]>0 && lastStep[1]>0){
                    $("canvas").drawRect({
                        fillStyle: "red",
                        x: (lastStep[0]-1)*CW+OS, y:(lastStep[1]-1)*CW+OS,
                        width: CW/6,
                        height: CW/6,
                        fromCenter: true
                    });
                }
            }
        }

        $(function(){
            if (!window.console){
                console = {log:function(){},debug:function(){}};
            }
            for(var i=1;i<=BS;++i){
                $("canvas").drawText({
                    fillStyle: "black",
                    strokeStyle: "black",
                    strokeWidth: 1,
                    x: OS/4, y: OS+(CW*(i-1)),
                    font: "8pt Arial",
                    text: (BS-i+1)
                });
                $("canvas").drawText({
                    fillStyle: "black",
                    strokeStyle: "black",
                    strokeWidth: 1,
                    x: OS+(CW*(i-1)), y: OS*3/4+OS+CW*(BS-1),
                    font: "8pt Arial",
                    text: String.fromCharCode(64+i)
                });
            }

            drawBoard();
        });

        function newGame(){
            var side = $("input[name='side']:checked").val();
            if(side == "BLACK"){
                humanSide = BLACK;
                computerSide = WHITE;
            }
            else{
                humanSide = WHITE;
                computerSide = BLACK;
            }
            var level = $("input[name='level']:checked").val();
            if(level=="0"){
                br.setLevel(1);
            }
            else if(level=="1"){
                br.setLevel(2);
            }
            else if(level=="2"){
                br.setLevel(3);
            }
            else{
                br.setLevel(4);
            }
            lastStep=[0,0];
            bd.reset();
            drawBoard();
            turn();
        }

        function regret(){
            for(var i=0;i<2;++i){
                bd.undo();
                if(bd.getPlayer()==humanSide){
                    break;
                }
            }
            lastStep=[0,0];
            drawBoard();
            turn();
        }

        function putChess(cx,cy){
            if(cx>=1 && cx<=BS && cy>=1 && cy<=BS){
                if(bd.putChess(cx,cy)){
                    lastStep[0]=cx;lastStep[1]=cy;
                    drawBoard();
                    //showScore(bd);
                    window.setTimeout(turn,100);
                }
            }
        }

        function drawCell(x,y,c){
            var length = CW/4;
            var xx = (x-1)*CW+OS;
            var yy = (y-1)*CW+OS;
            var x1,y1,x2,y2,x3,y3,x4,y4;
            x1 = x4 = xx-CW/2;
            x2 = x3 = xx+CW/2;
            y1 = y2 = yy-CW/2;
            y3 = y4 = yy+CW/2;
            $("canvas").drawLine({
                strokeStyle: c,
                strokeWidth: 2,
                x1: x1+length, y1: y1,
                x2: x1, y2: y1,
                x3: x1, y3: y1+length,
            });
            $("canvas").drawLine({
                strokeStyle: c,
                strokeWidth: 2,
                x1: x2-length, y1: y2,
                x2: x2, y2: y2,
                x3: x2, y3: y2+length,
            });
            $("canvas").drawLine({
                strokeStyle: c,
                strokeWidth: 2,
                x1: x3-length, y1: y3,
                x2: x3, y2: y3,
                x3: x3, y3: y3-length,
            });
            $("canvas").drawLine({
                strokeStyle: c,
                strokeWidth: 2,
                x1: x4+length, y1: y4,
                x2: x4, y2: y4,
                x3: x4, y3: y4-length,
            });
        }

        var lastCX=-1,lastCY=-1;
        function highlightCell(cx,cy){
            if(lastCX==cx && lastCY==cy){
                return;
            }
            if(lastCX>=1 && lastCX<=BS && lastCX>=1 && lastCX<=BS){
                drawCell(lastCX,lastCY,bgColor);
            }
            if(cx>=1 && cx<=BS && cy>=1 && cy<=BS){
                drawCell(cx,cy,highlightCellColor);
            }
            lastCX=cx;
            lastCY=cy;
        }

        function turn(){
            $("canvas").unbind();
            var winSide=bd.isGameOver();
            if(winSide>0){
                if(!showOrder){
                    showOrder = true;
                    drawBoard();
                    showOrder = false;
                }
                if(winSide == humanSide){
                    window.alert("你赢了!");
                }
                else if(winSide == computerSide){
                    window.alert("你输了!");
                }
                else{
                    window.alert("双方平手!");
                }
                return;
            }

            if(bd.getPlayer() == humanSide || manual){
                drawCell(lastCX,lastCY,highlightCellColor);
                $("canvas").mousemove(function(event) {
                    var position = $("canvas").position();
                    var cx = Math.round((event.pageX - position.left - OS)/CW)+1;
                    var cy = Math.round((event.pageY - position.top - OS)/CW)+1;
                    if(cx>=1 && cx<=BS && cy>=1 && cy<=BS){
                        highlightCell(cx,cy);
                    }
                });
                $("canvas").click(function(event) {
                    var position = $("canvas").position();
                    var cx = Math.round((event.pageX - position.left - OS)/CW)+1;
                    var cy = Math.round((event.pageY - position.top - OS)/CW)+1;
                    putChess(cx,cy);
                });
            }
            else if(bd.getPlayer() == computerSide){
                var step = br.findBestStep(bd);
                if(step!=null){
                    putChess(step[0],step[1]);
                }
            }
        }

        function troggleManual(){
            manual = !manual;
            $('#troggleBtn').val(manual?"Human":"Computer");
        }

        function troggleOrder(){
            showOrder = $('#orderChk').is(':checked');
            drawBoard();
        }
    </script>
</head>
<body>
<table>
    <tr>
        <td valign="top">
            <div style="height:540px;font-size:20px;font-family:Arial">
                <div id="welcome">
                    <span style="font-size:40px;font-family:Arial;color:red">五子棋<br/></span>
                    <span style="font-size:15px;font-family:Arial;text-align:right;">Author:<a href="http://weibo.com/yssss1980">@殷山</a></span>
                </div>

                <hr/>

                <div id="opera">
                    <fieldset>
                        <legend>落子</legend>
                        <input type="radio" name="side" value="BLACK" checked/> 黑方<br/>
                        <input type="radio" name="side" value="WHITE"/> 白方 <br/>
                    </fieldset>
                    <br/>

                    <fieldset>
                        <legend>难度</legend>
                        <input type="radio" name="level" value="0"/> 傻瓜<br/>
                        <input type="radio" name="level" value="1"/> 简单<br/>
                        <input type="radio" name="level" value="2" checked/> 中等<br/>
                        <input type="radio" name="level" value="3"/> 困难 <br/>
                    </fieldset>
                    <br/>

                    <input type="checkbox" id="orderChk" onclick="troggleOrder()"/>显示落子次序
                    <br/><br/>

                    <input class="button" type="button" onclick="newGame()" value="新游戏"/>
                    <br/>
                    <input class="button" type="button" onclick="regret()" value="悔棋"/>
                    <br/>
                </div>
                <br/>
            </div>
        </td>
        <td>
            <canvas id="bdcanvas" width="640" height="640" style="background:darkorange"></canvas>
        </td>
    </tr>
</table>
<div id="log"></div>
</body>
</html>
