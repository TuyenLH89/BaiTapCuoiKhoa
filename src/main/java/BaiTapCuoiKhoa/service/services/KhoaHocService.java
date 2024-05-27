package BaiTapCuoiKhoa.service.services;

import BaiTapCuoiKhoa.dto.request.KhoaHoc_Request;
import BaiTapCuoiKhoa.dto.response.KhoaHoc_Response;
import BaiTapCuoiKhoa.entity.DangKyHoc;
import BaiTapCuoiKhoa.entity.KhoaHoc;
import BaiTapCuoiKhoa.entity.LoaiKhoaHoc;
import BaiTapCuoiKhoa.exception.AppException;
import BaiTapCuoiKhoa.exception.ErrorCode;
import BaiTapCuoiKhoa.mapper.KhoaHocMapper;
import BaiTapCuoiKhoa.repository.DangKyHocRepo;
import BaiTapCuoiKhoa.repository.KhoaHocRepo;
import BaiTapCuoiKhoa.repository.LoaiKhoaHocRepo;
import BaiTapCuoiKhoa.service.serviceinterface.IKhoahoc;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class KhoaHocService extends PhanTrang implements IKhoahoc{
    KhoaHocMapper khoaHocMapper;
    KhoaHocRepo khoaHocRepo;
    LoaiKhoaHocRepo loaiKhoaHocRepo;
    DangKyHocRepo dangKyHocRepo;

    @Override
    public KhoaHoc_Response addKhoaHoc(KhoaHoc_Request request) {
        KhoaHoc khoaHoc = khoaHocMapper.toKhoaHoc(request);
        LoaiKhoaHoc loaiKhoaHoc = loaiKhoaHocRepo.findById(khoaHoc.getLoaiKhoaHoc().getLoaiKhoaHocId())
                .orElseThrow(()-> new AppException(ErrorCode.LOAIKHOAHOC_NOT_EXIST));
        khoaHoc.setLoaiKhoaHoc(loaiKhoaHoc);
        if (khoaHocRepo.existsByTenKhoaHoc(khoaHoc.getTenKhoaHoc()) && khoaHocRepo.existsByLoaiKhoaHoc(loaiKhoaHoc))
            throw new AppException(ErrorCode.KHOAHOC_EXIST);
        return khoaHocMapper.toKhoaHocResponse(khoaHocRepo.save(khoaHoc));
    }

    @Override
    public KhoaHoc_Response updateKhoaHoc(int khoaHocId, KhoaHoc_Request request) {
        KhoaHoc khoaHoc = khoaHocRepo.findById(khoaHocId)
                .orElseThrow(()-> new AppException(ErrorCode.KHOAHOC_NOT_EXIST));
        LoaiKhoaHoc loaiKhoaHoc = loaiKhoaHocRepo.findById(request.getLoaiKhoaHoc().getLoaiKhoaHocId())
                .orElseThrow(()-> new AppException(ErrorCode.LOAIKHOAHOC_NOT_EXIST));
        if (khoaHoc.getTenKhoaHoc().equals(request.getTenKhoaHoc())){
            if (khoaHoc.getLoaiKhoaHoc().getLoaiKhoaHocId() == request.getLoaiKhoaHoc().getLoaiKhoaHocId()){
                khoaHocMapper.updateKhoaHoc(khoaHoc, request);
            }else {
                var temp = khoaHocRepo.findAll().stream().filter(x-> x.getTenKhoaHoc().equals(request.getTenKhoaHoc()) && x.getLoaiKhoaHoc().getLoaiKhoaHocId() == request.getLoaiKhoaHoc().getLoaiKhoaHocId()).toList();
                if (temp.isEmpty()){
                    khoaHocMapper.updateKhoaHoc(khoaHoc, request);
                }else
                    throw new AppException(ErrorCode.KHOAHOC_EXIST1);
            }

        }else{
            var temp = khoaHocRepo.findAll().stream().filter(x-> x.getTenKhoaHoc().equals(request.getTenKhoaHoc()) && x.getLoaiKhoaHoc().getLoaiKhoaHocId() == request.getLoaiKhoaHoc().getLoaiKhoaHocId()).toList();
            if (temp.isEmpty()){
                khoaHocMapper.updateKhoaHoc(khoaHoc, request);
            }else
                throw new AppException(ErrorCode.KHOAHOC_EXIST1);
        }
        khoaHoc.setLoaiKhoaHoc(loaiKhoaHoc);
        return khoaHocMapper.toKhoaHocResponse(khoaHocRepo.save(khoaHoc));
    }

    @Override
    public void deleteKhoaHoc(int khoaHocId) {
        for (DangKyHoc dangKyHoc: dangKyHocRepo.findAll()){
            try {
                if (dangKyHoc.getKhoaHoc().getKhoaHocId() == khoaHocId)
                    dangKyHocRepo.delete(dangKyHoc);
            }catch (Exception ignored){
            }
        }
        khoaHocRepo.deleteById(khoaHocId);
    }

    @Override
    public List<?> getAllKhoaHoc(int pageNo, int pageSize) {
        List<KhoaHoc_Response> list = new ArrayList<>();
        for (KhoaHoc khoaHoc: khoaHocRepo.findAll()){
            list.add(khoaHocMapper.toKhoaHocResponse(khoaHoc));
        }
        return phanTrang(list, pageNo, pageSize);
    }

    @Override
    public List<?> searchByTenKhoaHoc(String tenKhoaHoc, int pageNo, int pageSize) {
        List<KhoaHoc_Response> list = new ArrayList<>();
        var temp = khoaHocRepo.findAll().stream().filter(x-> x.getTenKhoaHoc().toLowerCase().contains(tenKhoaHoc.toLowerCase())).toList();
        for (KhoaHoc khoaHoc: temp){
            list.add(khoaHocMapper.toKhoaHocResponse(khoaHoc));
        }
        return phanTrang(list, pageNo, pageSize);
    }


}
