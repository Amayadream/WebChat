<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>WebChat | 系统设置</title>
    <jsp:include page="include/commonfile.jsp"/>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="am-cf admin-main">
    <jsp:include page="include/sidebar.jsp"/>

    <!-- content start -->
    <div class="admin-content">

        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">系统设置</strong> / <small>form</small></div>
        </div>

        <div class="am-tabs am-margin" data-am-tabs>
            <ul class="am-tabs-nav am-nav am-nav-tabs">
                <li class="am-active"><a href="#tab1">基本设置</a></li>
                <li><a href="#tab2">修改头像</a></li>
                <li><a href="#tab3">修改密码</a></li>
            </ul>

            <div class="am-tabs-bd">
                <div class="am-tab-panel am-fade am-in am-active" id="tab1">
                    <form class="am-form am-form-horizontal">
                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">分页大小</label>
                            <div class="am-u-sm-10">
                                <div class="am-btn-group" data-am-button>
                                    <label class="am-btn am-btn-secondary am-btn-sm">
                                        <input type="radio" name="options"> 5
                                    </label>
                                    <label class="am-btn am-btn-secondary am-btn-sm">
                                        <input type="radio" name="options"> 10
                                    </label>
                                    <label class="am-btn am-btn-secondary am-btn-sm">
                                        <input type="radio" name="options"> 15
                                    </label>
                                    <label class="am-btn am-btn-secondary am-btn-sm">
                                        <input type="radio" name="options"> 20
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">好友进出提示</label>
                            <div class="am-u-sm-10">
                                <div class="am-btn-group" data-am-button>
                                    <label class="am-btn am-btn-secondary am-btn-sm">
                                        <input type="radio" name="options"> 提示
                                    </label>
                                    <label class="am-btn am-btn-secondary am-btn-sm">
                                        <input type="radio" name="options"> 不提示
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">在线人数显示</label>
                            <div class="am-u-sm-10">
                                <div class="am-btn-group" data-am-button>
                                    <label class="am-btn am-btn-secondary am-btn-sm">
                                        <input type="radio" name="options"> 显示
                                    </label>
                                    <label class="am-btn am-btn-secondary am-btn-sm">
                                        <input type="radio" name="options"> 不显示
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">我的信息</label>
                            <div class="am-u-sm-10">
                                <div class="am-btn-group" data-am-button>
                                    <label class="am-btn am-btn-secondary am-btn-sm">
                                        <input type="radio" name="options"> 允许被查看
                                    </label>
                                    <label class="am-btn am-btn-secondary am-btn-sm">
                                        <input type="radio" name="options"> 不允许查看
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="am-form-group">
                            <div class="am-u-sm-10 am-u-sm-offset-2">
                                <button type="submit" class="am-btn am-round am-btn-success"><span class="am-icon-send"></span> 提交</button>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="am-tab-panel am-fade" id="tab2">
                    <form class="am-form am-form-horizontal" style="text-align: center;">
                        <div style="text-align: center;margin-bottom: 10px">
                            <img class="am-circle" src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg?imageView/1/w/1000/h/1000/q/80" width="140" height="140" alt="Amayadream"/>
                        </div>
                        <div class="am-form-group am-form-file">
                            <button type="button" class="am-btn am-btn-secondary am-btn-sm">
                                <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
                            <input id="doc-form-file" type="file" multiple>
                        </div>
                        <div id="file-list"></div>
                        <button class="am-btn am-round am-btn-success"><span class="am-icon-upload"></span> 上传头像</button>
                        <script>
                            $(function() {
                                $('#doc-form-file').on('change', function() {
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
                    <form class="am-form am-form-horizontal">
                        <div class="am-form-group">
                            <label for="password1" class="am-u-sm-2 am-form-label">原密码</label>
                            <div class="am-u-sm-10">
                                <input type="password" id="password1" required placeholder="请输入原密码...">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="password2" class="am-u-sm-2 am-form-label">新密码</label>
                            <div class="am-u-sm-10">
                                <input type="password" id="password2" required placeholder="请输入新密码...">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="password3" class="am-u-sm-2 am-form-label">新密码</label>
                            <div class="am-u-sm-10">
                                <input type="password" id="password3" required placeholder="请确认新密码...">
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
</body>
</html>
