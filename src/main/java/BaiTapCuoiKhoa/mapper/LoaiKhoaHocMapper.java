package BaiTapCuoiKhoa.mapper;

import BaiTapCuoiKhoa.dto.request.LoaiKhoaHoc_Request;
import BaiTapCuoiKhoa.dto.response.LoaiKhoaHoc_Response;
import BaiTapCuoiKhoa.entity.LoaiKhoaHoc;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LoaiKhoaHocMapper {
    LoaiKhoaHoc toLoaiKhoaHoc(LoaiKhoaHoc_Request request);
    LoaiKhoaHoc_Response toLoaiKhoaHocResponse(LoaiKhoaHoc loaiKhoaHoc);
    void updateLoaiKhoaHoc(@MappingTarget LoaiKhoaHoc loaiKhoaHoc, LoaiKhoaHoc_Request request);
}
