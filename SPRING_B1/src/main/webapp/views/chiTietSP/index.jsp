<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Chi Tiet SP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <a href="/chi-tiet-sp/create" class="btn btn-primary">Create</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Mã SP</th>
            <th scope="col">Nhà Sản Xuất</th>
            <th scope="col">Màu Sắc</th>
            <th scope="col">Dòng sản Phẩm</th>
            <th scope="col">Năm BH</th>
            <th scope="col">Mô Tả</th>
            <th scope="col">SL Tồn</th>
            <th scope="col">Giá Nhập</th>
            <th scope="col">Giá Bán</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCTSP.content}" var="sp" varStatus="stt">
            <tr>
                <td>${stt.index +1}</td>
                <td>${sp.sp.ma}</td>
                <td>${sp.nsx.ten}</td>
                <td>${sp.ms.ten}</td>
                <td>${sp.dsp.ten}</td>
                <td>${sp.nam_bh}</td>
                <td>${sp.mo_ta}</td>
                <td>${sp.sl_ton}</td>
                <td>${sp.gia_nhap}</td>
                <td>${sp.gia_ban}</td>
                <td>
                    <a href="/chi-tiet-sp/edit/${sp.id}" class="btn btn-primary">details</a>
                    <a href="/chi-tiet-sp/delete/${sp.id}" class="btn btn-primary">delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item d-flex ">
                <c:forEach begin="0" end="${listCTSP.totalPages -1}" varStatus="loop">
                    <a class="page-link" href="/chi-tiet-sp/index?page=${loop.begin + loop.count -1}">
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