package BaiTapCuoiKhoa.mapper;

import BaiTapCuoiKhoa.dto.request.TinhTrangHoc_Request;
import BaiTapCuoiKhoa.dto.response.TinhTrangHoc_Response;
import BaiTapCuoiKhoa.entity.TinhTrangHoc;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TinhTrangHocMapper {
    TinhTrangHoc toTinhTrangHoc(TinhTrangHoc_Request request);
    TinhTrangHoc_Response toTinhTrangHocResponse(TinhTrangHoc tinhTrangHoc);
    void updateTinhTrangHoc(@MappingTarget TinhTrangHoc tinhTrangHoc, TinhTrangHoc_Request request);
}
