package BaiTapCuoiKhoa.service.services;

import BaiTapCuoiKhoa.dto.request.TinhTrangHoc_Request;
import BaiTapCuoiKhoa.dto.response.TinhTrangHoc_Response;
import BaiTapCuoiKhoa.entity.TinhTrangHoc;
import BaiTapCuoiKhoa.exception.AppException;
import BaiTapCuoiKhoa.exception.ErrorCode;
import BaiTapCuoiKhoa.mapper.TinhTrangHocMapper;
import BaiTapCuoiKhoa.repository.TinhTrangHocRepo;
import BaiTapCuoiKhoa.service.serviceinterface.ITinhTrangHoc;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TinhTrangHocService implements ITinhTrangHoc {
    TinhTrangHocMapper tinhTrangHocMapper;
    TinhTrangHocRepo tinhTrangHocRepo;

    @Override
    public TinhTrangHoc_Response addTinhTrangHoc(TinhTrangHoc_Request request) {
        if (tinhTrangHocRepo.existsByTenTinhTrang(request.getTenTinhTrang()))
            throw new AppException(ErrorCode.TINHTRANGHOC_EXIST);
        TinhTrangHoc tinhTrangHoc = tinhTrangHocMapper.toTinhTrangHoc(request);
        return tinhTrangHocMapper.toTinhTrangHocResponse(tinhTrangHocRepo.save(tinhTrangHoc));
    }

    @Override
    public TinhTrangHoc_Response updateTinhTrangHoc(int tinhTrangHocId, TinhTrangHoc_Request request) {
        TinhTrangHoc tinhTrangHoc = tinhTrangHocRepo.findById(tinhTrangHocId)
                .orElseThrow(()-> new AppException(ErrorCode.TINHTRANGHOC_NOT_EXIST));
        if (tinhTrangHocRepo.existsByTenTinhTrang(request.getTenTinhTrang()))
            throw new AppException(ErrorCode.TINHTRANGHOC_EXIST);
        tinhTrangHocMapper.updateTinhTrangHoc(tinhTrangHoc, request);
        return tinhTrangHocMapper.toTinhTrangHocResponse(tinhTrangHocRepo.save(tinhTrangHoc));
    }

    @Override
    public void deleteTinhTrangHoc(int tinhTrangHocId) {
        tinhTrangHocRepo.deleteById(tinhTrangHocId);
    }

    @Override
    public List<TinhTrangHoc_Response> getAll() {
        List<TinhTrangHoc_Response> list = new ArrayList<>();
        for (TinhTrangHoc tinhTrangHoc: tinhTrangHocRepo.findAll()){
            list.add(tinhTrangHocMapper.toTinhTrangHocResponse(tinhTrangHoc));
        }
        return list;
    }
}
