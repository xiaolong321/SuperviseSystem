<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户登陆</title>
    <script>
        function login() {
            if ($("#login_form").form("validate")) {
                $.post(contextPath + "/user/login", $("#login_form").serialize(), function (data) {
                    var result = data.result;
                    if (result == "success") {
                        window.location.href = contextPath + "/user/home";
                    } else {
                        $("#errMsg").html(data.message);
                    }
                });
            }
        }
    </script>
</head>
<body>
<div class="login_container">
    <div class="login_div input_normal">
        <div class="easyui-panel" title="管理员登录" style="width:240px;padding:10px;">
            <div id="errMsg" style="color: red;size: 15px"></div>
            <form:form id="login_form" method="post" modelAttribute="user">
                <table>
                    <tr>
                        <td>邮箱:</td>
                        <td><input type="text" name="username" class="easyui-textbox" data-options="required:true"/></td>
                    </tr>
                    <tr>
                        <td>密码:</td>
                        <td><input type="password" name="password" class="easyui-textbox" data-options="required:true"/></td>
                    </tr>
                    <tr>
                        <td>验证码:</td>
                        <td><input type="text" name="checkCode" class="easyui-textbox" data-options="required:true"/></td>
                    </tr>
                    <tr>
                        <td></td>

                        <td><img id="verImg" src="<%=path %>/kaptch" onclick="this.src='<%=path %>/kaptch?time=Math.random();'"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button type="button" onclick="login();">登录</button>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
    <div style="clear:both;"></div>
</div>
</body>
</html>