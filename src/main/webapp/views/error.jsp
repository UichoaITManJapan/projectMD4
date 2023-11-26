<%--
  Created by IntelliJ IDEA.
  User: smilecuong
  Date: 13/11/2023
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<%=request.getContextPath()%>/resources/css/error.css" rel="stylesheet"/>
<html>
<head>
    <title>Lỗi</title>
</head>
<body>
<div class="container">
    <h2>Đây là trang hiển thị lỗi</h2>
    <h1>404</h1>
    <p>Có lỗi xảy ra trong quá trình thực hiện. </p>
    <a href="<%=request.getContextPath()%>/index.jsp">Quay lại trang cũ</a>
</div>
</body>
</html>
