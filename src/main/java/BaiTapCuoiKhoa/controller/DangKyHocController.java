package BaiTapCuoiKhoa.controller;

import BaiTapCuoiKhoa.dto.request.DangKyHoc_Request;
import BaiTapCuoiKhoa.dto.request.DangKyHoc_Update_Request;
import BaiTapCuoiKhoa.dto.response.ApiResponse;
import BaiTapCuoiKhoa.dto.response.DangKyHoc_Response;
import BaiTapCuoiKhoa.service.services.DangKyHocService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dangkyhoc")
public class DangKyHocController {
    @Autowired
    DangKyHocService dangKyHocService;

    @PostMapping("/add")
    ApiResponse<DangKyHoc_Response> addDangKyHoc(@RequestBody @Valid DangKyHoc_Request request){
        return ApiResponse.<DangKyHoc_Response>builder()
                .result(dangKyHocService.addDangKyHoc(request))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<DangKyHoc_Response> updateDangKyHoc(@RequestBody DangKyHoc_Update_Request request, @PathVariable("id") int dangKyHocId){
        return ApiResponse.<DangKyHoc_Response>builder()
                .result(dangKyHocService.updateDangKyHoc(dangKyHocId, request))
                .build();
    }

    @DeleteMapping("/delete/{id}")
    String deleteDangKyHoc(@PathVariable("id") int dangKyHocId){
        dangKyHocService.delteteDangKyHoc(dangKyHocId);
        return "Delete Complete";
    }

    @GetMapping("/getall/{pageNo}-{pageSize}")
    ApiResponse<List<?>> getAll(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize){
        return ApiResponse.<List<?>>builder()
                .result(dangKyHocService.getAll(pageNo, pageSize))
                .build();
    }
}
