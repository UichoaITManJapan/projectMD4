<%--
  Created by IntelliJ IDEA.
  User: smilecuong
  Date: 19/11/2023
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="<%=request.getContextPath()%>/resources/css/login.css" rel="stylesheet"/>
</head>
<body>

<div class="login-box">
    <h2>Đăng nhập</h2>
    <form>
        <div class="user-box">
            <input type="text" name="" required="">
            <label>Email</label>
        </div>
        <div class="user-box">
            <input type="password" name="" required="">
            <label>Mật khẩu</label>
        </div>
        <a href="<%=request.getContextPath()%>/staticController/staticList">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            Đăng nhập
        </a>
    </form>
</div>
</body>
</html>
