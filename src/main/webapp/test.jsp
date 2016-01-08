<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/plugins/bootstrap/css/bootstrap.min.css">
    <script src="<%=path%>/plugins/jquery/jquery-2.1.4.min.js"></script>
    <script src="<%=path%>/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path%>/plugins/layer/layer.js"></script>
    <script src="<%=path%>/plugins/sockjs/sockjs.js"></script>
    <style>
        html, body, .container-fluid{
            height : 100%;
        }
        .chat{
            width: 80%;
            height: 97%;
            float: left;
        }
        .friend{
            width: 20%;
            height: 97%;
            float: right;
        }
        .chat-info{
            height: 72%;
        }
        .chat-form{
            height: auto;
        }
        .chat-tool{
            float: right;
            margin-top: 10px;
        }
        #send{
            margin-left: 20px;;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="chat well">
        <h2>群聊</h2>
        <div class="chat-info"></div>
        <div class="chat-form">
            <textarea class="form-control" rows="3" id="message" placeholder="在这里输入你的聊天内容..."></textarea>
        </div>
        <div class="chat-tool">
            <button class="btn btn-primary" onclick="getConnection()">连接</button>
            <button class="btn btn-danger" onclick="closeConnection()">断开</button>
            <button class="btn btn-primary" onclick="checkStatus();">查看连接状态</button>
            <button class="btn btn-danger" onclick="clearConsole();">清屏</button>
            <button class="btn btn-success" id="send" onclick="sendMessage()">发送</button>
        </div>
    </div>
    <div class="friend well">
        <h2>在线列表</h2>
    </div>
</div>

<script>
    var wsServer = null;
    var ws = null;
    wsServer = "ws://" + location.host+"${pageContext.request.contextPath}" + "/ws";
    ws = new WebSocket(wsServer); //创建WebSocket对象
    ws.onopen = function (evt) {
        layer.msg("已经建立连接", { offset: 0, shift: 6 });
    };
    ws.onmessage = function (evt) {
        showMessage("Received:" + evt.data)
    };
    ws.onerror = function (evt) {
        layer.msg("产生异常", { offset: 0, shift: 6 });
    };
    ws.onclose = function (evt) {
        layer.msg("已经关闭连接", { offset: 0, shift: 6 });
    };
    function getConnection(){
        if(ws == null){
            ws = new WebSocket(wsServer); //创建WebSocket对象
            ws.onopen = function (evt) {
                layer.msg("成功建立连接!", { offset: 0, shift: 6 });
            };
        }else{
            layer.msg("连接已存在!", { offset: 0, shift: 6 });
        }

    }

    function closeConnection(){
        if(ws != null){
            ws.close();
            ws = null;
            layer.msg("已经关闭连接", { offset: 0, shift: 6 });
        }else{
            layer.msg("未开启连接", { offset: 0, shift: 6 });
        }
    }

    function checkStatus(){
        if(ws != null){
            layer.msg(ws.readyState == 0? "连接异常":"连接正常", { offset: 0, shift: 6 });
        }else{
            layer.msg("连接未开启!", { offset: 0, shift: 6 });
        }
    }

    function sendMessage(){
        if(ws == null){
            layer.msg("连接未开启!", { offset: 0, shift: 6 });
        }else{
            var message = $("#message").val();
            ws.send(message);
        }
    }

    function showMessage(message){
        var consoles = $(".chat-info");
        consoles.append("<p>"+message+"</p>");
    }

    function clearConsole(){
        $(".chat-info").html("");
    }
</script>
</body>
</html>
