<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>用户登陆</title>
    <link href="<%=path%>/js/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/js/themes/insdep/master.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/js/themes/insdep/icon.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/js/themes/insdep/default_theme.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/script/user/user.js"></script>
    <script type="text/javascript" src="<%=path%>/js/themes/insdep/jquery.insdep-extend.min.js"></script>
    <script type="text/javascript" src="<%=path%>/script/user/user.js"></script>
</head>
<body class="theme-login-layout">
<div class="theme-login-header"></div>
<div id="theme-login-form">
    <div class="QRcode"></div>
    <div class="QRcode-layout hide">
        <div class="QRcode-layout-close"></div>
        <div class="QRcode-header">
            <b>APP扫码登录</b>
            <span>请使用最新版APP进行扫码登录</span>
        </div>
        <div class="QRcode-content"><img src="/images/headicon/傲娇.jpg" width="176px"></div>
    </div>
    <p id="errMsg" style="color: red;"></p>
    <form id="login_form" method="post">
        <dl>
            <dt><img src="/images/headicon/login.jpg"></dt>
            <dd><input type="text" id="email" name="email" style="width:100%;"/></dd>
            <dd><input type="password" id="password" name="password" style="width:100%;"/></dd>
            <dd>
                <a class="submit" onclick="login();">登陆</a>
                <a class="easyui-linkbutton button" href="/user/registerPager">注册</a>
                <a class="easyui-linkbutton button" href="#">忘记密码？</a>
            </dd>
        </dl>
    </form>
</div>


</body>
</html>