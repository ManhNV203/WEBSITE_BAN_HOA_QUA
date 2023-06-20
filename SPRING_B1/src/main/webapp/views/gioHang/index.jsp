<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <a href="/gio-hang/create" class="btn btn-primary">Create</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Mã GH</th>
            <th scope="col">Tên Nhân Viên</th>
            <th scope="col">Tên Khách hàng</th>
            <th scope="col">NGày Tạo</th>
            <th scope="col">NGày Thanh Toán</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">SDT</th>
            <th scope="col">Tình Trạng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listGH.content}" var="ghv" varStatus="stt">
            <tr>
                <td>${stt.index +1}</td>
                <td>${ghv.ma}</td>
                <td>${ghv.nv.ten}</td>
                <td>${ghv.kh.ten}</td>
                <td>${ghv.ngay_tao}</td>
                <td>${ghv.ngay_thanh_toan}</td>
                <td>${ghv.dia_chi}</td>
                <td>${ghv.sdt}</td>
                <td>${ghv.tinh_trang == "1" ? "Chờ XN" : "Đã XN"}</td>
                <td>
                    <a href="/gio-hang/edit/${ghv.id}" class="btn btn-primary">details</a>
                    <a href="/gio-hang/delete/${ghv.id}" class="btn btn-primary">delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        <nav>
            <ul class="pagination">
                <li class="page-item d-flex">
                    <c:forEach begin="0" end="${listGH.totalPages -1}" varStatus="loop">
                        <a class="page-link" href="/gio-hang/index?page=${loop.begin + loop.count -1}">
                                ${loop.begin + loop.count}
                        </a>
                    </c:forEach>
                </li>
            </ul>
        </nav>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>