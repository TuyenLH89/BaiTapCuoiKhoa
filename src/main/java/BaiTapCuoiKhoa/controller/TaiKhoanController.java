package BaiTapCuoiKhoa.controller;

import BaiTapCuoiKhoa.dto.request.TaiKhoan_Request;
import BaiTapCuoiKhoa.dto.request.TaiKhoan_Update_Request;
import BaiTapCuoiKhoa.dto.response.ApiResponse;
import BaiTapCuoiKhoa.dto.response.TaiKhoan_Response;
import BaiTapCuoiKhoa.service.services.TaiKhoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taikhoan")
public class TaiKhoanController {
    @Autowired
    TaiKhoanService taiKhoanService;

    @PostMapping("/add")
    ApiResponse<TaiKhoan_Response> addTaiKhoan(@RequestBody @Valid TaiKhoan_Request request){
        ApiResponse<TaiKhoan_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(taiKhoanService.addTaiKoan(request));
        return apiResponse;
    }
    @PutMapping("/update/{id}")
    ApiResponse<TaiKhoan_Response> updateTaiKhoan(@PathVariable("id") int taiKhoanId, @RequestBody @Valid TaiKhoan_Update_Request request){
        ApiResponse<TaiKhoan_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(taiKhoanService.updateTaiKhoan(taiKhoanId, request));
        return apiResponse;
    }
    @DeleteMapping("/delete/{id}")
    String deleteTaiKhoan(@PathVariable("id") int taiKhoanId){
        taiKhoanService.deleteTaiKhoan(taiKhoanId);
        return "Delete Compelete";
    }
    @GetMapping("/getall/{pageNo}-{pageSize}")
    ApiResponse<List<?>> getAll(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize){
        ApiResponse<List<?>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(taiKhoanService.getAll(pageNo, pageSize));
        return apiResponse;
    }
    @GetMapping("/searchbyname/{pageNo}-{pageSize}")
    ApiResponse<List<?>> searchByName(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, @RequestParam("taiKhoan") String taiKhoan){
        ApiResponse<List<?>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(taiKhoanService.searchByName(taiKhoan, pageNo, pageSize));
        return apiResponse;
    }
}
