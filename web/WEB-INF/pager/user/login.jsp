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
    <script type="text/javascript" src="<%=path%>/js/themes/insdep/jquery.insdep-extend.min.js"></script>
    <script type="text/javascript" src="<%=path%>/script/user/user.js"></script>
    <style type="text/css">
        .layout-panel-west {
            border-right: 1px solid #c5c5c5;
        }
    </style>
</head>
<body class="theme-login-layout">
<div class="theme-login-header"></div>
<div id="theme-login-form">
    <div class="QRcode"></div>
    <div class="QRcode-layout hide">
        <div class="QRcode-layout-close"></div>
        <div class="QRcode-header">
            <b>APP扫码登录</b>
            <span>暂时没有app，不给你扫~\(≧▽≦)/~啦啦啦</span>
        </div>
        <div class="QRcode-content"><img src="/uploads/images/headicon/傲娇.jpg" width="176px"></div>
    </div>
    <form:form id="login_form" class="theme-login-form" method="post" modelAttribute="user">
        <dl>
            <dt><img src="/uploads/images/headicon/login.jpg"></dt>
            <dd>
                <select id="theme-login-select" class="theme-login-select" style="width:100%;">
                    <option value="0">请选择用户类型</option>
                    <option value="1">教师</option>
                    <option value="2">学生</option>
                </select>
            </dd>
            <dd>
                <hgroup class="group-mail">
                    <input id="mail" name="mail"/>
                    <label>@</label>
                    <select id="mail-add" style="width:145px;">
                        <option value="0">qq.com</option>
                        <option value="1">163.com</option>
                        <option value="2">126.com</option>
                        <option value="3">gmail.com</option>
                    </select>
                </hgroup>
            </dd>
            <dd><input id="username" name="username" class="theme-login-text" style="width:100%;"/></dd>
            <dd><input id="password" name="password" class="theme-login-text" style="width:100%;"/></dd>
            <dd>
                <a class="submit" onclick="login();">登陆</a>
                <a class="easyui-linkbutton button" onclick="userRegister();">注册</a>
                <a class="easyui-linkbutton button" onclick="changePwd();">忘记密码？</a>
            </dd>
        </dl>
    </form:form>
</div>
<%--弹出修改页面的面板--%>
<div class="navigate-user-panel">
    <dl>

    </dl>
</div>
<script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?76386f607e79e997458a326997f1be87";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>
</html>