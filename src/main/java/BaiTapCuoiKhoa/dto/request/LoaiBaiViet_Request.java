package BaiTapCuoiKhoa.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoaiBaiViet_Request {
    @Size(max = 50, message = "TENLOAIBAIVIET_INVALID")
    String tenLoaiBaiViet;
}
