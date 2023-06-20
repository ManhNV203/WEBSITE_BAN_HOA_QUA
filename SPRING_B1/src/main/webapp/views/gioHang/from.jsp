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
    <title>SanPham</title>
</head>
<body>
<div class="container">
    <sf:form action="${action}" method="post" modelAttribute="data">
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Mã</label>
            <div class="col-sm-5">
                <sf:input class="form-control" path="ma"/>
                <sf:errors path="ma"/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Tên KH</label>
            <div class="col-sm-5">
                <sf:select path="kh.id">
                    <c:forEach items="${listKH}" var="lkh" >
                        <sf:option value="${lkh.id}">${lkh.ten}</sf:option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="kh"/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Tên NV</label>
            <div class="col-sm-5">
                <sf:select path="nv.id">
                    <c:forEach items="${listNV}" var="lnv" >
                        <sf:option value="${lnv.id}">${lnv.ten}</sf:option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="nv"/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Ngày Tạp</label>
            <div class="col-sm-5">
                <sf:input class="form-control" type="date" path="ngay_tao"/>
                <sf:errors path="ngay_tao"/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Ngày Thanh Toán</label>
            <div class="col-sm-5">
                <sf:input class="form-control" type="date" path="ngay_thanh_toan"/>
                <sf:errors path="ngay_thanh_toan"/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Tên Người Nhận</label>
            <div class="col-sm-5">
                <sf:input class="form-control"  path="ten_nguoi_nhan"/>
                <sf:errors path="ten_nguoi_nhan"/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Địa Chỉ</label>
            <div class="col-sm-5">
                <sf:input class="form-control"  path="dia_chi"/>
                <sf:errors path="dia_chi"/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">SDT</label>
            <div class="col-sm-5">
                <sf:input class="form-control"  path="sdt"/>
                <sf:errors path="sdt"/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Tinh Trang</label>
            <div class="col-sm-5">
                <sf:radiobutton  path="tinh_trang" value="1"  /> Chờ XN
                <sf:radiobutton  path="tinh_trang" value="0"  /> Đã XN
                <sf:errors path="tinh_trang"/>
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