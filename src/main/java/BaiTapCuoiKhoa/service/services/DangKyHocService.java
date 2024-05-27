package BaiTapCuoiKhoa.service.services;

import BaiTapCuoiKhoa.dto.request.DangKyHoc_Request;
import BaiTapCuoiKhoa.dto.request.DangKyHoc_Update_Request;
import BaiTapCuoiKhoa.dto.response.DangKyHoc_Response;
import BaiTapCuoiKhoa.entity.*;
import BaiTapCuoiKhoa.exception.AppException;
import BaiTapCuoiKhoa.exception.ErrorCode;
import BaiTapCuoiKhoa.mapper.DangKyHocMapper;
import BaiTapCuoiKhoa.repository.*;
import BaiTapCuoiKhoa.service.serviceinterface.IDangKyHoc;
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
public class DangKyHocService extends PhanTrang implements IDangKyHoc {
    DangKyHocRepo dangKyHocRepo;
    DangKyHocMapper dangKyHocMapper;
    KhoaHocRepo khoaHocRepo;
    HocVienRepo hocVienRepo;
    TinhTrangHocRepo tinhTrangHocRepo;
    TaiKhoanRepo taiKhoanRepo;


    @Override
    public DangKyHoc_Response addDangKyHoc(DangKyHoc_Request request) {
        KhoaHoc khoaHoc = khoaHocRepo.findById(request.getKhoaHoc().getKhoaHocId())
                .orElseThrow(()-> new AppException(ErrorCode.KHOAHOC_NOT_EXIST));
        HocVien hocVien = hocVienRepo.findById(request.getHocVien().getHocVienId())
                .orElseThrow(()-> new AppException(ErrorCode.HOCVIEN_NOT_EXIST));
        TinhTrangHoc tinhTrangHoc = tinhTrangHocRepo.findTinhTrangHocByTenTinhTrang("Chờ duyệt")
                .orElseThrow(()-> new AppException(ErrorCode.TINHTRANGHOC_NOT_EXIST));
        TaiKhoan taiKhoan = taiKhoanRepo.findById(request.getTaiKhoan().getTaiKhoanId())
                .orElseThrow(()-> new AppException(ErrorCode.TAIKOAN_NOT_EXIST));
        DangKyHoc dangKyHoc = dangKyHocMapper.toDangKyHoc(request);
        dangKyHoc.setKhoaHoc(khoaHoc);
        dangKyHoc.setHocVien(hocVien);
        dangKyHoc.setTinhTrangHoc(tinhTrangHoc);
        dangKyHoc.setTaiKhoan(taiKhoan);
        dangKyHoc.setNgayDangKy(LocalDate.now());
        return dangKyHocMapper.toDangKyHocResponse(dangKyHocRepo.save(dangKyHoc));
    }

    @Override
    public DangKyHoc_Response updateDangKyHoc(int dangKyHocId, DangKyHoc_Update_Request request) {
        DangKyHoc dangKyHoc = dangKyHocRepo.findById(dangKyHocId)
                .orElseThrow(()-> new AppException(ErrorCode.DANGKYHOC_NOT_EXIST));
        TinhTrangHoc tinhTrangHoc = tinhTrangHocRepo.findById(request.getTinhTrangHoc().getTinhTrangHocId())
                .orElseThrow(()-> new AppException(ErrorCode.TINHTRANGHOC_NOT_EXIST));
        TinhTrangHoc tinhTrangHocOld = tinhTrangHocRepo.findById(dangKyHoc.getTinhTrangHoc().getTinhTrangHocId())
                .orElseThrow(()-> new AppException(ErrorCode.TINHTRANGHOC_NOT_EXIST));
        dangKyHocMapper.updateDangKyHoc(dangKyHoc, request);
        if (tinhTrangHocOld.getTenTinhTrang().equalsIgnoreCase(tinhTrangHoc.getTenTinhTrang())){
            throw new AppException(ErrorCode.TINHTRANGHOC_NOT_CHANGE);
        } else if (tinhTrangHoc.getTenTinhTrang().equalsIgnoreCase("Đang học chính")){
            dangKyHoc.setNgayBatDau(LocalDate.now());
            dangKyHoc.setNgayKetThuc(LocalDate.now().plusMonths(dangKyHoc.getKhoaHoc().getThoiGianHoc()));
        } else if (tinhTrangHoc.getTenTinhTrang().equalsIgnoreCase("Học xong")){
            if (dangKyHoc.getNgayKetThuc() == null || dangKyHoc.getNgayKetThuc().isAfter(LocalDate.now())){
                throw new AppException(ErrorCode.HOCVIEN_NOT_COMPLETE_KHOAHOC);
            }
        } else if (tinhTrangHoc.getTenTinhTrang().equalsIgnoreCase("Chưa hoàn thành")){
            if ((tinhTrangHocOld.getTenTinhTrang().equalsIgnoreCase("Đang học chính")))
                dangKyHoc.setNgayKetThuc(null);
            else
                throw new AppException(ErrorCode.HOCVIEN_NOT_START_KHOA_HOC);
        }
        dangKyHoc.setTinhTrangHoc(tinhTrangHoc);
        return dangKyHocMapper.toDangKyHocResponse(dangKyHocRepo.save(dangKyHoc));
    }

    @Override
    public void delteteDangKyHoc(int dangKyHocId) {
        dangKyHocRepo.deleteById(dangKyHocId);
    }

    @Override
    public List<?> getAll(int pageNo, int pageSize) {
        List<DangKyHoc_Response> list = new ArrayList<>();
        for (DangKyHoc dangKyHoc: dangKyHocRepo.findAll()){
            list.add(dangKyHocMapper.toDangKyHocResponse(dangKyHoc));
        }
        return phanTrang(list, pageNo, pageSize);
    }
}
