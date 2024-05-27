package BaiTapCuoiKhoa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "DangKyHoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DangKyHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dangKyHocId")
    int dangKyHocId;

    @Column(name = "ngayDangKy")
    LocalDate ngayDangKy;

    @Column(name = "ngayBatDau")
    LocalDate ngayBatDau;

    @Column(name = "ngayKetThuc")
    LocalDate ngayKetThuc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "khoaHocId")
    @JsonBackReference
    @JsonIgnore
    KhoaHoc khoaHoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hocVienId")
    @JsonBackReference
    @JsonIgnore
    HocVien hocVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tinhTrangHocId")
    @JsonBackReference
    @JsonIgnore
    TinhTrangHoc tinhTrangHoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taiKhoanId")
    @JsonBackReference
    @JsonIgnore
    TaiKhoan taiKhoan;
}
