package BaiTapCuoiKhoa.mapper;

import BaiTapCuoiKhoa.dto.request.BaiViet_Request;
import BaiTapCuoiKhoa.dto.request.BaiViet_Update_Request;
import BaiTapCuoiKhoa.dto.response.BaiViet_Response;
import BaiTapCuoiKhoa.entity.BaiViet;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BaiVietMapper {
    BaiViet toBaiViet(BaiViet_Request request);
    BaiViet_Response toBaiVietResponse(BaiViet baiViet);
    void updateBaiViet(@MappingTarget BaiViet baiViet, BaiViet_Update_Request request);

}
