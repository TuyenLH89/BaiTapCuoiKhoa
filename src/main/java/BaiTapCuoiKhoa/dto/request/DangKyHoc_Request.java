package BaiTapCuoiKhoa.dto.request;

import BaiTapCuoiKhoa.entity.HocVien;
import BaiTapCuoiKhoa.entity.KhoaHoc;
import BaiTapCuoiKhoa.entity.TaiKhoan;
import BaiTapCuoiKhoa.entity.TinhTrangHoc;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DangKyHoc_Request {
    KhoaHoc khoaHoc;
    HocVien hocVien;
    TinhTrangHoc tinhTrangHoc;
    TaiKhoan taiKhoan;
}
