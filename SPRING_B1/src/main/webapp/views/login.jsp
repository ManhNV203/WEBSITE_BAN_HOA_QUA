<%@ page language="java" pageEncoding="utf-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3 style="margin-left: 240px">LOGIN</h3>
    <form method="post" action="/login" >
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">User</label>
            <div class="col-sm-5">
                <input class="form-control" name="username">
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-5">
                <input class="form-control" name="password">
            </div>
        </div>
        <fieldset class="row mb-3" style="margin-left: 210px">
            <div class="col-sm-10 d-flex">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="gridRadios" value="option1">
                    <label class="form-check-label">
                        Nhớ Mật Khẩu
                    </label>
                </div>
                <div class="form-check">
                    <a href="#" class="navbar-brand" style="color: blueviolet">Quên Mật Khẩu?</a>
                </div>
            </div>
        </fieldset>
        <button type="submit" class="btn btn-primary">Sign in</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>