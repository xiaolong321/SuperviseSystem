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
    <script type="text/javascript" src="<%=path%>/script/site_easyui.js"></script>
    <script type="text/javascript" src="<%=path%>/js/themes/insdep/jquery.insdep-extend.min.js"></script>
</head>
<body style="background: url('/images/bg/login_bg.jpeg');">
<div class="login_container">
    <div class="easyui-window" title="请先登录"
         data-options="modal:true,closed:false,iconCls:'Lockgo',closable:false,minimizable:false,maximizable:false"
         style="width:400px;padding:20px 70px 20px 70px;">
        <form:form id="login_form" method="post" modelAttribute="user">
            <p id="errMsg" style="color: red;text-align: center;"></p>
            <div style="margin-bottom:10px">
                <input class="easyui-textbox" id="email" name="email" style="width:100%;height:35px;padding:12px"
                       data-options="prompt:'登录邮箱',iconCls:'icon-man',iconWidth:38,required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" id="password" name="password" type="password"
                       style="width:100%;height:35px;padding:12px"
                       data-options="prompt:'登录密码',iconCls:'icon-lock',iconWidth:38,required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" id="checkCode" type="text" name="checkCode" style="width:50%;height:35px;padding:12px"
                       data-options="prompt:'验证码',required:true">
                <a href="javascript:;"><img style=" margin:0 0 0 3px ; vertical-align:middle; height:35px;"
                                            src="<%=path %>/kaptch"
                                            onclick="this.src='<%=path %>/kaptch?time=Math.random();'"></a>
            </div>
            <div>
                <a href="javascript:;" onclick="login();" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
                   style="padding:5px 0px;width:100%;">
                    <span style="font-size:14px;">登录</span>
                    <a href="<%=path%>/user/registerPager">注册</a>
                </a>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>