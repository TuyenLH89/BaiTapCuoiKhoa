package BaiTapCuoiKhoa.dto.request;

import BaiTapCuoiKhoa.entity.QuyenHan;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoan_Request {
    @Size(max = 50, message = "TENNGUOIDUNG_INVALID")
    String tenNguoiDung;
    @Size(max = 50, message = "TAIKHOAN_INVALID")
    String taiKhoan;
    @Size(max = 50, message = "MATKHAU_INVALID")
    String matKhau;
    QuyenHan quyenHan;
}
