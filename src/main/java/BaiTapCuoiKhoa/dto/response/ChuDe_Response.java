package BaiTapCuoiKhoa.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChuDe_Response {
    int chuDeId;
    String tenChuDe;
    String noiDung;
    LoaiBaiViet_Response loaiBaiViet;
}
