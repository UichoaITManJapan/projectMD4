<%--
  Created by IntelliJ IDEA.
  User: smilecuong
  Date: 19/11/2023
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dashboard - CuongSmile</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link href="<%=request.getContextPath()%>/resources/css/home.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/css/static.css" rel="stylesheet"/>
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
                    <a href="">
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
        <h2>Thống kê</h2>

        <h4>TÀI KHOẢN</h4>
        <table border="1">
            <tr>
                <td>Tổng số tài khoản trên hệ thống: </td>
                <td class="cnt">${totalAccounts}</td>
            </tr>
            <tr>
                <td>Tổng số tài khoản đang hoạt động: </td>
                <td class="cnt">${cntAccActive}</td>
            </tr>
            <tr>
                <td>Tổng số tài khoản không hoạt động: </td>
                <td class="cnt">${cntAccInactive}</td>
            </tr>
        </table>


        <h4>SẢN PHẨM</h4>
        <table border="1">
            <tr>
                <td>Tổng số sản phẩm trên hệ thống: </td>
                <td class="cnt">${totalProduct}</td>
            </tr>
            <tr>
                <td>Tổng số sản phẩm đang hoạt động: </td>
                <td class="cnt">${cntProActive}</td>
            </tr>
            <tr>
                <td>Tổng số sản phẩm không hoạt động:  </td>
                <td class="cnt">${cntProInactive}</td>
            </tr>
        </table>


        <h4>ĐƠN HÀNG</h4>
        <table border="1">
            <tr>
                <td>Tổng số đơn hàng trên hệ thống: </td>
                <td class="cnt"><span>${totalBill}</span></td>
            </tr>
            <tr>
                <td>Tổng số đơn hàng đang ở trạng thái huỷ: </td>
                <td class="cnt"><span>${cntBill5}</span></td>
            </tr>
            <tr>
                <td>Tổng số đơn hàng đang ở trạng thái đang chờ: </td>
                <td class="cnt"><span>${cntBill1}</span></td>
            </tr>
            <tr>
                <td>Tổng số đơn hàng đang ở trạng thái đã được duyệt: </td>
                <td class="cnt"><span>${cntBill2}</span></td>
            </tr>
            <tr>
                <td>Tổng số đơn hàng đang ở trạng thái đang giao hàng: </td>
                <td class="cnt"><span>${cntBill3}</span></td>
            </tr>
            <tr>
                <td>Tổng số đơn hàng đang ở trạng thái đã nhận hàng: </td>
                <td class="cnt"><span>${cntBill4}</span></td>
            </tr>
        </table>


        <h4>DOANH THU</h4>
        <table border="1">
            <tr>
                <td>Tổng doanh thu theo ngày hiện tại(yên) : </td>
                <td class="cnt"><span>${totalRevenueByCurrentDate}</span></td>
            </tr>
            <tr>
                <td>Tổng doanh thu theo tháng hiện tại(yên): </td>
                <td class="cnt"><span>${totalRevenueByCurrentMonth}</span></td>
            </tr>
            <tr>
                <td>Tổng doanh thu theo năm hiện tại(yên) : </td>
                <td class="cnt"><span>${totalRevenueByCurrentYear}</span></td>
            </tr>
        </table>

    </div>
</section>
<script src="<%=request.getContextPath()%>/resources/js/home.js"></script>
</body>
</html>
