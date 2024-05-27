package BaiTapCuoiKhoa.mapper;

import BaiTapCuoiKhoa.dto.request.TaiKhoan_Request;
import BaiTapCuoiKhoa.dto.request.TaiKhoan_Update_Request;
import BaiTapCuoiKhoa.dto.response.TaiKhoan_Response;
import BaiTapCuoiKhoa.entity.TaiKhoan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaiKhoanMapper {
    TaiKhoan toTaiKhoan(TaiKhoan_Request request);
    TaiKhoan_Response toTaiKhoanResponse(TaiKhoan taiKhoan);
}
