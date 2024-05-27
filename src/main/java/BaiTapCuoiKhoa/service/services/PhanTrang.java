package BaiTapCuoiKhoa.service.services;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PhanTrang {
    public List<?> phanTrang(List<?> list, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        int star = (int) pageable.getOffset();
        int end = Math.min((star+pageable.getPageSize()), list.size());
        list = list.subList(star, end);
        return new PageImpl<>(list, pageable, list.size()).getContent();
    }
}
