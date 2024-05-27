package BaiTapCuoiKhoa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "TinhTrangHoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TinhTrangHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tinhTrangHocId")
    int tinhTrangHocId;

    @Column(name = "tenTinhTrang", nullable = false)
    @Size(max = 40, message = "TENTINHTRANG_INVALID")
    String tenTinhTrang;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tinhTrangHoc")
    @JsonIgnore
    @JsonManagedReference
    List<DangKyHoc> dangKyHocs;
}
