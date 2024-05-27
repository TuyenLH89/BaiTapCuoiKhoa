package BaiTapCuoiKhoa.service.serviceinterface;

import BaiTapCuoiKhoa.dto.request.BaiViet_Request;
import BaiTapCuoiKhoa.dto.request.BaiViet_Update_Request;
import BaiTapCuoiKhoa.dto.response.BaiViet_Response;

import java.util.List;

public interface IBaiViet {
    //add
    BaiViet_Response addBaiViet(BaiViet_Request request);

    //update
    BaiViet_Response updateBaiViet(int baiVietId, BaiViet_Update_Request request);

    //delete
    void deleteBaiViet(int baiVietId);

    //get all
    List<?> getAll(int pageNo, int pageSize);

    //search by name
    List<?> searchByName(String tenBaiViet, int pageNo, int pageSize);
}
