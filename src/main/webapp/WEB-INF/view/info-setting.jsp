<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>WebChat | 个人设置</title>
    <jsp:include page="include/commonfile.jsp"/>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="am-cf admin-main">
    <jsp:include page="include/sidebar.jsp"/>

    <!-- content start -->
    <div class="admin-content">

        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人设置</strong> / <small>form</small></div>
        </div>

        <div class="am-tabs am-margin" data-am-tabs>
            <ul class="am-tabs-nav am-nav am-nav-tabs">
                <li class="am-active"><a href="#tab1">基本信息</a></li>
                <li><a href="#tab2">修改头像</a></li>
                <li><a href="#tab3">修改密码</a></li>
            </ul>

            <div class="am-tabs-bd">
                <div class="am-tab-panel am-fade am-in am-active" id="tab1">
                    <c:set value="${user}" var="user"/>
                    <form class="am-form am-form-horizontal" id="information-form" action="${ctx}/${userid}/update" method="post" data-am-validator>
                        <div class="am-form-group">
                            <label for="userid" class="am-u-sm-2 am-form-label">用户名</label>
                            <div class="am-u-sm-10">
                                <input type="text" id="userid" name="userid" value="${user.userid}" disabled>
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="nickname" class="am-u-sm-2 am-form-label">昵称</label>
                            <div class="am-u-sm-10">
                                <input type="text" id="nickname" name="nickname" value="${user.nickname}" required placeholder="这里输入你的昵称...">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="sex" class="am-u-sm-2 am-form-label">性别</label>
                            <div class="am-u-sm-10">
                                <select id="sex" name="sex" data-am-selected>
                                    <option selected></option>
                                    <option value="1">男</option>
                                    <option value="0">女</option>
                                    <option value="-1">保密</option>
                                </select>
                            </div>
                            <script>
                                $('#sex').find('option').eq(${user.sex}).attr('selected', true);
                            </script>
                        </div>
                        <div class="am-form-group">
                            <label for="age" class="am-u-sm-2 am-form-label">年龄</label>
                            <div class="am-u-sm-10">
                                <input type="number" id="age" name="age" min="1" max="100" value="${user.age}" placeholder="这里输入你的年龄...">
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="profile" class="am-u-sm-2 am-form-label">个性签名</label>
                            <div class="am-u-sm-10">
                                <textarea class="" id="profile" name="profile" rows="5" placeholder="这里可以写下你的个性签名..."></textarea>
                            </div>
                            <script>
                                $("#profile").val("${user.profile}");
                            </script>
                        </div>
                        <div class="am-form-group">
                            <div class="am-u-sm-10 am-u-sm-offset-2">
                                <button type="submit" class="am-btn am-round am-btn-success"><span class="am-icon-send"></span> 提交</button>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="am-tab-panel am-fade" id="tab2">
                    <form class="am-form am-form-horizontal" action="${ctx}/${userid}/upload" enctype="multipart/form-data" method="post" onsubmit="return checkFileType();" style="text-align: center;">
                        <div style="text-align: center;margin-bottom: 10px">
                            <img class="am-circle" src="${ctx}/${user.profilehead}" width="140" height="140" alt="Amayadream"/>
                        </div>
                        <div class="am-form-group am-form-file">
                            <button type="button" class="am-btn am-btn-secondary am-btn-sm">
                                <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
                            <input id="file" type="file" name="file" multiple>
                        </div>
                        <div id="file-list"></div>
                        <button type="submit" class="am-btn am-round am-btn-success"><span class="am-icon-upload"></span> 上传头像</button>
                        <script>
                            $(function() {
                                $('#file').on('change', function() {
                                    var fileNames = '';
                                    $.each(this.files, function() {
                                        fileNames += '<span class="am-badge">' + this.name + '</span> ';
                                    });
                                    $('#file-list').html(fileNames);
                                });
                            });
                        </script>
                    </form>
                </div>

                <div class="am-tab-panel am-fade" id="tab3">
                    <form class="am-form am-form-horizontal" data-am-validator action="${ctx}/${userid}/pass" method="post">
                        <div class="am-form-group">
                            <label for="password1" class="am-u-sm-2 am-form-label">原密码</label>
                            <div class="am-u-sm-10">
                                <input type="password" id="password1" name="oldpass" required placeholder="请输入原密码...">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="password2" class="am-u-sm-2 am-form-label">新密码</label>
                            <div class="am-u-sm-10">
                                <input type="password" id="password2" name="newpass" required placeholder="请输入新密码...">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="password3" class="am-u-sm-2 am-form-label">确认新密码</label>
                            <div class="am-u-sm-10">
                                <input type="password" id="password3" data-equal-to="#password2" required placeholder="请确认新密码...">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <div class="am-u-sm-10 am-u-sm-offset-2">
                                <button type="submit" class="am-btn am-round am-btn-success"><span class="am-icon-send"></span> 提交修改</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- content end -->
</div>
<a href="#" class="am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}">
    <span class="am-icon-btn am-icon-th-list"></span>
</a>
<jsp:include page="include/footer.jsp"/>
<script>
    if("${message}"){
        layer.msg('${message}', {
            offset: 0,
        });
    }
    if("${error}"){
        layer.msg('${error}', {
            offset: 0,
            shift: 6
        });
    }

    function checkFileType(){
        var format = ["bmp","jpg","gif","png"];
        var filename = $("#file").val();
        var ext = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();
        if(jQuery.inArray(ext, format) != -1){
            return true;
        }else{
            layer.msg('头像格式只能是bmp,jpg,gif,png!', {
                offset: 0,
                shift: 6
            });
            return false;
        }
    }
</script>
</body>
</html>
