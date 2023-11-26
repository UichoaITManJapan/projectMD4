<%--
  Created by IntelliJ IDEA.
  User: smilecuong
  Date: 20/11/2023
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Product</title>
    <link href="<%=request.getContextPath()%>/resources/css/error2.css" rel="stylesheet"/>
</head>

<body>
<div class="frem">
    <p>404</p>
    <h2>Sản phẩm đang có đơn hàng. Không thể xoá sản phẩm này</h2>
    <h5>Để xoá sản phẩm vui lòng xoá đơn hàng của sản phẩm</h5>
    <a href="<%=request.getContextPath()%>/productController/findProduct">Quay lại trang quản lý sản phẩm</a>
</div>
</body>

</html>
