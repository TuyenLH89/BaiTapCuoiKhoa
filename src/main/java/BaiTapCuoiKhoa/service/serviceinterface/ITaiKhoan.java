package BaiTapCuoiKhoa.service.serviceinterface;

import BaiTapCuoiKhoa.dto.request.TaiKhoan_Request;
import BaiTapCuoiKhoa.dto.request.TaiKhoan_Update_Request;
import BaiTapCuoiKhoa.dto.response.TaiKhoan_Response;

import java.util.List;

public interface ITaiKhoan {
    //add
    TaiKhoan_Response addTaiKoan(TaiKhoan_Request request);

    //update
    TaiKhoan_Response updateTaiKhoan(int taiKhoanId, TaiKhoan_Update_Request request);

    //delete
    void deleteTaiKhoan(int taiKhoanId);

    //get all
    List<?> getAll(int pageNo, int pageSize);

    //check password khi tạo
    void checkPassword(String password);
    //check password khi update
    boolean checkPassword(String passwordRequest, String passwordDB);

    //search by name
    List<?> searchByName(String tenTaiKhoan, int pageNo, int pageSize);
}
