package BaiTapCuoiKhoa.dto.request;

import BaiTapCuoiKhoa.entity.LoaiBaiViet;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChuDe_Request {
    @Size(min = 1, max = 50, message = "TENCHUDE_INVALID")
    @NotNull(message = "TENCHUDE_NOT_NULL")
    String tenChuDe;
    @NotNull(message = "NOIDUNG_NOT_NULL")
    String noiDung;
    @NotNull(message = "LOAIBAIVIET_NOT_NULL")
    LoaiBaiViet loaiBaiViet;
}
