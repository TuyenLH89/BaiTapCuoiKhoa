package BaiTapCuoiKhoa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "BaiViet")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baiVietId")
    int baiVietId;

    @Size(max = 50, message = "TENBAIVIET_INVALID")
    @Column(name = "tenBaiViet", nullable = false)
    String tenBaiViet;

    @Size(max = 50, message = "TENTACGIA_INVALID")
    @Column(name = "tenTacGia", nullable = false)
    String tenTacGia;

    @Column(name = "noiDung", nullable = false)
    String noiDung;

    @Column(name = "noiDungNgan", nullable = false)
    @Size(max = 1000, message = "NOIDUNGNGAN_INVALID")
    String noiDungNgan;

    @Column(name = "thoiGianTao", nullable = false)
    LocalDate thoiGianTao;

    @Column(name = "hinhAnh", nullable = false)
    String hinhAnh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chuDeId")
    @JsonBackReference
    @JsonIgnore
    ChuDe chuDe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taiKhoanId")
    @JsonBackReference
    @JsonIgnore
    TaiKhoan taiKhoan;
}
