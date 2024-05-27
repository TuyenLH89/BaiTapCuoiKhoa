package BaiTapCuoiKhoa.mapper;

import BaiTapCuoiKhoa.dto.request.QuyenHan_Request;
import BaiTapCuoiKhoa.dto.response.QuyenHan_Response;
import BaiTapCuoiKhoa.entity.QuyenHan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface QuyenHanMapper {
    QuyenHan toQuyenHan(QuyenHan_Request request);
    QuyenHan_Response toQuyenHanResponse(QuyenHan quyenHan);
    void updateQuyenHan(@MappingTarget QuyenHan quyenHan, QuyenHan_Request request);
}
