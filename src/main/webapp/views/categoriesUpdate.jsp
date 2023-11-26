<%--
  Created by IntelliJ IDEA.
  User: smilecuong
  Date: 13/11/2023
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhật danh mục</title>
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
        background: linear-gradient(to bottom, #FFB6C1, #FFA07A);
    }

    .container {
        background: linear-gradient(#FAF0E6,#FFE4E1);
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
    .container {
        font-size: 20px;
        font-weight: 600;
    }

    input[type="text"],
    input[type="number"],
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
        background-color: #5F9EA0;
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
        background-color: #87CEEB;
        color: #3a3b3c;
    }
    .status{
        display: flex;
        gap: 50px;
    }

</style>
<div class="container">
<h1>Cập nhật danh mục</h1>
<form action = "<%=request.getContextPath()%>/categoriesController/update" method ="post" >
    <label for="catalogId">Mã danh mục :</label>
    <input type="number" id="catalogId" name="catalogId" value="${categoriesEdit.catalogId}" readonly/><br>

    <label for="catalogName">Tên danh mục :</label>
    <input type="text" id="catalogName" name="catalogName" value="${categoriesEdit.catalogName}"/><br>

    <label for="catalogDescribe">Mô tả danh mục :</label>
    <input type="text" id="catalogDescribe" name="catalogDescribe" value="${categoriesEdit.catalogDescribe}"/><br>

    <label for="active">Trạng thái :</label>
    <div class="status">
        <div>
            <input type="radio" id="active" name="status"
            ${categoriesEdit.status?'checked':''} value="true"/><label for="active">Hoạt động</label>
        </div>
        <div>
            <input type="radio" id="inactive" name="status"
            ${categoriesEdit.status?'':'checked'} value="false"/><label for="inactive">Không hoạt động</label><br>
        </div>
    </div>

    <input type="submit" value="Cập nhật"/>
</form>
</div>
</body>
</html>
