package BaiTapCuoiKhoa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "TaiKhoan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taiKhoanId")
    int taiKhoanId;

    @Column(name = "tenNguoiDung", nullable = false)
    @Size(max = 50, message = "TENNGUOIDUNG_INVALID")
    String tenNguoiDung;

    @Column(name = "taiKhoan", nullable = false, unique = true)
    @Size(max = 50, message = "TAIKHOAN_INVALID")
    String taiKhoan;

    @Column(name = "matKhau", nullable = false, length = 1000)
    String matKhau;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taiKhoan")
    @JsonIgnore
    @JsonManagedReference
    List<BaiViet> baiViets;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taiKhoan")
    @JsonIgnore
    @JsonManagedReference
    List<DangKyHoc> dangKyHocs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quyenHanId")
    @JsonBackReference
    @JsonIgnore
    QuyenHan quyenHan;
}
