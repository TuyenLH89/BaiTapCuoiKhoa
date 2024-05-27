package BaiTapCuoiKhoa.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TinhTrangHoc_Response {
    int tinhTrangHocId;
    String tenTinhTrang;
}
