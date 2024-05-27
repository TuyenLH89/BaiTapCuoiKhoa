package BaiTapCuoiKhoa.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HocVien_Request {
    String hinhAnh;
    @Size(max = 50, message = "HOTEN_INVALID")
    String hoTen;
    LocalDate ngaySinh;
    @Size(max = 11, message = "SODIENTHOAI_INVALID")
    String soDienThoai;
    @Size(max = 40, message = "EMAIL_INVALID")
    String email;
    @Size(max = 50, message = "TINHTHANH_INVALID")
    String tinhThanh;
    @Size(max = 50, message = "QUANHUYEN_INVALID")
    String quanHuyen;
    @Size(max = 50, message = "PHUONGXA_INVALID")
    String phuongXa;
    @Size(max = 50, message = "SONHA_INVALID")
    String soNha;
}
