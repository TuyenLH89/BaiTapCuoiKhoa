package BaiTapCuoiKhoa.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TinhTrangHoc_Request {
    @Size(max = 40, message = "TENTINHTRANG_INVALID")
    String tenTinhTrang;
}
