<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <title>登录</title>
    <jsp:include page="include/common.jsp"/>
</head>
<body>
<div>
    <form method="post" action="${ctx}/auth/login">
        <input type="text" name="userId" id="userId">
        <input type="password" name="password" id="password">
        <button type="submit">登录</button>
        <button type="button" onclick="window.location = '${ctx}/auth/register'">注册</button>
    </form>
</div>
<script>
    $(function(){
        if("${message}"){
            layui.use('layer', function(){
                var layer = layui.layer;
                layer.msg('${message}', { offset: 0 });
            });
        }
        if("${error}"){
            layui.use('layer', function(){
                var layer = layui.layer;
                layer.msg('${error}', { offset: 0, shift: 6 });
            });
        }
    });
</script>
</body>
</html>