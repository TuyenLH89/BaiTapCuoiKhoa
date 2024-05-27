package BaiTapCuoiKhoa.controller;

import BaiTapCuoiKhoa.dto.request.LoaiKhoaHoc_Request;
import BaiTapCuoiKhoa.dto.response.ApiResponse;
import BaiTapCuoiKhoa.dto.response.LoaiKhoaHoc_Response;
import BaiTapCuoiKhoa.service.services.LoaiKhoaHocService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loaikhoahoc")
public class LoaiKhoaHocController {
    @Autowired
    LoaiKhoaHocService loaiKhoaHocService;
    //add
    @PostMapping("/addloaikhoahoc")
    ApiResponse<LoaiKhoaHoc_Response> addKhoaHoc(@RequestBody @Valid LoaiKhoaHoc_Request request){
        ApiResponse<LoaiKhoaHoc_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(loaiKhoaHocService.addLoaiKhoaHoc(request));
        return apiResponse;
    }
    //update
    @PutMapping("/updateloaikhoahoc/{id}")
    ApiResponse<LoaiKhoaHoc_Response> updateLoaiKhoaHoc(@PathVariable("id") int loaiKhoaHocId, @RequestBody @Valid LoaiKhoaHoc_Request request){
        ApiResponse<LoaiKhoaHoc_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(loaiKhoaHocService.updateLoaiKhoaHoc(loaiKhoaHocId, request));
        return apiResponse;
    }
    //delete
    @DeleteMapping("/deleteloaikhoahoc/{id}")
    String deleteLoaiKhoaHoc(@PathVariable("id") int loaiKhoaHocId){
        loaiKhoaHocService.deleteLoaiKhoaHoc(loaiKhoaHocId);
        return "Delete Complete";
    }
    //get
    @GetMapping("/getall/{pageNo}-{pageSize}")
    ApiResponse<List<?>> getAllLoaiKhoaHoc(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize){
        ApiResponse<List<?>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(loaiKhoaHocService.getAllLoaiKhoaHoc(pageNo, pageSize));
        return apiResponse;
    }
}
