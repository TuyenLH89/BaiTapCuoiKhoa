package BaiTapCuoiKhoa.mapper;

import BaiTapCuoiKhoa.dto.request.LoaiBaiViet_Request;
import BaiTapCuoiKhoa.dto.response.LoaiBaiViet_Response;
import BaiTapCuoiKhoa.entity.LoaiBaiViet;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LoaiBaiVietMapper {
    LoaiBaiViet toLoaiBaiViet(LoaiBaiViet_Request request);
    LoaiBaiViet_Response toLoaiBaiVietResponse(LoaiBaiViet loaiBaiViet);
    void updateLoaiBaiViet(@MappingTarget LoaiBaiViet loaiBaiViet, LoaiBaiViet_Request request);
}
