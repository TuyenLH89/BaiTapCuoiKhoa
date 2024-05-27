package BaiTapCuoiKhoa.service.services;

import BaiTapCuoiKhoa.dto.request.LoaiKhoaHoc_Request;
import BaiTapCuoiKhoa.dto.response.LoaiKhoaHoc_Response;
import BaiTapCuoiKhoa.entity.KhoaHoc;
import BaiTapCuoiKhoa.entity.LoaiKhoaHoc;
import BaiTapCuoiKhoa.exception.AppException;
import BaiTapCuoiKhoa.exception.ErrorCode;
import BaiTapCuoiKhoa.mapper.LoaiKhoaHocMapper;
import BaiTapCuoiKhoa.repository.LoaiKhoaHocRepo;
import BaiTapCuoiKhoa.service.serviceinterface.ILoaiKhoaHoc;
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
public class LoaiKhoaHocService extends PhanTrang implements ILoaiKhoaHoc {
    LoaiKhoaHocMapper loaiKhoaHocMapper;
    LoaiKhoaHocRepo loaiKhoaHocRepo;
    @Override
    public LoaiKhoaHoc_Response addLoaiKhoaHoc(LoaiKhoaHoc_Request request) {
        if (loaiKhoaHocRepo.existsByTenLoaiKhoaHoc(request.getTenLoaiKhoaHoc()))
            throw new AppException(ErrorCode.LOAIKHOAHOC_EXIST);
        LoaiKhoaHoc loaiKhoaHoc = loaiKhoaHocMapper.toLoaiKhoaHoc(request);
        return loaiKhoaHocMapper.toLoaiKhoaHocResponse(loaiKhoaHocRepo.save(loaiKhoaHoc));
    }

    @Override
    public LoaiKhoaHoc_Response updateLoaiKhoaHoc(int loaiKhoaHocId, LoaiKhoaHoc_Request request) {
        LoaiKhoaHoc loaiKhoaHoc = loaiKhoaHocRepo.findById(loaiKhoaHocId)
                .orElseThrow(()-> new AppException(ErrorCode.LOAIKHOAHOC_NOT_EXIST));
        loaiKhoaHocMapper.updateLoaiKhoaHoc(loaiKhoaHoc, request);
        return loaiKhoaHocMapper.toLoaiKhoaHocResponse(loaiKhoaHocRepo.save(loaiKhoaHoc));
    }

    @Override
    public void deleteLoaiKhoaHoc(int loaiKhoaHocId) {
        loaiKhoaHocRepo.deleteById(loaiKhoaHocId);
    }

    @Override
    public List<?> getAllLoaiKhoaHoc(int pageNo, int pageSize) {
        List<LoaiKhoaHoc_Response> list = new ArrayList<>();
        for (LoaiKhoaHoc loaiKhoaHoc: loaiKhoaHocRepo.findAll()){
            list.add(loaiKhoaHocMapper.toLoaiKhoaHocResponse(loaiKhoaHoc));
        }
        return phanTrang(list, pageNo, pageSize);
    }


}
