package BaiTapCuoiKhoa.service.services;

import BaiTapCuoiKhoa.dto.request.ChuDe_Request;
import BaiTapCuoiKhoa.dto.request.ChuDe_Update_Request;
import BaiTapCuoiKhoa.dto.response.ChuDe_Response;
import BaiTapCuoiKhoa.entity.BaiViet;
import BaiTapCuoiKhoa.entity.ChuDe;
import BaiTapCuoiKhoa.entity.LoaiBaiViet;
import BaiTapCuoiKhoa.exception.AppException;
import BaiTapCuoiKhoa.exception.ErrorCode;
import BaiTapCuoiKhoa.mapper.ChuDeMapper;
import BaiTapCuoiKhoa.repository.BaiVietRepo;
import BaiTapCuoiKhoa.repository.ChuDeRepo;
import BaiTapCuoiKhoa.repository.LoaiBaiVietRepo;
import BaiTapCuoiKhoa.service.serviceinterface.IChuDe;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ChuDeService extends PhanTrang implements IChuDe {
    ChuDeMapper chuDeMapper;
    ChuDeRepo chuDeRepo;
    LoaiBaiVietRepo loaiBaiVietRepo;
    BaiVietRepo baiVietRepo;
    @Override
    public ChuDe_Response addChuDe(ChuDe_Request request) {
        if (chuDeRepo.existsByTenChuDe(request.getTenChuDe()))
            throw new AppException(ErrorCode.CHUDE_EXIST);
        LoaiBaiViet loaiBaiViet = loaiBaiVietRepo.findById(request.getLoaiBaiViet().getLoaiBaiVietId())
                .orElseThrow(()-> new AppException(ErrorCode.LOAIBAIVIET_NOT_EXIST));
        ChuDe chuDe = chuDeMapper.toChuDe(request);
        chuDe.setLoaiBaiViet(loaiBaiViet);
        return chuDeMapper.toChuDeResponse(chuDeRepo.save(chuDe));
    }

    @Override
    public ChuDe_Response updateChuDe(int chuDeId, ChuDe_Update_Request request) {
        ChuDe chuDe = chuDeRepo.findById(chuDeId)
                .orElseThrow(()-> new AppException(ErrorCode.CHUDE_NOT_EXIST));

        chuDeMapper.updateChuDe(chuDe, request);
        return chuDeMapper.toChuDeResponse(chuDeRepo.save(chuDe));
    }

    @Override
    public void deleteChuDe(int chuDeId) {
        for (BaiViet baiViet: baiVietRepo.findAll()){
            try {
                if (baiViet.getChuDe().getChuDeId() == chuDeId){
                    baiViet.setChuDe(null);
                }
            }catch (Exception ignored){
            }
        }
        chuDeRepo.deleteById(chuDeId);
    }

    @Override
    public List<?> getAll(int pageNo, int pageSize) {
        List<ChuDe_Response> list = new ArrayList<>();
        for (ChuDe chuDe: chuDeRepo.findAll()){
            try {
                LoaiBaiViet loaiBaiViet = loaiBaiVietRepo.findById(chuDe.getLoaiBaiViet().getLoaiBaiVietId())
                                .orElseThrow(() -> new AppException(ErrorCode.LOAIBAIVIET_NOT_EXIST));
                chuDe.setLoaiBaiViet(loaiBaiViet);
                list.add(chuDeMapper.toChuDeResponse(chuDe));
            }catch (Exception ignored){
            }

        }
        return phanTrang(list, pageNo, pageSize);
    }
}
