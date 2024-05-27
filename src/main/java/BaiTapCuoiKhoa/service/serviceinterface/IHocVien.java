package BaiTapCuoiKhoa.service.serviceinterface;

import BaiTapCuoiKhoa.dto.request.HocVien_Request;
import BaiTapCuoiKhoa.dto.response.HocVien_Response;
import BaiTapCuoiKhoa.service.services.PhanTrang;

import java.util.List;

public interface IHocVien{
    //add
    HocVien_Response addHocVien(HocVien_Request request);

    //update
    HocVien_Response updateHocVien(int hocVienId, HocVien_Request request);

    //delete
    void deleteHocVien(int hocVienId);

    //get all
    List<?> getAllHocVien(int pageNo, int pageSize);

    //tìm kiếm hoc viên theo tên và email
    List<?> searchByNameAndEmail(String tenHocVien, String tenEmail, int pageNo, int pageSize);

    //định dạng tên
    String formatTenHocVien(String tenHocVien);
}
