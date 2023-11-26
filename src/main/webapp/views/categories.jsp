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
    <title>Danh mục</title>
    <link href="<%=request.getContextPath()%>/resources/css/home.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/css/categories.css" rel="stylesheet"/>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
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

<h2>Quản lý danh mục</h2>
<div class="header-text">
<a href="<%=request.getContextPath()%>/categoriesController/initCreate">Thêm mới</a>

<form action="<%=request.getContextPath()%>/categoriesController/findCatalog" method="get">
    <label for="catalogName">Tìm kiếm :</label>
    <input type="text" id="catalogName" name="catalogName" value="${catalogName}" placeholder="Nhập vào tên danh mục cần tìm kiếm"/>
    <input type="submit" value="Tìm kiếm"/>
</form>
</div>
<div class="body-text">
    <label>Sắp xếp :</label>
<select id="sortBy" name="sortBy" onchange="changeSortBy()">
    <option value="catalogName" ${sortBy.equals("catalogName")?'selected':''}>Tên danh mục</option>
</select>
<select id="direction" name="direction" onchange="changeDirection()">
    <option value="ASC" ${direction.equals("ASC")?'selected':''}>Tăng dần</option>
    <option value="DESC" ${direction.equals("DESC")?'selected':''}>Giảm dần</option>
</select>
</div>

<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Mã danh mục</th>
        <th>Tên danh mục</th>
        <th>Mô tả danh mục</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="stt" value="0" scope="page"/>
    <c:forEach items="${categoriesList}" var="catalog">
        <c:set var="stt" value="${stt+1}" scope="page"/>
        <tr>
            <td>${stt}</td>
            <td>${catalog.catalogId}</td>
            <td>${catalog.catalogName}</td>
            <td>${catalog.catalogDescribe}</td>
            <td>${catalog.status?"Hoạt động":"Không hoạt động"}</td>
            <td>
                <a class="blue" href="<%=request.getContextPath()%>/categoriesController/initUpdate?catalogId=${catalog.catalogId}">Cập nhật</a>
                <a class="red" href="#" onclick="confirmDelete('${catalog.catalogId}')">Xoá</a>
            </td>

            <!-- Đoạn mã JavaScript -->
            <script>
                function confirmDelete(catalogId) {
                    var isConfirmed = confirm("Bạn có chắc chắn muốn xoá không?");

                    if (isConfirmed) {
                        // Nếu xác nhận xoá, chuyển hướng đến trang xử lý xoá
                        window.location.href = "<%=request.getContextPath()%>/categoriesController/delete?catalogId=" + catalogId;
                    } else {
                        // Ngược lại, không làm gì cả hoặc thực hiện các hành động khác
                        alert("Xoá bị hủy bỏ.");
                    }
                }
            </script>

        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="page">
<c:forEach items="${listPages}" var="page">
    <a class="pagination-link" href="<%=request.getContextPath()%>/categoriesController/findCatalog?page=${page}">${page}</a>
</c:forEach>
</div>
    </div>
</section>
<script src="<%=request.getContextPath()%>/resources/js/categories.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/home.js"></script>
</body>
</html>
