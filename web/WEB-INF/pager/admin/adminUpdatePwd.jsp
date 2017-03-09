<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>用户中心</title>
    <link href="<%=path%>/js/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/js/themes/insdep/master.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/js/themes/insdep/icon.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/css/site_main.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/script/admin/admin.js"></script>
    <script type="text/javascript" src="<%=path%>/script/site_easyui.js"></script>
    <script type="text/javascript" src="<%=path%>/js/themes/insdep/jquery.insdep-extend.min.js"></script>
</head>
<body>
<div id="errMsg"></div>
<form:form id="updateForm" method="post" modelAttribute="admin">
    <table class="input_big">
        <caption>修改账号密码</caption>
        <tr>
            <td>账号</td>
            <td>${sessionScope.admin.email}</td>
        </tr>
        <tr>
            <td>原密码：</td>
            <td><input type="password" name="password" class="easyui-validatebox easyui-textbox"
                       data-options="required:true,validType:'length[6,20]',novalidate:true"/></td>
        </tr>
        <tr>
            <td>新密码:</td>
            <td><input id="newPwd" type="password" name="newPwd" class="easyui-validatebox easyui-textbox"
                       data-options="required:true,validType:'length[6,20]',novalidate:true"/></td>
        </tr>
        <tr>
            <td>确认密码:</td>
            <td><input type="password" name="conPwd" class="easyui-validatebox easyui-textbox"
                       data-options="required:true,validType:'length[6,20]',novalidate:true"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="button" onclick="changePwd();">确认</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>