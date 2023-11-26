<%--
  Created by IntelliJ IDEA.
  User: smilecuong
  Date: 13/11/2023
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới danh mục</title>
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

    input[type="submit"]:hover {
        background-color: #45a049;
        color: #3a3b3c;
    }

</style>
<div class="container">
<h1>Thêm mới danh mục</h1>
<form action = "<%=request.getContextPath()%>/categoriesController/create" method ="post" >

    <label for="catalogName">Tên danh mục :</label>
    <input type="text" id="catalogName" name="catalogName"/><br>

    <label for="catalogDescribe">Mô tả danh mục :</label>
    <input type="text" id="catalogDescribe" name="catalogDescribe"/><br>

    <label for="active" class="active">Trạng thái :</label>

    <input type="radio" id="active" name="status" checked/><label for="active">Hoạt động</label>
    <input type="radio" id="inactive" name="status"/> <label for="inactive">Không hoạt động</label><br>

    <input type="submit" value="Thêm mới"/>
</form>
</div>
</body>
</html>
