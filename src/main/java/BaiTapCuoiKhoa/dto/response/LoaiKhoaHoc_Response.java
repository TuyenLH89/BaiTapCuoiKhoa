package BaiTapCuoiKhoa.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoaiKhoaHoc_Response {
    int loaiKhoaHocId;
    String tenLoaiKhoaHoc;
}
