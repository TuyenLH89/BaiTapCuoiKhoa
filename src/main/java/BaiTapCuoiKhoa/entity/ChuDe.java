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
@Table(name = "ChuDe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChuDe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chiDeId")
    int chuDeId;

    @Column(name = "tenChuDe", nullable = false)
    @Size(max = 50, message = "TENCHUDE_INVALID")
    String tenChuDe;

    @Column(name = "noiDung", nullable = false)
    String noiDung;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chuDe")
    @JsonIgnore
    @JsonManagedReference
    List<BaiViet> baiViets;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loaiBaiVietId")
    @JsonBackReference
    @JsonIgnore
    LoaiBaiViet loaiBaiViet;
}
