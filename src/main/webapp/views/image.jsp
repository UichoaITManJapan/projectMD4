<%--
  Created by IntelliJ IDEA.
  User: smilecuong
  Date: 12/11/2023
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bill Detail</title>
    <link href="<%=request.getContextPath()%>/resources/css/home.css" rel="stylesheet"/>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link href="<%=request.getContextPath()%>/resources/css/categories.css" rel="stylesheet"/>
</head>
<body>
<style>
    table{
        margin-top: 50px;
    }
</style>
<nav class="sidebar close">
    <header>
        <div class="image-text">
                <span class="image">
                    <img src="<%=request.getContextPath()%>/resources/anh/anh%20fukuoka.jpeg" alt="">
                </span>

            <div class="text header-text">
                <span class="name">Cuong Smile</span>
                <span class="profession">My Project</span>
            </div>
        </div>

        <i class='bx bx-chevron-right toggle'></i>
    </header>

    <div class="menu-bar">
        <div class="menu">
            <li class="search-box">
                <i class='bx bx-search icon' ></i>
                <input type="search" placeholder="Tìm kiếm...">
            </li>
            <ul class="manu-links">
                <li class="nav-link">
                    <a href="<%=request.getContextPath()%>/staticController/staticList">
                        <i class='bx bx-home-alt icon' ></i>
                        <span class="text nav-text">Thống kê</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="<%=request.getContextPath()%>/categoriesController/findCatalog">
                        <i class='bx bxs-category icon'></i>
                        <span class="text nav-text">Danh mục</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="<%=request.getContextPath()%>/productController/findProduct">
                        <i class='bx bx-lemon icon'></i>
                        <span class="text nav-text">Sản phẩm</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="<%=request.getContextPath()%>/imageController/findImage">
                        <i class='bx bx-image icon'></i>
                        <span class="text nav-text">Ảnh</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="<%=request.getContextPath()%>/accountsController/findAccounts">
                        <i class='bx bxs-user-account icon' ></i>
                        <span class="text nav-text">Tài khoản</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="<%=request.getContextPath()%>/billController/findBill">
                        <i class='bx bx-cart-add icon'></i>
                        <span class="text nav-text">Đơn hàng</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="<%=request.getContextPath()%>/billDelController/findBillDel">
                        <i class='bx bx-bar-chart-alt-2 icon'></i>
                        <span class="text nav-text">Đơn hàng chi tiết</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="bottom-content">
            <li class="">
                <a href="<%=request.getContextPath()%>/views/login.jsp">
                    <i class='bx bx-log-out icon' ></i>
                    <span class="text nav-text">Đăng xuất</span>
                </a>
            </li>
            <li class="mode">
                <div class="moon-sun">
                    <i class='bx bx-moon icon moon' ></i>
                    <i class='bx bx-sun icon sun' ></i>
                </div>
                <span class="mode-text text">Bóng đêm</span>

                <div class="toggle-switch">
                    <span class="switch"></span>
                </div>
            </li>
        </div>
    </div>
</nav>
<section class="home">
    <div class="text">

        <h2>Quản lý ảnh</h2>
        <table border="1">
            <thead>
            <tr>
                <th>No</th>
                <th>Mã ảnh</th>
                <th>Đường dẫn ảnh</th>
                <th>Tên sản phẩm</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="stt" value="0" scope="page"/>
            <c:forEach items="${imagesList}" var="image">
                <c:set var="stt" value="${stt+1}" scope="page"/>
                <tr>
                    <td>${stt}</td>
                    <td>${image.imageId}</td>
                    <td>${image.imageUrl}</td>
                    <td>${image.product.productName}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<script src="<%=request.getContextPath()%>/resources/js/home.js"></script>
</body>
</html>
