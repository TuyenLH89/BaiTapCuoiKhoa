package BaiTapCuoiKhoa.service.serviceinterface;

import BaiTapCuoiKhoa.dto.request.KhoaHoc_Request;
import BaiTapCuoiKhoa.dto.response.KhoaHoc_Response;

import java.util.List;

public interface IKhoahoc {
    //add
    KhoaHoc_Response addKhoaHoc(KhoaHoc_Request request);

    //update
    KhoaHoc_Response updateKhoaHoc(int khoaHocId, KhoaHoc_Request request);

    //delete
    void deleteKhoaHoc(int khoaHocId);

    //lấy danh sách
    List<?> getAllKhoaHoc(int pageNo, int pageSize);

    //tìm kiếm khóa học theo tên
    List<?> searchByTenKhoaHoc(String tenKhoaHoc, int pageNo, int pageSize);
}
