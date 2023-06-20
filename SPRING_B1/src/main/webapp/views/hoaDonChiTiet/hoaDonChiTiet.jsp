<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>nhaSX</title>
</head>
<body>
<div class="container">
    <sf:form action="/hoa-don-ct/store" method="post" modelAttribute="data">
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Mã HD</label>
            <div class="col-sm-5">
                <sf:select path="hd">
                    <c:forEach items="${listHD}" var="lhd">
                        <sf:option value="${lhd.id}">${lhd.ma}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Chi Tiết SP</label>
            <div class="col-sm-5">
                <sf:select path="stsp">
                    <c:forEach items="${listCTSP}" var="ctsp">
                        <sf:option value="${ctsp.id}">${ctsp.sp.ten}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Số Lượng</label>
            <div class="col-sm-5">
                <sf:input class="form-control" path="so_luong"/>
                <sf:errors path="so_luong"/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Đơn Giá</label>
            <div class="col-sm-5">
                <sf:input class="form-control" path="don_gia"/>
                <sf:errors path="don_gia"/>
            </div>
        </div>
        <div>
            <button class="btn btn-primary">Submit</button>
        </div>
    </sf:form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</html>