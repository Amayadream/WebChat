<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title></title>
    <jsp:include page="include/commonfile.jsp"/>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="am-cf admin-main">
    <jsp:include page="include/sidebar.jsp"/>

    <!-- content start -->
    <div class="admin-content">
        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">系统日志</strong> / <small>log</small></div>
        </div>
        <div class="am-tabs am-margin">
            <table class="am-table am-table-striped">
                <thead>
                <tr>
                    <th>网站名称</th>
                    <th>网址</th>
                    <th>创建时间</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Amaze UI</td>
                    <td>http://amazeui.org</td>
                    <td>2012-10-01</td>
                </tr>
                <tr>
                    <td>Amaze UI</td>
                    <td>http://amazeui.org</td>
                    <td>2012-10-01</td>
                </tr>
                <tr>
                    <td>Amaze UI(Active)</td>
                    <td>http://amazeui.org</td>
                    <td>2012-10-01</td>
                </tr>
                <tr>
                    <td>Amaze UI</td>
                    <td>http://amazeui.org</td>
                    <td>2012-10-01</td>
                </tr>
                <tr>
                    <td>Amaze UI</td>
                    <td>http://amazeui.org</td>
                    <td>2012-10-01</td>
                </tr>
                </tbody>
            </table>
        </div>
        <ul class="am-pagination am-pagination-right">
            <li class="am-disabled"><a href="#">&laquo;</a></li>
            <li class="am-active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">&raquo;</a></li>
        </ul>
    </div>
    <!-- content end -->
</div>
<a href="#" class="am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}">
    <span class="am-icon-btn am-icon-th-list"></span>
</a>
<jsp:include page="include/footer.jsp"/>
</body>
</html>
