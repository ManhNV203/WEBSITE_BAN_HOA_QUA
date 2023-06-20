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
            <label class="col-sm-2 col-form-label">Mã SP</label>
            <div class="col-sm-5">
                <sf:select path="sp.id" class="form-select" >
                    <c:forEach items="${listSP}" var="lsp">
                        <sf:option value="${lsp.id}">${lsp.ma}</sf:option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="sp" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Nhà SX</label>
            <div class="col-sm-5">
                <sf:select path="nsx.id" class="form-select" >
                    <c:forEach items="${listNSX}" var="lnsx">
                        <sf:option value="${lnsx.id}">${lnsx.ten}</sf:option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="nsx" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Màu Sắc</label>
            <div class="col-sm-5">
                <sf:select path="ms.id" class="form-select" >
                    <c:forEach items="${listMS}" var="lms">
                        <sf:option value="${lms.id}">${lms.ten}</sf:option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="ms" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Dòng SP</label>
            <div class="col-sm-5">
                <sf:select path="dsp.id" class="form-select" >
                    <c:forEach items="${listDSP}" var="ldsp">
                        <sf:option value="${ldsp.id}">${ldsp.ten}</sf:option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="dsp" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Năm BH</label>
            <div class="col-sm-5">
                <sf:input class="form-control" path="nam_bh"/>
                <sf:errors path="nam_bh"/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Số Lượng Tồn</label>
            <div class="col-sm-5">
                <sf:input class="form-control" path="sl_ton"/>
                <sf:errors path="sl_ton"/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Mô Tả</label>
            <div class="col-sm-5">
                <sf:input class="form-control" path="mo_ta"/>
                <sf:errors path="mo_ta"/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Giá Nhập</label>
            <div class="col-sm-5">
                <sf:input class="form-control" path="gia_nhap"/>
                <sf:errors path="gia_nhap"/>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Giá Bán</label>
            <div class="col-sm-5">
                <sf:input class="form-control" path="gia_ban"/>
                <sf:errors path="gia_ban"/>
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