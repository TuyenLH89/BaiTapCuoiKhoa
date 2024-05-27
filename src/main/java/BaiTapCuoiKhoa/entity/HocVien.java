package BaiTapCuoiKhoa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "HocVien")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HocVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hocVienId")
    int hocVienId;

    @Column(name = "hinhAnh", nullable = false)
    String hinhAnh;

    @Column(name = "hoTen", nullable = false)
    @Size(max = 50, message = "HOTEN_INVALID")
    String hoTen;

    @Column(name = "ngaySinh", nullable = false)
    LocalDate ngaySinh;

    @Column(name = "soDienThoai", nullable = false, unique = true)
    @Size(max = 11, message = "SODIENTHOAI_INVALID")
    String soDienThoai;

    @Column(name = "email", nullable = false, unique = true)
    @Size(max = 40, message = "EMAIL_INVALID")
    String email;

    @Column(name = "tinhThanh", nullable = false)
    @Size(max = 50, message = "TINHTHANH_INVALID")
    String tinhThanh;

    @Column(name = "quanHuyen", nullable = false)
    @Size(max = 50, message = "QUANHUYEN_INVALID")
    String quanHuyen;

    @Column(name = "phuongXa", nullable = false)
    @Size(max = 50, message = "PHUONGXA_INVALID")
    String phuongXa;

    @Column(name = "soNha", nullable = false)
    @Size(max = 50, message = "SONHA_INVALID")
    String soNha;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hocVien")
    @JsonIgnore
    @JsonManagedReference
    List<DangKyHoc> dangKyHocs;
}
