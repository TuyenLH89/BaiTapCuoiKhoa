package BaiTapCuoiKhoa.service.services;

import BaiTapCuoiKhoa.dto.request.LoaiBaiViet_Request;
import BaiTapCuoiKhoa.dto.response.LoaiBaiViet_Response;
import BaiTapCuoiKhoa.entity.LoaiBaiViet;
import BaiTapCuoiKhoa.exception.AppException;
import BaiTapCuoiKhoa.exception.ErrorCode;
import BaiTapCuoiKhoa.mapper.LoaiBaiVietMapper;
import BaiTapCuoiKhoa.repository.LoaiBaiVietRepo;
import BaiTapCuoiKhoa.service.serviceinterface.ILoaiBaiViet;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class LoaiBaiVietService extends PhanTrang implements ILoaiBaiViet {
    LoaiBaiVietMapper loaiBaiVietMapper;
    LoaiBaiVietRepo loaiBaiVietRepo;
    @Override
    public LoaiBaiViet_Response addLoaiBaiViet(LoaiBaiViet_Request request) {
        if (loaiBaiVietRepo.existsByTenLoaiBaiViet(request.getTenLoaiBaiViet()))
            throw new AppException(ErrorCode.LOAIBAIVIET_EXIST);
        LoaiBaiViet loaiBaiViet = loaiBaiVietMapper.toLoaiBaiViet(request);
        return loaiBaiVietMapper.toLoaiBaiVietResponse(loaiBaiVietRepo.save(loaiBaiViet));
    }

    @Override
    public LoaiBaiViet_Response updateLoaiBaiViet(int loaiBaiVietId, LoaiBaiViet_Request request) {
        LoaiBaiViet loaiBaiViet = loaiBaiVietRepo.findById(loaiBaiVietId)
                .orElseThrow(()-> new AppException(ErrorCode.LOAIBAIVIET_NOT_EXIST));
        if (loaiBaiVietRepo.existsByTenLoaiBaiViet(request.getTenLoaiBaiViet()))
            throw new AppException(ErrorCode.LOAIBAIVIET_EXIST);
        loaiBaiVietMapper.updateLoaiBaiViet(loaiBaiViet, request);
        return loaiBaiVietMapper.toLoaiBaiVietResponse(loaiBaiVietRepo.save(loaiBaiViet));
    }

    @Override
    public void deleteLoaiBaiViet(int loaiBaiVietId) {
        loaiBaiVietRepo.deleteById(loaiBaiVietId);
    }

    @Override
    public List<?> getAll(int pageNo, int pageSize) {
        List<LoaiBaiViet_Response> list = new ArrayList<>();
        for (LoaiBaiViet loaiBaiViet: loaiBaiVietRepo.findAll()){
            list.add(loaiBaiVietMapper.toLoaiBaiVietResponse(loaiBaiViet));
        }
        return phanTrang(list, pageNo, pageSize);
    }
}
