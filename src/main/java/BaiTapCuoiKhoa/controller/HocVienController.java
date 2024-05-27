package BaiTapCuoiKhoa.controller;

import BaiTapCuoiKhoa.dto.request.HocVien_Request;
import BaiTapCuoiKhoa.dto.response.ApiResponse;
import BaiTapCuoiKhoa.dto.response.HocVien_Response;
import BaiTapCuoiKhoa.service.services.HocVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hocvien")
public class HocVienController {
    @Autowired
    HocVienService hocVienService;
    @GetMapping("/getall/{pageNo}-{pageSize}")
    ApiResponse<List<?>> getAllHocVien(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize){
        ApiResponse<List<?>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(hocVienService.getAllHocVien(pageNo, pageSize));
        return apiResponse;
    }

    @PostMapping("/add")
    ApiResponse<HocVien_Response> addHocVien(@RequestBody @Valid HocVien_Request request){
        ApiResponse<HocVien_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(hocVienService.addHocVien(request));
        return apiResponse;
    }

    @PutMapping("/update/{id}")
    ApiResponse<HocVien_Response> updateHocVien(@PathVariable("id") int hocVienId, @RequestBody @Valid HocVien_Request request){
        ApiResponse<HocVien_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(hocVienService.updateHocVien(hocVienId, request));
        return apiResponse;
    }

    @DeleteMapping("/delete/{id}")
    String deleteHocVien(@PathVariable("id") int hocVienId){
        hocVienService.deleteHocVien(hocVienId);
        return "Delete Complete";
    }

    @GetMapping("/searchbynameandemail")
    ApiResponse<List<?>> searchByNameAndEmail(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize, @RequestParam("name") String tenHocVien, @RequestParam("email") String email){
        ApiResponse<List<?>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(hocVienService.searchByNameAndEmail(tenHocVien, email, pageNo, pageSize));
        return apiResponse;
    }

}
