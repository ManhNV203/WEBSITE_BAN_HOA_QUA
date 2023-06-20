<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <sf:form action="${action}" method="post" modelAttribute="data">
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Mã</label>
            <div class="col-sm-5">
                <sf:input class="form-control" path="ma"  />
                <sf:errors path="ma" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Tên</label>
            <div class="col-sm-5">
                <sf:input class="form-control" path="ten" />
                <sf:errors path="ten" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Tên Đệm</label>
            <div class="col-sm-5">
                <sf:input class="form-control" path="ten_dem" />
                <sf:errors path="ten_dem" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Họ</label>
            <div class="col-sm-5">
                <sf:input class="form-control" path="ho" />
                <sf:errors path="ho" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Ngày Sinh</label>
            <div class="col-sm-5">
                <sf:input class="form-control" type="date" path="ngay_sinh" />
                <sf:errors path="ngay_sinh" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Giới Tính</label>
            <div class="col-sm-5">
                <sf:input class="form-control" path="gioi_tinh" />
                <sf:errors path="gioi_tinh" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Địa CHỉ</label>
            <div class="col-sm-5">
                <sf:input class="form-control" path="dia_chi" />
                <sf:errors path="dia_chi" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Sdt</label>
            <div class="col-sm-5">
                <sf:input class="form-control" path="sdt" />
                <sf:errors path="sdt" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">cua hang</label>
            <div class="col-sm-5">
                <sf:select path="ch.id" class="form-select" >
                    <c:forEach items="${datach}" var="ch">
                        <sf:option  value="${ch.id}">${ch.ten}</sf:option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="sdt" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">cua hang</label>
            <div class="col-sm-5">
                <sf:select path="cv.id" class="form-select" >
                    <c:forEach items="${datacv}" var="listcv">
                        <sf:option value="${listcv.id}">${listcv.ten}</sf:option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="sdt" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Mật Khẩu</label>
            <div class="col-sm-5 ">
                <sf:input class="form-control" path="mat_khau" />
                <sf:errors path="mat_khau" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Trạng thái</label>
            <div class="col-sm-5">
                <sf:radiobutton  path="trang_thai" value="0"/> Active
                <sf:radiobutton path="trang_thai" value="1" />inActive
                <sf:errors path="trang_thai" />
            </div>
        </div>
            <button class="btn btn-primary">Update</button>
        </div>
    </sf:form>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>