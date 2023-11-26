<%--
  Created by IntelliJ IDEA.
  User: smilecuong
  Date: 14/11/2023
  Time: 00:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm mới sản phẩm</title>
</head>
<body>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background: linear-gradient(to bottom, #3498db, #2c3e50);
    }

    .container {
        background: linear-gradient(#7FFFD4, #5F9EA0);
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        padding: 20px;
        max-width: 400px;
        width: 100%;
    }

    h1 {
        color: #333;
        text-align: center;
    }

    form {
        margin-top: 20px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-size: 15px;
        font-weight: 600;
        color: #333;
    }
    .container .active{
        font-size: 20px;
        font-weight: 600;
    }

    input[type="text"],
    input[type="radio"] {
        margin-bottom: 10px;
        width: 100%;
        padding: 8px;
        box-sizing: border-box;
        border-radius: 10px;
        border: none;
    }


    input[type="radio"] + label {
        margin-right: 10px;
    }
    a,
    input[type="submit"] {
        background-color: #6495ED;
        color: white;
        font-size: 20px;
        padding: 10px 15px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
        box-sizing: border-box;
    }
    a:hover,
    input[type="submit"]:hover {
        background-color: #45a049;
        color: #3a3b3c;
    }
    .radio-choose{
        display: flex;
        gap: 50px;
    }
    .image-choose {
        display: flex;
        gap: 0px;
        margin-bottom: 10px;
    }
    select {
        margin-bottom: 10px;
    }
    a {
        margin-top: 10px;
        text-decoration: none;

        border-radius: 10px;
        border: none;
        background-color: #FFB6C1;

    }


</style>
<div class="container">
<h1>Thêm mới sản phẩm</h1>

<form action="<%=request.getContextPath()%>/productController/create" method="post" enctype="multipart/form-data">
    <label for="productName">Tên sản phẩm</label>
    <input type="text" id="productName" name="productName"/><br>

    <label for="catalog">Choice catalog</label>
    <select id="catalog" name="catalog.catalogId">
        <c:forEach items="${categoriesList}" var="catalog">
            <option value="${catalog.catalogId}">${catalog.catalogName}</option>
        </c:forEach>
    </select><br>

    <label for="price">Giá(yên)</label>
    <input type="text" id="price" name="price"/><br>

    <label for="title">Tiêu đề</label>
    <input type="text" id="title" name="title"/><br>

    <label for="describe">Mô tả</label>
    <input type="text" id="describe" name="describe"/><br>
<div class="image-choose">
    <div>
    <label for="productImage">Ảnh</label>
    <input type="file" id="productImage" name="productImage"/><br>
    </div>
    <div>
    <label for="otherImages">Ảnh khác</label>
    <input type="file" id="otherImages" name="otherImages" multiple/><br>
    </div>
</div>

    <label for="units">Đơn vị</label>
    <input type="text" id="units" name="units"/><br>

    <label for="active">Trạng thái</label>
    <div class="radio-choose">
        <div>
    <input type="radio" id="active" name="status" checked/><label for="active">Hoạt động</label>
        </div>
        <div>
    <input type="radio" id="inactive" name="status"/><label for="inactive">Không hoạt động</label><br>
    </div>
    </div>

    <input type="submit" value="Thêm mới"/>
</form>
    <a href="<%=request.getContextPath()%>/productController/findProduct">Quay lại</a>
</div>
</body>
</html>
