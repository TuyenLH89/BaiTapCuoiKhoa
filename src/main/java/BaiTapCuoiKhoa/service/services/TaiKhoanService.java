package BaiTapCuoiKhoa.service.services;

import BaiTapCuoiKhoa.dto.request.TaiKhoan_Request;
import BaiTapCuoiKhoa.dto.request.TaiKhoan_Update_Request;
import BaiTapCuoiKhoa.dto.response.TaiKhoan_Response;
import BaiTapCuoiKhoa.entity.BaiViet;
import BaiTapCuoiKhoa.entity.DangKyHoc;
import BaiTapCuoiKhoa.entity.QuyenHan;
import BaiTapCuoiKhoa.entity.TaiKhoan;
import BaiTapCuoiKhoa.exception.AppException;
import BaiTapCuoiKhoa.exception.ErrorCode;
import BaiTapCuoiKhoa.mapper.TaiKhoanMapper;
import BaiTapCuoiKhoa.repository.BaiVietRepo;
import BaiTapCuoiKhoa.repository.DangKyHocRepo;
import BaiTapCuoiKhoa.repository.QuyenHanRepo;
import BaiTapCuoiKhoa.repository.TaiKhoanRepo;
import BaiTapCuoiKhoa.service.serviceinterface.ITaiKhoan;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TaiKhoanService extends PhanTrang implements ITaiKhoan {
    TaiKhoanMapper taiKhoanMapper;
    TaiKhoanRepo taiKhoanRepo;
    QuyenHanRepo quyenHanRepo;
    BaiVietRepo baiVietRepo;
    DangKyHocRepo dangKyHocRepo;
    @Override
    public TaiKhoan_Response addTaiKoan(TaiKhoan_Request request) {
        if (taiKhoanRepo.existsByTaiKhoan(request.getTaiKhoan()))
            throw new AppException(ErrorCode.TAIKHOAN_EXIST);
        QuyenHan quyenHan = quyenHanRepo.findById(request.getQuyenHan().getLoaiQuyenHanId())
                        .orElseThrow(()-> new AppException(ErrorCode.QUYENHAN_NOT_EXIST));
        checkPassword(request.getMatKhau());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        TaiKhoan taiKhoan = taiKhoanMapper.toTaiKhoan(request);
        taiKhoan.setMatKhau(passwordEncoder.encode(request.getMatKhau()));
        taiKhoan.setQuyenHan(quyenHan);
        return taiKhoanMapper.toTaiKhoanResponse(taiKhoanRepo.save(taiKhoan));
    }

    @Override
    public TaiKhoan_Response updateTaiKhoan(int taiKhoanId, TaiKhoan_Update_Request request) {
        TaiKhoan taiKhoan = taiKhoanRepo.findById(taiKhoanId)
                .orElseThrow(()-> new AppException(ErrorCode.TAIKOAN_NOT_EXIST));

        if (checkPassword(request.getMatKhauCu(), taiKhoan.getMatKhau())){
            checkPassword(request.getMatKhauMoi());
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            taiKhoan.setMatKhau(passwordEncoder.encode(request.getMatKhauMoi()));
        }else
            throw new AppException(ErrorCode.MATKHAU_INVALID1);

        QuyenHan quyenHan = quyenHanRepo.findById(request.getQuyenHan().getLoaiQuyenHanId())
                .orElseThrow(()-> new AppException(ErrorCode.QUYENHAN_NOT_EXIST));
        taiKhoan.setQuyenHan(quyenHan);
        return taiKhoanMapper.toTaiKhoanResponse(taiKhoanRepo.save(taiKhoan));
    }

    @Override
    public void deleteTaiKhoan(int taiKhoanId) {
        for (BaiViet baiViet: baiVietRepo.findAll()){
            try {
                if (baiViet.getTaiKhoan().getTaiKhoanId() == taiKhoanId)
                    baiVietRepo.delete(baiViet);
            }catch (Exception ignored){
            }
        }
        for (DangKyHoc dangKyHoc: dangKyHocRepo.findAll()){
            try {
                if (dangKyHoc.getTaiKhoan().getTaiKhoanId() == taiKhoanId){
                    dangKyHocRepo.delete(dangKyHoc);
                }
            }catch (Exception ignored){
            }
        }
        taiKhoanRepo.deleteById(taiKhoanId);
    }

    @Override
    public List<?> getAll(int pageNo, int pageSize) {
        List<TaiKhoan_Response> list = new ArrayList<>();
        for (TaiKhoan taiKhoan: taiKhoanRepo.findAll()){
            list.add(taiKhoanMapper.toTaiKhoanResponse(taiKhoan));
        }
        return phanTrang(list, pageNo, pageSize);
    }

    @Override
    public void checkPassword(String password) {
        Pattern pLower = Pattern.compile("(?=.*?[a-z])");
        Pattern pDigit = Pattern.compile("(?=.*?[0-9])");
        Pattern pSpecial = Pattern.compile("(?=.*?[#?!@$%^&*-])");
        if (!pLower.matcher(password).find()) {
            throw new AppException(ErrorCode.PASSWORD_LOWER);
        } else if (!pDigit.matcher(password).find()) {
            throw new AppException(ErrorCode.PASSWORD_DIGIT);
        } else if (!pSpecial.matcher(password).find()) {
            throw new AppException(ErrorCode.PASSWORD_SPECIAL);
        }
    }

    @Override
    public boolean checkPassword(String passwordRequest, String passwordDB) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(passwordRequest, passwordDB);
    }

    @Override
    public List<?> searchByName(String tenTaiKhoan, int pageNo, int pageSize) {
        List<TaiKhoan_Response> list = new ArrayList<>();
        for (TaiKhoan taiKhoan: taiKhoanRepo.findAll()){
            try {
                if (taiKhoan.getTaiKhoan().toLowerCase().contains(tenTaiKhoan.toLowerCase()))
                    list.add(taiKhoanMapper.toTaiKhoanResponse(taiKhoan));
            }catch (Exception ignored){
            }
        }
        return phanTrang(list, pageNo, pageSize);
    }


}
