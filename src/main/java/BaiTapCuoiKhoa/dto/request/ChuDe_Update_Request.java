package BaiTapCuoiKhoa.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChuDe_Update_Request {
    @NotNull(message = "NOIDUNG_NOT_NULL")
    String noiDung;
}
