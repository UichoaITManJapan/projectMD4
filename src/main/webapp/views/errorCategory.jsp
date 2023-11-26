<%--
  Created by IntelliJ IDEA.
  User: smilecuong
  Date: 20/11/2023
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Category</title>
    <link href="<%=request.getContextPath()%>/resources/css/error2.css" rel="stylesheet"/>
</head>

<body>
<div class="frem">
    <p>404</p>
    <h2>Danh mục đang có sản phẩm. Không thể xoá danh mục này</h2>
    <h5>Để xoá danh mục vui lòng xoá sản phẩm có trong danh mục</h5>
    <a href="<%=request.getContextPath()%>/categoriesController/findCatalog">Quay lại trang quản lý danh mục</a>
</div>
</body>

</html>
