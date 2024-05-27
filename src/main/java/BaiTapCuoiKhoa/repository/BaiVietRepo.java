package BaiTapCuoiKhoa.repository;

import BaiTapCuoiKhoa.entity.BaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BaiVietRepo extends JpaRepository<BaiViet, Integer> {
    boolean existsByTenBaiViet(String tenBaiViet);
}
