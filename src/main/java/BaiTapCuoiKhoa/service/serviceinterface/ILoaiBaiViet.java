package BaiTapCuoiKhoa.service.serviceinterface;

import BaiTapCuoiKhoa.dto.request.LoaiBaiViet_Request;
import BaiTapCuoiKhoa.dto.response.LoaiBaiViet_Response;

import java.util.List;

public interface ILoaiBaiViet {
    //add
    LoaiBaiViet_Response addLoaiBaiViet(LoaiBaiViet_Request request);

    //update
    LoaiBaiViet_Response updateLoaiBaiViet(int loaiBaiVietId, LoaiBaiViet_Request request);

    //delete
    void deleteLoaiBaiViet(int loaiBaiVietId);

    //get all
    List<?> getAll(int pageNo, int pageSize);
}
