package BaiTapCuoiKhoa.mapper;

import BaiTapCuoiKhoa.dto.request.ChuDe_Request;
import BaiTapCuoiKhoa.dto.request.ChuDe_Update_Request;
import BaiTapCuoiKhoa.dto.response.ChuDe_Response;
import BaiTapCuoiKhoa.entity.ChuDe;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ChuDeMapper {
    ChuDe toChuDe(ChuDe_Request request);
    ChuDe_Response toChuDeResponse(ChuDe chuDe);
    void updateChuDe(@MappingTarget ChuDe chuDe, ChuDe_Update_Request request);
}
