<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/9
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
%>
<html>
<head>
    <title>管理流程</title>
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
<table id="list" class="easyui-datagrid" toolbar="#tb" style="height:100%;"
       data-options="singleSelect:false,
			collapsible:true,
			url:'<%=path %>/admin/toViewAllProcess',
			method:'post',
			rownumbers:true,
			autoRowHeight:true,
			pagination:true,
			pageSize:20">
    <thead>
    <tr>
        <th field="ID" checkbox="true" width="50">ID</th>
        <th field="REV" width="150">增长</th>
        <th field="CATEGORY" width="150">种类</th>
    </tr>
    </thead>
</table>
</body>
</html>
