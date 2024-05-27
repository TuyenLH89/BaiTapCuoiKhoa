package BaiTapCuoiKhoa.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoaiKhoaHoc_Request {
    @Size(max = 30, message = "TENLOAIKHOAHOC_INVALID")
    String tenLoaiKhoaHoc;
}
