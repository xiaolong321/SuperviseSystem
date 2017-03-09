<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/8
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>管理员中心</title>
    <link id="easyuiThemes" href="/js/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
    <link href="/js/themes/insdep/default_theme.css" rel="stylesheet" type="text/css">
    <link href="/js/themes/insdep/master.css" rel="stylesheet" type="text/css"/>
    <link href="/css/site_main.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/themes/insdep/jquery.insdep-extend.min.js"></script>
    <script type="text/javascript" src="/script/admin/admin.js"></script>
    <script type="text/javascript" src="/script/site_easyui.js"></script>
</head>
<body>
<form:form id="add_form" method="post" modelAttribute="admin">
    <p id="errMsg" style="color: red;text-align: center;"></p>
    <table class="input_big">
        <caption>添加新的管理员</caption>
        <tr>
            <td>账号</td>
            <td><input type="email" name="email" class="easyui-validatebox easyui-textbox"
                       data-options="required:true,validType:'length[6,20]',novalidate:true"/></td>
        </tr>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" class="easyui-validatebox easyui-textbox"
                       data-options="required:true,validType:'length[2,20]',novalidate:true"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" class="easyui-validatebox easyui-textbox"
                       data-options="required:true,validType:'length[6,20]',novalidate:true"/></td>
        </tr>
        <tr>
            <td>确认密码:</td>
            <td><input type="password" name="conPassword" class="easyui-validatebox easyui-textbox"
                       data-options="required:true,validType:'length[6,20]',novalidate:true"/></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input class="easyui-textbox" id="checkCode" type="text" name="checkCode"
                       style="width:120px;height:35px;padding:12px"
                       data-options="prompt:'验证码',required:true">
                <a href="javascript:;">
                    <img style=" margin:0 0 0 3px ; vertical-align:middle; height:35px;"
                         src="<%=path %>/kaptch"
                         onclick="this.src='<%=path %>/kaptch?time=Math.random();'">
                </a>
            </td>

        </tr>
        <tr>
            <td></td>
            <td>
                <button type="button" onclick="addAdmin();">添加</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
