package BaiTapCuoiKhoa.controller;

import BaiTapCuoiKhoa.dto.request.LoaiBaiViet_Request;
import BaiTapCuoiKhoa.dto.response.ApiResponse;
import BaiTapCuoiKhoa.dto.response.LoaiBaiViet_Response;
import BaiTapCuoiKhoa.service.services.LoaiBaiVietService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loaibaiviet")
public class LoaiBaiVietController {
    @Autowired
    LoaiBaiVietService loaiBaiVietService;

    @PostMapping("/add")
    ApiResponse<LoaiBaiViet_Response> addLoaiBaiViet(@RequestBody @Valid LoaiBaiViet_Request request){
        ApiResponse<LoaiBaiViet_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(loaiBaiVietService.addLoaiBaiViet(request));
        return apiResponse;
    }

    @PutMapping("/update/{id}")
    ApiResponse<LoaiBaiViet_Response> updateLoaiBaiViet(@PathVariable("id") int loaiBaiVietId, @RequestBody @Valid LoaiBaiViet_Request request){
        ApiResponse<LoaiBaiViet_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(loaiBaiVietService.updateLoaiBaiViet(loaiBaiVietId, request));
        return apiResponse;
    }

    @DeleteMapping("/delete/{id}")
    String deleteLoaiBaiViet(@PathVariable("id") int loaiBaiVietId){
        loaiBaiVietService.deleteLoaiBaiViet(loaiBaiVietId);
        return "Delete Complete";
    }

    @GetMapping("/getall/{pageNo}-{pageSize}")
    ApiResponse<List<?>> getAll(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize){
        ApiResponse<List<?>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(loaiBaiVietService.getAll(pageNo, pageSize));
        return apiResponse;
    }
}
