package BaiTapCuoiKhoa.dto.request;

import BaiTapCuoiKhoa.entity.TinhTrangHoc;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DangKyHoc_Update_Request {
    TinhTrangHoc tinhTrangHoc;
}
