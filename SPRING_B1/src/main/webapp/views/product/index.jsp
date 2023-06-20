<%@ page contentType="text/html; charset=UTF-8" language="java" %>
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
    <div class="col-9 container">
        <div class="san-pham" style="margin-top: 40px;">
            <h1 style="text-align: center; ">List Product</h1>
            <div style="margin-top: 40px;">
                <div class="container text-center">
                    <div class="row align-items-start">
                            <c:forEach items="${listProcduct}" var="proc">
                                <div class="col-4">
                                <div class="card" style="width: 18rem;">
                                    <a href="#detail/{{sp.id}}"><img src="https://image.uniqlo.com/UQ/ST3/AsianCommon/imagesgoods/456643/item/goods_63_456643.jpg?width=750" class="card-img-top" alt="..."></a>
                                    <div class="card-body">
                                        <p>${proc.sp.ten}</p>
                                        <h5 class="card-title">${proc.gia_ban}</h5>
                                        <a href="/mua-hang/product/add?id=${proc.id}" class="btn btn-primary">Add to card</a>
                                    </div>
                                </div>
                                </div>
                            </c:forEach>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>