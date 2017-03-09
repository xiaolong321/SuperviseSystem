<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <link href="<%=path%>/js/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/js/themes/insdep/master.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/js/themes/insdep/icon.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/script/user/user.js"></script>
    <script type="text/javascript" src="<%=path%>/script/site_easyui.js"></script>
    <script type="text/javascript" src="<%=path%>/js/themes/insdep/jquery.insdep-extend.min.js"></script>
    <script>
        function keyLogin() {
            if(event.keyCode===13){
                alert("点击登录了");
            }
        }
    </script>
</head>
<body style="background: url('/images/bg/register_bg.jpeg')";>
<div class="register_container">
    <div class="easyui-window" title="请输入必要的信息进行注册"
         data-options="modal:true,closed:false,iconCls:'Lockgo',closable:false,minimizable:false,maximizable:false"
         style="width:400px; height: 555px;padding:20px 70px 20px 70px;">
        <form:form id="register_form" method="post" modelAttribute="user">
            <p id="errMsg" style="color: red;text-align: center;"></p>
            <div style="margin-bottom:10px">
                <input class="easyui-textbox" id="email" name="email" style="width: 100%;height:35px;padding:12px"
                       data-options="prompt:'登录邮箱',iconCls:'icon-man',iconWidth:38,required:true">
            </div>
            <div style="margin-bottom:10px">
                <input class="easyui-textbox" id="username" name="username" style="width: 100%;height:35px;padding:12px"
                       data-options="prompt:'用户名',iconCls:'icon-man',iconWidth:38,required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" id="password" name="password" type="password"
                       style="width: 100%;height:35px;padding:12px"
                       data-options="prompt:'登录密码',iconCls:'icon-lock',iconWidth:38,required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" id="conPassword" name="conPassword" type="password"
                       style="width: 100%;height:35px;padding:12px"
                       data-options="prompt:'确认密码',iconCls:'icon-lock',iconWidth:38,required:true">
            </div>
            <div style="margin-bottom:10px">
                <input class="easyui-numberBox" id="phone" name="phone" style="width: 100%;height:35px;padding:12px"
                       data-options="prompt:'手机',required:true">
            </div>
            <div style="margin-bottom:10px">
                <input class="easyui-textbox" id="address" name="address" style="width: 100%;height:100px;padding:12px"
                       data-options="prompt:'家庭地址',required:false">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" id="checkCode" type="text" name="checkCode" style="width: 50%;height:35px;padding:12px"
                       data-options="prompt:'验证码',required:true">
                <a href="javascript:;"><img style=" margin:0 0 0 3px ; vertical-align:middle; height:35px;"
                                            src="<%=path %>/kaptch"
                                            onclick="this.src='<%=path %>/kaptch?time=Math.random();'"></a>
            </div>
            <div>
                <a href="javascript:;" onclick="userRegister();" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
                   style="padding:5px 0px;width: 100%;">
                    <span style="font-size:14px;">注册</span>
                    <a href="<%=path%>/user/loginPager">登陆</a>
                </a>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>