<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>WebChat | 聊天</title>
    <jsp:include page="include/commonfile.jsp"/>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="am-cf admin-main">
    <jsp:include page="include/sidebar.jsp"/>

    <!-- content start -->
    <div class="admin-content">
        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">聊天</strong> / <small>chat</small></div>
        </div>

        <div class="am-scrollable-vertical" style="height: 450px;">
            <ul class="am-comments-list am-comments-list-flip">
                <li class="am-comment am-comment-primary">
                    <a href="#link-to-user-home">
                        <img width="48" height="48" class="am-comment-avatar" alt="" src="">
                    </a>
                    <div class="am-comment-main">
                        <header class="am-comment-hd">
                            <div class="am-comment-meta">   <a class="am-comment-author" href="#link-to-user">路人乙</a> 发表于
                                <time title="2013年7月27日 下午7:54 格林尼治标准时间+0800" datetime="2013-07-27T04:54:29-07:00">2014-7-14 23:30</time>
                            </div>
                        </header>
                        <div class="am-comment-bd">
                            <p> <a href="#lin-to-user">@某人</a> 撸主保重！</p>
                        </div>
                    </div>
                </li>
                <li class="am-comment am-comment-primary">
                    <a href="#link-to-user-home">
                        <img width="48" height="48" class="am-comment-avatar" alt="" src="">
                    </a>
                    <div class="am-comment-main">
                        <header class="am-comment-hd">
                            <div class="am-comment-meta">   <a class="am-comment-author" href="#link-to-user">某人</a> 发表于
                                <time title="2013年7月27日 下午7:54 格林尼治标准时间+0800" datetime="2013-07-27T04:54:29-07:00">2014-7-14 23:301</time>
                            </div>
                        </header>
                        <div class="am-comment-bd">
                            <p> <a href="#lurenyi">@路人乙</a> 朕知道了！</p>
                        </div>
                    </div>
                </li>
                <li class="am-comment am-comment-flip am-comment-success">
                    <a href="#link-to-user-home">
                        <img width="48" height="48" class="am-comment-avatar" alt="" src="">
                    </a>
                    <div class="am-comment-main">
                        <header class="am-comment-hd">
                            <div class="am-comment-meta">   <a class="am-comment-author" href="#link-to-user">路人乙</a> 发表于
                                <time title="2013年7月27日 下午7:54 格林尼治标准时间+0800" datetime="2013-07-27T04:54:29-07:00">2014-7-14 23:32</time>
                            </div>
                        </header>
                        <div class="am-comment-bd">
                            <p> <a href="#lin-to-user">@某人</a> 你妹！</p>
                        </div>
                    </div>
                </li>
                <li class="am-comment am-comment-primary">
                    <a href="#link-to-user-home">
                        <img width="48" height="48" class="am-comment-avatar" alt="" src="">
                    </a>
                    <div class="am-comment-main">
                        <header class="am-comment-hd">
                            <div class="am-comment-meta">   <a class="am-comment-author" href="#link-to-user">某人</a> 发表于
                                <time title="2013年7月27日 下午7:54 格林尼治标准时间+0800" datetime="2013-07-27T04:54:29-07:00">2014-7-14 23:301</time>
                            </div>
                        </header>
                        <div class="am-comment-bd">
                            <p> <a href="#lurenyi">@路人乙</a> 你妹你妹！</p>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <div>
            <div class="am-form-group am-form">
                <textarea class="" id="message" name="message" rows="5"  placeholder="这里输入你想发送的信息..."></textarea>
            </div>
            <div class="am-btn-group am-btn-group-xs" style="float:right;">
                <button class="am-btn am-btn-default" type="button"><span class="am-icon-plug"></span> 连接</button>
                <button class="am-btn am-btn-default" type="button"><span class="am-icon-remove"></span> 断开</button>
                <button class="am-btn am-btn-default" type="button"><span class="am-icon-bug"></span> 检查</button>
                <button class="am-btn am-btn-default" type="button"><span class="am-icon-trash-o"></span> 清屏</button>
                <button class="am-btn am-btn-default" type="button"><span class="am-icon-commenting"></span> 发送</button>
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
</script>
</body>
</html>
