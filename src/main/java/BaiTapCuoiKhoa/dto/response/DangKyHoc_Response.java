package BaiTapCuoiKhoa.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DangKyHoc_Response {
    int dangKyHocId;
    LocalDate ngayDangKy;
    LocalDate ngayBatDau;
    LocalDate ngayKetThuc;
    KhoaHoc_Response khoaHoc;
    HocVien_Response hocVien;
    TinhTrangHoc_Response tinhTrangHoc;
    TaiKhoan_Response taiKhoan;
}
