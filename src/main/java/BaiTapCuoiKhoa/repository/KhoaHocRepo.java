package BaiTapCuoiKhoa.repository;

import BaiTapCuoiKhoa.entity.KhoaHoc;
import BaiTapCuoiKhoa.entity.LoaiKhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoaHocRepo extends JpaRepository<KhoaHoc, Integer> {
    boolean existsByTenKhoaHoc(String tenKhoaHoc);
    boolean existsByLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc);
}
