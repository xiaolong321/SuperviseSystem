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
    <script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/script/user/user.js"></script>
    <script type="text/javascript" src="<%=path%>/js/themes/insdep/jquery.insdep-extend.min.js"></script>
</head>
<body style="text-align: center;">
<div style="margin: 0 auto;" id="editWin">
    <form:form id="editForm" modelAttribute="user" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input class="easyui-textbox" name="username"></td>
            </tr>
            <tr>
                <td>手机号</td>
                <td><input class="easyui-textbox" name="phone"></td>
            </tr>
            <tr>
                <td>家庭地址</td>
                <td><input class="easyui-textbox" name="address"></td>
            </tr>
            <tr>
                <td>
                    <a href="javascript:;" onclick="editInfo();" class="easyui-linkbutton">确认</a>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>