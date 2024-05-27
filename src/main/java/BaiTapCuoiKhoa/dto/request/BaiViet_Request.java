package BaiTapCuoiKhoa.dto.request;

import BaiTapCuoiKhoa.entity.ChuDe;
import BaiTapCuoiKhoa.entity.TaiKhoan;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaiViet_Request {
    @Size(max = 50, message = "TENBAIVIET_INVALID")
    @NotNull(message = "TENBAIVIET_NOT_NULL")
    String tenBaiViet;
    @Size(max = 50, message = "TENTACGIA_INVALID")
    @NotNull(message = "TENTACGIA_NOT_NULL")
    String tenTacGia;
    @NotNull(message = "NOIDUNG_NOT_NULL")
    String noiDung;
    @NotNull(message = "NOIDUNGNGAN_NOT_NULL")
    @Size(max = 1000, message = "NOIDUNGNGAN_INVALID")
    String noiDungNgan;
    //LocalDate thoiGianTao = LocalDate.now();
    @NotNull(message = "HINHANH_NOT_NULL")
    String hinhAnh;
    @NotNull(message = "CHUDE_NOT_NULL")
    ChuDe chuDe;
    @NotNull(message = "TAIKHOAN_NOT_NULL")
    TaiKhoan taiKhoan;
}
