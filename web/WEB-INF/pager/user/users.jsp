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
    <script type="text/javascript" src="<%=path%>/script/site_easyui.js"></script>
    <script type="text/javascript" src="<%=path%>/js/themes/insdep/jquery.insdep-extend.min.js"></script>
</head>
<body>
<table id="list" class="easyui-datagrid" toolbar="#tb" style="height:100%;"
       data-options="singleSelect:false,
			collapsible:true,
			url:'<%=path %>/user/serach_page',
			method:'post',
			rownumbers:true,
			autoRowHeight:true,
			pagination:true,
			pageSize:20">
    <thead>
    <tr>
        <th field="id" checkbox="true" width="50">用户id</th>
        <th field="email" width="150">邮箱</th>
        <th field="username" width="100">用户名</th>
        <th field="phone" width="80">手机号</th>
        <th field="address" width="200">地址</th>
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