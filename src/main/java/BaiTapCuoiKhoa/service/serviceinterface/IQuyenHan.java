package BaiTapCuoiKhoa.service.serviceinterface;

import BaiTapCuoiKhoa.dto.request.QuyenHan_Request;
import BaiTapCuoiKhoa.dto.response.QuyenHan_Response;

import java.util.List;

public interface IQuyenHan {
    //add
    QuyenHan_Response addQuyenHan(QuyenHan_Request request);

    //update
    QuyenHan_Response updateQuyenHan(int quyenHanId, QuyenHan_Request request);

    //delete
    void deleteQuyenHan(int quyenHanId);

    //get all
    List<?> getall(int pageNo, int pageSize);
}
