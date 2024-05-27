package BaiTapCuoiKhoa.repository;

import BaiTapCuoiKhoa.entity.ChuDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuDeRepo extends JpaRepository<ChuDe, Integer> {
    boolean existsByTenChuDe(String tenChuDe);
}
