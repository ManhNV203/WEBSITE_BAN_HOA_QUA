<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>khachHang</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <a href="/khach-hang/create" class="btn btn-primary">Create</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Tên Đệm</th>
            <th scope="col">Họ</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">SDT</th>
            <th scope="col">Quoc Gia</th>
            <th scope="col">Thanh Pho</th>
            <th scope="col">Mật Khẩu</th>
            <th scope="col">Trạng Thái</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listKH}" var="kh">
            <tr>
                <td>${kh.ma}</td>
                <td>${kh.ten}</td>
                <td>${kh.ten_dem}</td>
                <td>${kh.ho}</td>
                <td>${kh.ngay_sinh}</td>
                <td>${kh.dia_chi}</td>
                <td>${kh.sdt}</td>
                <td>${kh.quoc_gia}</td>
                <td>${kh.thanh_pho}</td>
                <td>${kh.mat_khau}</td>

                <td>
                    <a href="http://localhost:8080/khach-hang/edit/${kh.id}" class="btn btn-primary">details</a>
                    <a href="http://localhost:8080/khach-hang/delete/${kh.id}" class="btn btn-primary">delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</html>
