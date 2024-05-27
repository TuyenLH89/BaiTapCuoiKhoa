package BaiTapCuoiKhoa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "LoaiKhoaHoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoaiKhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaiKhoaHocId")
    int loaiKhoaHocId;

    @Column(name = "tenLoaiKhoaHoc", nullable = false)
    @Size(max = 30, message = "TENLOAIKHOAHOC_INVALID")
    String tenLoaiKhoaHoc;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiKhoaHoc")
    @JsonIgnore
    @JsonManagedReference
    List<KhoaHoc> khoaHocs;
}
