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
public class TaiKhoan_Update_Request {
    @Size(max = 50, message = "MATKHAU_INVALID")
    String matKhauMoi;
    String matKhauCu;
    QuyenHan quyenHan;
}
