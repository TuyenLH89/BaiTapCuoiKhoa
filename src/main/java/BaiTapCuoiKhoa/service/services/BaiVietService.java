package BaiTapCuoiKhoa.service.services;

import BaiTapCuoiKhoa.dto.request.BaiViet_Request;
import BaiTapCuoiKhoa.dto.request.BaiViet_Update_Request;
import BaiTapCuoiKhoa.dto.response.BaiViet_Response;
import BaiTapCuoiKhoa.entity.BaiViet;
import BaiTapCuoiKhoa.entity.ChuDe;
import BaiTapCuoiKhoa.entity.TaiKhoan;
import BaiTapCuoiKhoa.exception.AppException;
import BaiTapCuoiKhoa.exception.ErrorCode;
import BaiTapCuoiKhoa.mapper.BaiVietMapper;
import BaiTapCuoiKhoa.repository.BaiVietRepo;
import BaiTapCuoiKhoa.repository.ChuDeRepo;
import BaiTapCuoiKhoa.repository.TaiKhoanRepo;
import BaiTapCuoiKhoa.service.serviceinterface.IBaiViet;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BaiVietService extends PhanTrang implements IBaiViet {
    BaiVietMapper baiVietMapper;
    BaiVietRepo baiVietRepo;
    ChuDeRepo chuDeRepo;
    TaiKhoanRepo taiKhoanRepo;


    @Override
    public BaiViet_Response addBaiViet(BaiViet_Request request) {
        if (baiVietRepo.existsByTenBaiViet(request.getTenBaiViet()))
            throw new AppException(ErrorCode.BAIVIET_EXIST);
        ChuDe chuDe = chuDeRepo.findById(request.getChuDe().getChuDeId())
                .orElseThrow(()-> new AppException(ErrorCode.CHUDE_NOT_EXIST));
        TaiKhoan taiKhoan = taiKhoanRepo.findById(request.getTaiKhoan().getTaiKhoanId())
                .orElseThrow(()-> new AppException(ErrorCode.TAIKOAN_NOT_EXIST));
        BaiViet baiViet = baiVietMapper.toBaiViet(request);
        baiViet.setChuDe(chuDe);
        baiViet.setTaiKhoan(taiKhoan);
        baiViet.setThoiGianTao(LocalDate.now());
        return baiVietMapper.toBaiVietResponse(baiVietRepo.save(baiViet));
    }

    @Override
    public BaiViet_Response updateBaiViet(int baiVietId, BaiViet_Update_Request request) {
        BaiViet baiViet = baiVietRepo.findById(baiVietId)
                .orElseThrow(()-> new AppException(ErrorCode.BAIVIET_NOT_EXIST));
        baiVietMapper.updateBaiViet(baiViet, request);
        return baiVietMapper.toBaiVietResponse(baiViet);
    }

    @Override
    public void deleteBaiViet(int baiVietId) {
        baiVietRepo.deleteById(baiVietId);
    }

    @Override
    public List<?> getAll(int pageNo, int pageSize) {
        List<BaiViet_Response> list = new ArrayList<>();
        for (BaiViet baiViet: baiVietRepo.findAll()){
            list.add(baiVietMapper.toBaiVietResponse(baiViet));
        }
        return phanTrang(list,pageNo, pageSize);
    }

    @Override
    public List<?> searchByName(String tenBaiViet, int pageNo, int pageSize) {
        List<BaiViet_Response> list = new ArrayList<>();
        for (BaiViet baiViet: baiVietRepo.findAll()){
            try {
                if (baiViet.getTenBaiViet().toLowerCase().contains(tenBaiViet.toLowerCase())){
                    list.add(baiVietMapper.toBaiVietResponse(baiViet));
                }
            }catch (Exception ignored){
            }
        }
        return phanTrang(list, pageNo, pageSize);
    }
}
