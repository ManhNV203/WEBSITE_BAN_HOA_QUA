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

    <h3>Giỏ Hàng</h3>
<%--    <a class="btn btn-primary" href="/gio-hang-ct/create">Create</a>--%>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">MãGH</th>
            <th scope="col">Tên</th>
            <th scope="col">So luong</th>
            <th scope="col">Don Gia</th>
            <th scope="col">Don gia Khi Giam</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listGHCT}" var="ctsp" varStatus="stt">
            <tr>
                <td>${stt.index +1}</td>
                <td>${ctsp.id.gh.ma}</td>
                <td>${ctsp.id.ctspgh.sp.ten}</td>
                <td>${ctsp.so_luong}</td>
                <td>${ctsp.don_gia}</td>
                <td>${ctsp.don_gia_khi_giam}</td>
                <td>
                    <a href="/san-pham/delete/${ctsp.id}" class="btn btn-primary">delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>