package BaiTapCuoiKhoa.mapper;

import BaiTapCuoiKhoa.dto.request.DangKyHoc_Request;
import BaiTapCuoiKhoa.dto.request.DangKyHoc_Update_Request;
import BaiTapCuoiKhoa.dto.response.DangKyHoc_Response;
import BaiTapCuoiKhoa.entity.DangKyHoc;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DangKyHocMapper {
    DangKyHoc toDangKyHoc(DangKyHoc_Request request);
    DangKyHoc_Response toDangKyHocResponse(DangKyHoc dangKyHoc);
    void updateDangKyHoc(@MappingTarget DangKyHoc dangKyHoc, DangKyHoc_Update_Request request);
}
