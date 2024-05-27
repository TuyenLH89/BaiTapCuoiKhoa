package BaiTapCuoiKhoa.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaiViet_Update_Request {
    @NotNull(message = "NOIDUNG_NOT_NULL")
    String noiDung;
    @NotNull(message = "NOIDUNGNGAN_NOT_NULL")
    @Size(max = 1000, message = "NOIDUNGNGAN_INVALID")
    String noiDungNgan;
    @NotNull(message = "HINHANH_NOT_NULL")
    String hinhAnh;
}
