<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>cuaHang</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <a href="/cua-hang/create" class="btn btn-primary">Create</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Thành Phố</th>
            <th scope="col">quốc gia</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dsCh.content}" var="ch">
            <tr>
                <td>${ch.ma}</td>
                <td>${ch.ten}</td>
                <td>${ch.dia_chi}</td>
                <td>${ch.quoc_gia}</td>
                <td>${ch.thanh_pho}</td>
                <td>
                    <a href="/cua-hang/edit/${ch.id}" class="btn btn-primary">details</a>
                    <a href="/cua-hang/delete/${ch.id}" class="btn btn-primary">delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item d-flex ">
                <c:forEach begin="0" end="${dsCh.totalPages -1}" varStatus="loop">
                    <a class="page-link" href="/cua-hang/index?page=${loop.begin + loop.count -1}">
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