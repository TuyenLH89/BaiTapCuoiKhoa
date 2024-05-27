package BaiTapCuoiKhoa.repository;

import BaiTapCuoiKhoa.entity.TinhTrangHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TinhTrangHocRepo extends JpaRepository<TinhTrangHoc, Integer> {
    boolean existsByTenTinhTrang(String tenTinhTrangHoc);
    Optional<TinhTrangHoc> findTinhTrangHocByTenTinhTrang(String tenTinhTrangHoc);
}
