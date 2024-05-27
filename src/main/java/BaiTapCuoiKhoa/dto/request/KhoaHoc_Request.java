package BaiTapCuoiKhoa.dto.request;

import BaiTapCuoiKhoa.entity.LoaiKhoaHoc;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KhoaHoc_Request {
    @Size(max = 50, message = "TENKHOAHOC_INVALID")
    @NotNull(message = "TENKHOAHOC_NOT_NULL")
    String tenKhoaHoc;
    @NotNull(message = "THOIGIANHOC_NOT_NULL")
    int thoiGianHoc;
    @NotNull(message = "GIOITHIEU_NOT_NULL")
    String gioiThieu;
    @NotNull(message = "NOIDUNG_NOT_NULL")
    String noiDung;
    @NotNull(message = "HOCPHI_NOT_NULL")
    double hocPhi;
    @NotNull(message = "SOLUONGMON_NOT_NULL")
    int soLuongMon;
    @NotNull(message = "HINHANH_NOT_NULL")
    String hinhAnh;
    @NotNull(message = "LOAIKHOAHOC_NOT_NULL")
    LoaiKhoaHoc loaiKhoaHoc;
}
