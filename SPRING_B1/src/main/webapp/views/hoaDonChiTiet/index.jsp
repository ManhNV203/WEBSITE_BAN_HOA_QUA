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
    <a href="/hoa-don-ct/create" class="btn btn-primary">Create</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">MAHD</th>
            <th scope="col">TênSP</th>
            <th scope="col">So luong</th>
            <th scope="col">don Gia</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listHDCT}" var="nsx" varStatus="stt">
            <tr>
                <td>${stt.index +1}</td>
                <td>${nsx.id.hd.ma}</td>
                <td>${nsx.id.ctsp.sp.ten}</td>
                <td>${nsx.so_luong}</td>
                <td>${nsx.don_gia}</td>
                <td>
                    <a href="/hoa-don-ct/edit/${nsx.id}" class="btn btn-primary">details</a>
                    <a href="/hoa-don-ct/delete/${nsx.id}" class="btn btn-primary">delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%--    <nav aria-label="Page navigation example">--%>
    <%--        <ul class="pagination">--%>
    <%--            <li class="page-item d-flex ">--%>
    <%--                <c:forEach begin="0" end="${listNSX.totalPages -1}" varStatus="loop">--%>
    <%--                    <a class="page-link" href="/nhasx/index?page=${loop.begin + loop.count -1}">--%>
    <%--                            ${loop.begin + loop.count}--%>
    <%--                    </a>--%>
    <%--                </c:forEach>--%>
    <%--            </li>--%>
    <%--        </ul>--%>
    <%--    </nav>--%>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>