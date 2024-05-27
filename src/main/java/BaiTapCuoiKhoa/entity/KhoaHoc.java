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
@Table(name = "KhoaHoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "khoaHocId")
    int khoaHocId;

    @Column(name = "tenKhoaHoc", nullable = false)
    @Size(max = 50, message = "TENKHOAHOC_INVALID")
    String tenKhoaHoc;

    @Column(name = "thoiGianHoc", nullable = false)
    int thoiGianHoc;

    @Column(name = "gioiThieu", nullable = false)
    String gioiThieu;

    @Column(name = "noiDung", nullable = false)
    String noiDung;

    @Column(name = "hocPhi", nullable = false)
    double hocPhi;

    @Column(name = "soHocVien", nullable = false)
    int soHocVien;

    @Column(name = "soLuongMon", nullable = false)
    int soLuongMon;

    @Column(name = "hinhAnh", nullable = false)
    String hinhAnh;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "khoaHoc")
    @JsonIgnore
    @JsonManagedReference
    List<DangKyHoc> dangKyHocs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loaiKhoaHocId")
    @JsonBackReference
    @JsonIgnore
    LoaiKhoaHoc loaiKhoaHoc;
}
