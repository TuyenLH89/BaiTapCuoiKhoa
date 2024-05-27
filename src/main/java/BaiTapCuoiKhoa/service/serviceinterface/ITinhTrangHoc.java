package BaiTapCuoiKhoa.service.serviceinterface;

import BaiTapCuoiKhoa.dto.request.TinhTrangHoc_Request;
import BaiTapCuoiKhoa.dto.response.TinhTrangHoc_Response;

import java.util.List;

public interface ITinhTrangHoc {
    //add
    TinhTrangHoc_Response addTinhTrangHoc(TinhTrangHoc_Request request);

    //update
    TinhTrangHoc_Response updateTinhTrangHoc(int tinhTrangHocId, TinhTrangHoc_Request request);

    //delete
    void deleteTinhTrangHoc(int tinhTrangHocId);

    //get all
    List<TinhTrangHoc_Response> getAll();
}
