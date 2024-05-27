package BaiTapCuoiKhoa.service.serviceinterface;

import BaiTapCuoiKhoa.dto.request.DangKyHoc_Request;
import BaiTapCuoiKhoa.dto.request.DangKyHoc_Update_Request;
import BaiTapCuoiKhoa.dto.response.DangKyHoc_Response;

import java.util.List;

public interface IDangKyHoc {
    //add
    DangKyHoc_Response addDangKyHoc(DangKyHoc_Request request);

    //update
    DangKyHoc_Response updateDangKyHoc(int dangKyHocId, DangKyHoc_Update_Request request);

    //delete
    void delteteDangKyHoc(int dangKyHocId);

    //get all
    List<?> getAll(int pageNo, int pageSize);
}
