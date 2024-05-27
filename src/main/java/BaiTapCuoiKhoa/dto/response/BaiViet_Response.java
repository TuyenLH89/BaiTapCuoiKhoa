package BaiTapCuoiKhoa.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaiViet_Response {
    int baiVietId;
    String tenBaiViet;
    String tenTacGia;
    String noiDung;
    String noiDungNgan;
    LocalDate thoiGianTao;
    String hinhAnh;
    ChuDe_Response chuDe;
    TaiKhoan_Response taiKhoan;
}
