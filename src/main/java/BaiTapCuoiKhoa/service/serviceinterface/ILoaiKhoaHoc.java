package BaiTapCuoiKhoa.service.serviceinterface;

import BaiTapCuoiKhoa.dto.request.LoaiKhoaHoc_Request;
import BaiTapCuoiKhoa.dto.response.LoaiKhoaHoc_Response;

import java.util.List;

public interface ILoaiKhoaHoc {
    //add
    LoaiKhoaHoc_Response addLoaiKhoaHoc(LoaiKhoaHoc_Request request);

    //update
    LoaiKhoaHoc_Response updateLoaiKhoaHoc(int loaiKhoaHocId, LoaiKhoaHoc_Request request);

    //delete
    void deleteLoaiKhoaHoc(int loaiKhoaHocId);

    //lấy danh sách loại khóa học
    List<?> getAllLoaiKhoaHoc(int pageNo, int pageSize);


}
