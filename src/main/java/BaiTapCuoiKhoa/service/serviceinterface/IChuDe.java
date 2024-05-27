package BaiTapCuoiKhoa.service.serviceinterface;

import BaiTapCuoiKhoa.dto.request.ChuDe_Request;
import BaiTapCuoiKhoa.dto.request.ChuDe_Update_Request;
import BaiTapCuoiKhoa.dto.response.ChuDe_Response;

import java.util.List;

public interface IChuDe {
    //add
    ChuDe_Response addChuDe(ChuDe_Request request);

    //update
    ChuDe_Response updateChuDe(int chuDeId, ChuDe_Update_Request request);

    //delete
    void deleteChuDe(int chuDeId);

    //get all
    List<?> getAll(int pageNo, int pageSize);
}
