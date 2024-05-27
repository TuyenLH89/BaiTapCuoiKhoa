package BaiTapCuoiKhoa.repository;

import BaiTapCuoiKhoa.entity.LoaiBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiBaiVietRepo extends JpaRepository<LoaiBaiViet, Integer> {
    boolean existsByTenLoaiBaiViet(String tenLoaiBaiViet);
}
