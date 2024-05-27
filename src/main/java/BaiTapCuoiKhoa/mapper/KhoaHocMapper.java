package BaiTapCuoiKhoa.mapper;

import BaiTapCuoiKhoa.dto.request.KhoaHoc_Request;
import BaiTapCuoiKhoa.dto.response.KhoaHoc_Response;
import BaiTapCuoiKhoa.entity.KhoaHoc;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface KhoaHocMapper {
    KhoaHoc toKhoaHoc(KhoaHoc_Request request);
    KhoaHoc_Response toKhoaHocResponse(KhoaHoc khoaHoc);
    void updateKhoaHoc(@MappingTarget KhoaHoc khoaHoc, KhoaHoc_Request request);
}
