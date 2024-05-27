package BaiTapCuoiKhoa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "LoaiBaiViet")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoaiBaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaiBaiVietId")
    int loaiBaiVietId;

    @Column(name = "tenLoaiBaiViet", nullable = false)
    @Size(max = 50, message = "TENLOAIBAIVIET_INVALID")
    String tenLoaiBaiViet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiBaiViet")
    @JsonIgnore
    @JsonManagedReference
    List<ChuDe> chuDes;
}
