package BaiTapCuoiKhoa.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KhoaHoc_Response {
    int khoaHocId;
    String tenKhoaHoc;
    int thoiGianHoc;
    String gioiThieu;
    String noiDung;
    double hocPhi;
    int soHocVien;
    int soLuongMon;
    String hinhAnh;
    LoaiKhoaHoc_Response loaiKhoaHoc;
}
