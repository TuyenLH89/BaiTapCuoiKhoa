package BaiTapCuoiKhoa.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HocVien_Response {
    int hocVienId;
    String hinhAnh;
    String hoTen;
    LocalDate ngaySinh;
    String soDienThoai;
    String email;
    String tinhThanh;
    String quanHuyen;
    String phuongXa;
    String soNha;
}
