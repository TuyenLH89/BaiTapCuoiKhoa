package BaiTapCuoiKhoa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "QuyenHan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuyenHan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaiQuyenHanId")
    int loaiQuyenHanId;

    @Column(name = "tenQuyenHan", nullable = false)
    @Size(max = 50, message = "TENQUYENHAN_INVALID")
    String tenQuyenHan;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quyenHan")
    @JsonIgnore
    @JsonManagedReference
    List<TaiKhoan> taiKhoans;
}
