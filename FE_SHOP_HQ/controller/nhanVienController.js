window.nhanVienController = function ($scope, $http, $rootScope, $location, $routeParams) {
    $rootScope.nhanvienpost = {
        id: undefined,
        ma: undefined,
        ten: undefined,
        ten_dem: undefined,
        ho: undefined,
        ngay_sinh: undefined,
        gioi_tinh: undefined,
        dia_chi: undefined,
        sdt: undefined,
        mat_khau: undefined,
        trang_thai: 0,
        cuahangid: undefined,
        chucvuid: undefined,
    }

    $rootScope.listnv = [];
    $http.get("http://localhost:8080/nhan-vien/index").then(function (response) {
        if (response.status === 200) {
            $rootScope.listnv = response.data;
        }
    })

    $rootScope.addnew = function () {
        $http.post("http://localhost:8080/nhan-vien/store", $rootScope.nhanvienpost).then(
            function (response) {
                if (response.status === 200) {
                    alert("Them Thanh Cong");
                    window.location.reload();
                }
                console.log(nhanvienpost);
            },
            function (error) {
                alert(error.data.message);
            }
        )
    }
    $rootScope.delete = function (id) {
        $http.delete("http://localhost:8080/nhan-vien/delete/" + id).then(
            function (response) {
                if (response.status === 200) {
                    alert("xoa thanh cong");
                    window.location.reload();
                }
            }
        )
    }
    $rootScope.detail = function (id) {
        $http.get("http://localhost:8080/nhan-vien/edit/" + id).then(
            function (response) {
                $rootScope.nhanvienpost = response.data;
            })
    }
    $rootScope.update = function (id) {
        $http.put("http://localhost:8080/nhan-vien/update/" + id, $rootScope.nhanvienpost).then(
            function (response) {
                if (response.status === 201) {
                    alert("Them Thanh Cong");
                    window.location.reload();
                }
                console.log(nhanvienpost);
            }
        )
    }
    $rootScope.cuahang = {
        id: undefined,
        ma: undefined,
        ten: undefined,
        diaChi: undefined,
        quocGia: undefined,
        thanhPho: undefined,
    };
    $rootScope.listch = [];
    $http.get("http://localhost:8080/cua-hang/index").then(function (response) {
        if (response.status === 200) {
            $rootScope.listch = response.data;
        }
    })
    $rootScope.chucvu = {
        id: undefined,
        ma: undefined,
        ten: undefined
    };
    $rootScope.listcv = [];
    $http.get("http://localhost:8080/chuc-vu/index").then(function (response) {
        if (response.status === 200) {
            $rootScope.listcv = response.data;
        }
    })

}