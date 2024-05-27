package BaiTapCuoiKhoa.service.services;

import BaiTapCuoiKhoa.dto.request.QuyenHan_Request;
import BaiTapCuoiKhoa.dto.response.QuyenHan_Response;
import BaiTapCuoiKhoa.entity.QuyenHan;
import BaiTapCuoiKhoa.exception.AppException;
import BaiTapCuoiKhoa.exception.ErrorCode;
import BaiTapCuoiKhoa.mapper.QuyenHanMapper;
import BaiTapCuoiKhoa.repository.QuyenHanRepo;
import BaiTapCuoiKhoa.service.serviceinterface.IQuyenHan;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class QuyenHanService extends PhanTrang implements IQuyenHan {
    QuyenHanMapper quyenHanMapper;
    QuyenHanRepo quyenHanRepo;
    @Override
    public QuyenHan_Response addQuyenHan(QuyenHan_Request request) {
        if (quyenHanRepo.existsByTenQuyenHan(request.getTenQuyenHan()))
            throw new AppException(ErrorCode.QUYENHAN_EXIST);
        QuyenHan quyenHan = quyenHanMapper.toQuyenHan(request);
        return quyenHanMapper.toQuyenHanResponse(quyenHanRepo.save(quyenHan));
    }

    @Override
    public QuyenHan_Response updateQuyenHan(int quyenHanId, QuyenHan_Request request) {
        QuyenHan quyenHan = quyenHanRepo.findById(quyenHanId)
                .orElseThrow(()-> new AppException(ErrorCode.QUYENHAN_NOT_EXIST));
        if (quyenHanRepo.existsByTenQuyenHan(request.getTenQuyenHan()))
            throw new AppException(ErrorCode.QUYENHAN_EXIST);
        quyenHanMapper.updateQuyenHan(quyenHan, request);
        return quyenHanMapper.toQuyenHanResponse(quyenHanRepo.save(quyenHan));
    }

    @Override
    public void deleteQuyenHan(int quyenHanId) {
        quyenHanRepo.deleteById(quyenHanId);
    }

    @Override
    public List<?> getall(int pageNo, int pageSize) {
        List<QuyenHan_Response> list = new ArrayList<>();
        for (QuyenHan quyenHan: quyenHanRepo.findAll()){
            list.add(quyenHanMapper.toQuyenHanResponse(quyenHan));
        }
        return phanTrang(list, pageNo, pageSize);
    }
}
