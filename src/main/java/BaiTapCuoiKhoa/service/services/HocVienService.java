package BaiTapCuoiKhoa.service.services;

import BaiTapCuoiKhoa.dto.request.HocVien_Request;
import BaiTapCuoiKhoa.dto.response.HocVien_Response;
import BaiTapCuoiKhoa.entity.HocVien;
import BaiTapCuoiKhoa.exception.AppException;
import BaiTapCuoiKhoa.exception.ErrorCode;
import BaiTapCuoiKhoa.mapper.HocVienMapper;
import BaiTapCuoiKhoa.repository.HocVienRepo;
import BaiTapCuoiKhoa.service.serviceinterface.IHocVien;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class HocVienService extends PhanTrang implements IHocVien {
    HocVienMapper hocVienMapper;
    HocVienRepo hocVienRepo;
    @Override
    public HocVien_Response addHocVien(HocVien_Request request) {
        var temp = new ArrayList<>();
        for (HocVien hocVien: hocVienRepo.findAll()){
            try {
                if (hocVien.getEmail().equals(request.getEmail()) || hocVien.getSoDienThoai().equals(request.getSoDienThoai())){
                    temp.add(hocVien);
                }
            }catch (Exception ignored){
            }
        }
        if (!temp.isEmpty()){
            throw new AppException(ErrorCode.HVREQUEST_INVALID);
        }
        HocVien hocVien = hocVienMapper.toHocVien(request);
        hocVien.setHoTen(formatTenHocVien(hocVien.getHoTen()));
        return hocVienMapper.toHocVienResponse(hocVienRepo.save(hocVien));
    }

    @Override
    public HocVien_Response updateHocVien(int hocVienId, HocVien_Request request) {
        HocVien hocVien = hocVienRepo.findById(hocVienId)
                .orElseThrow(()-> new AppException(ErrorCode.HOCVIEN_NOT_EXIST));
        hocVienMapper.updateHocVien(hocVien, request);
        return hocVienMapper.toHocVienResponse(hocVienRepo.save(hocVien));
    }

    @Override
    public void deleteHocVien(int hocVienId) {
        hocVienRepo.deleteById(hocVienId);
    }

    @Override
    public List<?> getAllHocVien(int pageNo, int pageSize) {
        List<HocVien_Response> list = new ArrayList<>();
        for (HocVien hocVien: hocVienRepo.findAll()){
            list.add(hocVienMapper.toHocVienResponse(hocVien));
        }
        return phanTrang(list, pageNo, pageSize);
    }

    @Override
    public List<?> searchByNameAndEmail(String tenHocVien, String tenEmail, int pageNo, int pageSize) {
        List<HocVien_Response> list = new ArrayList<>();
        for (HocVien hocVien: hocVienRepo.findAll()){
            try {
                if (hocVien.getHoTen().toLowerCase().contains(tenHocVien.toLowerCase()) && hocVien.getEmail().toLowerCase().contains(tenEmail.toLowerCase())){
                    list.add(hocVienMapper.toHocVienResponse(hocVien));
                }
            }catch (Exception ignored){
            }
        }
        return phanTrang(list, pageNo, pageSize);
    }

    @Override
    public String formatTenHocVien(String tenHocVien) {
        String[] temp = tenHocVien.split(" ");
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (String item: temp){
            if (i < temp.length-1){
                result.append(item.substring(0, 1).toUpperCase()).append(item.substring(1).toLowerCase()).append(" ");
                i++;
            }
            else
                result.append(item.substring(0, 1).toUpperCase()).append(item.substring(1).toLowerCase());
        }
        return result.toString();
    }
}
