package BaiTapCuoiKhoa.repository;

import BaiTapCuoiKhoa.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepo extends JpaRepository<TaiKhoan, Integer> {
    boolean existsByTaiKhoan(String taiKhoan);
}
