<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 26/02/2017
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
%>
<html>
<head>
    <title>角色管理</title>
    <link id="easyuiThemes" href="/js/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
    <link href="/js/themes/insdep/default_theme.css" rel="stylesheet" type="text/css">
    <link href="/js/themes/insdep/master.css" rel="stylesheet" type="text/css"/>
    <link href="/css/site_main.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/themes/insdep/jquery.insdep-extend.min.js"></script>
    <script type="text/javascript" src="/script/site_easyui.js"></script>
</head>
<body>
<table id="list" class="easyui-datagrid" toolbar="#tb" style="height:100%;"
       data-options="singleSelect:false,
			collapsible:true,
			url:'<%=path %>/role/serach_role',
			method:'post',
			rownumbers:true,
			autoRowHeight:true,
			pagination:true,
			pageSize:20">
    <thead>
    <tr>
        <th field="id" checkbox="true" width="50">角色id</th>
        <th field="email" width="150">name</th>
    </tr>
    </thead>
</table>
<div id="tb" style="padding:5px;height:auto">
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true"
       onclick="showAddWin();">添加</a>
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
       onclick="showEditWin();">修改</a>
</div>

<%--添加商品--%>
<div id="addWin" class="easyui-window" title="添加用户" data-options="closed:true"
     style="width:500px;height:300px; align: center;">
    <form:form id="addForm" modelAttribute="product" method="post">
        <table>

        </table>
    </form:form>
</div>

<div id="editWin" class="easyui-window" title="修改用户" data-options="closed:true" style="width:500px;height:300px;">
    <form:form id="addForm" modelAttribute="product" method="post">
        <table>

        </table>
    </form:form>
</div>
</body>
</html>
