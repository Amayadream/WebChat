<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>WebChat | 关于</title>
    <jsp:include page="include/commonfile.jsp"/>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="am-cf admin-main">
    <jsp:include page="include/sidebar.jsp"/>

    <!-- content start -->
    <div class="admin-content">
        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">关于</strong> / <small>about</small></div>
        </div>
        <div class="am-tabs am-margin" data-am-tabs>
            <ul class="am-tabs-nav am-nav am-nav-tabs">
                <li class="am-active"><a href="#tab1">所用技术</a></li>
                <li><a href="#tab2">获取源码</a></li>
                <li><a href="#tab3">关于作者</a></li>
            </ul>
            <div class="am-tabs-bd">
                <div class="am-tab-panel am-fade am-in am-active" id="tab1">
                    <hr>
                    <blockquote>
                        <p>WebChat主要使用SSM框架,即Spring + Spring MVC + Mybatis</p>
                        <p>通讯使用的是websocket</p>
                        <p>数据库使用的是Oracle 10g express版</p>
                        <p>前端框架采用的是<a href="http://http://amazeui.org" target="_blank">Amaze UI</a>,弹窗控件和分页控件采用的是<a href="http://http://layer.layui.com/" target="_blank">Layer</a>和<a href="http://http://laypage.layui.com/" target="_blank">Laypage</a></p>
                    </blockquote>
                </div>

                <div class="am-tab-panel am-fade am-in" id="tab2">
                    <hr>
                    <blockquote>
                        <p><a href="https://github.com/Amayadream/WebChat" target="_blank">https://github.com/Amayadream/WebChat</a></p>
                    </blockquote>
                </div>

                <div class="am-tab-panel am-fade am-in" id="tab3">
                    <hr>
                    <blockquote>
                        <p>欢迎访问我的个人网站<a href="http://www.amayadream.com" target="_blank">Amayadream.com</a>,虽然并没有什么东西可看</p>
                        <p>也欢迎访问我的github, <a href="https://github.com/Amayadream" target="_blank">github.com/Amayadream</a></p>
                    </blockquote>
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
