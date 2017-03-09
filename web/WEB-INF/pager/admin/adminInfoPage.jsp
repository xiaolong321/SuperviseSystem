<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
%>
<html>
<head>
    <title>管理员信息</title>
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
<table id="info" class="site_table">
    <caption>我的基本信息</caption>
    <thead>
    <tr>
        <th>名称</th>
        <th>值</th>
    </tr>
    <tr>
        <td>邮箱</td>
        <td>${requestScope.admin.email }</td>
    </tr>
    <tr>
        <td>用户名</td>
        <td>${requestScope.admin.username }</td>
    </tr>
    <tr>
        <td>手机</td>
        <td>${requestScope.admin.phone }</td>
    </tr>
    <tr>
        <td>地址</td>
        <td>${requestScope.admin.address }</td>
    </tr>
    </thead>
</table>
<div>
    <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
       onclick="openWin('editWin')">修改</a>
</div>
<div class="easyui-window site_win_small input_big" id="editWin" data-options="title:'修改账号信息',resizable:false,mode:true,closed:true">
    <form:form id="editForm" modelAttribute="admin" method="post" >
        <form:hidden path="id"/>
        <table>
            <tr>
                <td>昵称</td>
                <td><form:input type="text" name="username" path="username" class="easyui-validatebox easyui-textbox"
                                data-options="required:true,novalidate:true"/></td>
            </tr>
            <tr>
                <td>手机</td>
                <td><form:input type="text" name="phone" path="phone" class="easyui-numberbox easyui-textbox"
                                data-options="required:true,validType:'length[11,11]',novalidate:true"/></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><form:input type="text" class="easyui-textbox" name="address" data-options="multiline:true" path="address" cssStyle="height: 100px;"/></td>
            </tr>
            <tr>
                <td><button type="button" onclick="closeWin('editWin');">取消</button></td>
                <td>
                    <button type="button" onclick="editInfo();">确认</button>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>