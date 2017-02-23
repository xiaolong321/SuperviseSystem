<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<head>
    <title>首页</title>
</head>
<body>
    <a href="<%=path%>/user/loginPager">登陆</a>
    <a href="<%=path%>/user/registerPager">注册</a>
</body>
</html>