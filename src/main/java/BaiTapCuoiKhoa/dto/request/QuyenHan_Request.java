package BaiTapCuoiKhoa.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuyenHan_Request {
    @Size(max = 50, message = "TENQUYENHAN_INVALID")
    String tenQuyenHan;
}
