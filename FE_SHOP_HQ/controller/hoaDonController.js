window.hoaDonController = function( $rootScope, $http, $location){
    $rootScope.listhd = [];
    $rootScope.hoadon = {
        id : undefined,
        ma: undefined,
        khachHang: undefined,
        nhanVien: undefined,
        ngay_tao: undefined,
        ngay_thanh_toan: undefined,
        ngay_ship: undefined,
        ngay_nhan: undefined,
        tinh_trang: undefined,
        ten_nguoi_nhan: undefined,
        dia_chi: undefined,
        sdt: undefined,
    };
    $http.get("http://localhost:8080/hoa-don/index").then(
        function(response){
            if(response.status === 200){
                $rootScope.listhd = response.data;
            }
        }
    )
}