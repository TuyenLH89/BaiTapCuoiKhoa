package BaiTapCuoiKhoa.mapper;

import BaiTapCuoiKhoa.dto.request.HocVien_Request;
import BaiTapCuoiKhoa.dto.response.HocVien_Response;
import BaiTapCuoiKhoa.entity.HocVien;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HocVienMapper {
    HocVien toHocVien(HocVien_Request request);
    HocVien_Response toHocVienResponse(HocVien hocVien);
    void updateHocVien(@MappingTarget HocVien hocVien, HocVien_Request request);
}
