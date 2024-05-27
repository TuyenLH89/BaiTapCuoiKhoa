package BaiTapCuoiKhoa.exception;

public enum ErrorCode {
    ERROR_KEY_NOT_EXIST(0000, "Error key not exist"),
    TENBAIVIET_INVALID(1001, "TenBaiViet must be less than 50 character"),
    TENTACGIA_INVALID(1002, "TenTacGia must be less than 50 character"),
    NOIDUNGNGAN_INVALID(1003, "NoiDungNgan must be less than 1000 character"),
    TENCHUDE_INVALID(1004, "TenChuDe must be less than 50 character"),
    HOTEN_INVALID(1005, "HoTen must be less than 50 character"),
    SODIENTHOAI_INVALID(1006, "SoDienThoai must be less than 11 character"),
    EMAIL_INVALID(1007, "Email must be less than 40 character"),
    TINHTHANH_INVALID(1008, "TinhThanh must be less than 50 character"),
    QUANHUYEN_INVALID(1009, "QuanHuyen must be less than 50 character"),
    PHUONGXA_INVALID(1010, "PhuongXa must be less than 50 character"),
    SONHA_INVALID(1011, "SoNha must be less than 50 character"),
    TENKHOAHOC_INVALID(1012, "TenKhoaHoc must be less than 50 character"),
    TENLOAIBAIVIET_INVALID(1013, "TenLoaiBaiViet must be less than 50 character"),
    TENQUYENHAN_INVALID(1014, "TenQuyenHan must be less than 50 character"),
    TENLOAIKHOAHOC_INVALID(1015, "TenKHoaHoc must be less than 50 character"),
    TENNGUOIDUNG_INVALID(1016, "TenNguoiDung must be less than 50 character"),
    TAIKHOAN_INVALID(1017, "TaiKhoan must be less than 50 character"),
    MATKHAU_INVALID(1018, "MatKhau must be less than 50 character"),
    TENTINHTRANG_INVALID(1019, "TenTinhTrang must be less than 40 character"),
    LOAIKHOAHOC_NOT_EXIST(1020, "LoaiKhoaHoc not exist"),
    PAGESIZE_INVALID(1021, "Not enough pageSize on the page.No"),
    PAGESIZE_INVALID1(1022, "Page size must not be less than one"),
    PAGENO_INVALID(1023, "Page.No must not be less than zero"),
    KHOAHOC_EXIST(1024, "KhoaHoc already exists"),
    KHOAHOC_NOT_EXIST(1025, "KhoaHoc not exist"),
    KHOAHOC_EXIST1(1026, "one course already exists in the list"),
    HOCVIEN_NOT_EXIST(1027, "HocVien not exist"),
    HVREQUEST_INVALID(1028, "SoDienThoai or Email already exist"),
    TINHTRANGHOC_EXIST(1029, "TinhTrangHoc already exist"),
    TINHTRANGHOC_NOT_EXIST(1030, "TinhTrangHoc not exist"),
    QUYENHAN_EXIST(1031, "TenQuyenHan already exist"),
    QUYENHAN_NOT_EXIST(1032, "QuyenHan not exist"),
    LOAIKHOAHOC_EXIST(1033, "LoaiKhoaHoc already exist"),
    TAIKHOAN_EXIST(1034, "TaiKhoan already exist"),
    TAIKOAN_NOT_EXIST(1035, "TaiKhoan not exist"),
    PASSWORD_LOWER(1036, "Password at least one lower case English letter"),
    PASSWORD_DIGIT(1037, "Password at least one digit"),
    PASSWORD_SPECIAL(1038, "Password at least one special character"),
    LOAIBAIVIET_EXIST(1039, "LoaiBaiViet already exist"),
    LOAIBAIVIET_NOT_EXIST(1040, "LoaiBaiViet not exist"),
    MATKHAU_INVALID1(1041, "Incorrect password"),
    NOIDUNG_NOT_NULL(1042, "NoiDung is null"),
    TENCHUDE_NOT_NULL(1043, "TenChuDe is null"),
    LOAIBAIVIET_NOT_NULL(1044, "LoaiBaiViet is null"),
    CHUDE_EXIST(1045, "ChuDe already exist"),
    CHUDE_NOT_EXIST(1046, "ChuDe not exist"),
    TENBAIVIET_NOT_NULL(1047, "TenBaiViet is null"),
    TENTACGIA_NOT_NULL(1048, "TenTAcGia is null"),
    NOIDUNGNGAN_NOT_NULL(1049, "NoiDungNgan  null"),
    THOIGIANTAO_NOT_NULL(1050, "ThoiGianTao is null"),
    HINHANH_NOT_NULL(1051, "HinhAnh is null"),
    CHUDE_NOT_NULL(1052, "ChuDe is null"),
    TAIKHOAN_NOT_NULL(1053, "TaiKhoan is null"),
    BAIVIET_EXIST(1054, "BaiViet already exist"),
    BAIVIET_NOT_EXIST(1055,"BaiViet not exist"),
    DANGKYHOC_NOT_EXIST(1056, "DangKyHoc not exist"),
    HOCVIEN_NOT_COMPLETE_KHOAHOC(1057, "HocVien not complete KhoaHoc"),
    TINHTRANGHOC_NOT_CHANGE(1058, "TinhTrangHoc has not changed"),
    HOCVIEN_NOT_START_KHOA_HOC(1059, "HocVien has not yet started KhoaHoc"),
    TENKHOAHOC_NOT_NULL(1060, "TenKhoaHoc is null"),
    THOIGIANHOC_NOT_NULL(1061, "ThoiGianHoc is null"),
    GIOITHIEU_NOT_NULL(1062, "GioiThieu is null"),
    HOCPHI_NOT_NULL(1063, "HocPhi is null"),
    SOLUONGMON_NOT_NULL(1064, "SoLuongMon is null"),
    LOAIKHOAHOC_NOT_NULL(1065, "LoaiKhoaHoc is null");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
