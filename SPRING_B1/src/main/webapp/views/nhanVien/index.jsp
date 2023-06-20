<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>NhanVien</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <a href="/nhan-vien/create" class="btn btn-primary">Create</a>
    <form action="/nhan-vien/sreach" method="get">
        <input type="text">
        <button type="submit" class="btn btn-primary">Sreach</button>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Tên Đệm</th>
            <th scope="col">Họ</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Giới Tính</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">SDT</th>
            <th scope="col">Cửa Hàng</th>
            <th scope="col">Chức Vụ</th>
            <th scope="col">Mật Khẩu</th>
            <th scope="col">Trạng Thái</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listNV.content}" var="nv">
            <tr>
                <td>${nv.ma}</td>
                <td>${nv.ten}</td>
                <td>${nv.ten_dem}</td>
                <td>${nv.ho}</td>
                <td>${nv.ngay_sinh}</td>
                <td>${nv.gioi_tinh}</td>
                <td>${nv.dia_chi}</td>
                <td>${nv.sdt}</td>
                <td>${nv.ch.getTen()}</td>
                <td>${nv.cv.getTen()}</td>
                <td>${nv.mat_khau}</td>
                <td>${nv.trang_thai == "0" ? "Active" : "InActive"}</td>
                <td>
                    <a href="http://localhost:8080/nhan-vien/edit/${nv.id}" class="btn btn-primary">details</a>
                    <a href="http://localhost:8080/nhan-vien/delete/${nv.id}" class="btn btn-primary">delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item d-flex ">
                <c:forEach begin="0" end="${listNV.totalPages -1}" varStatus="loop">
                    <a class="page-link" href="/nhan-vien/index?page=${loop.begin + loop.count -1}">
                            ${loop.begin + loop.count}
                    </a>
                </c:forEach>
            </li>
        </ul>
    </nav>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</html>