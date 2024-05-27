package BaiTapCuoiKhoa.controller;

import BaiTapCuoiKhoa.dto.request.QuyenHan_Request;
import BaiTapCuoiKhoa.dto.response.ApiResponse;
import BaiTapCuoiKhoa.dto.response.QuyenHan_Response;
import BaiTapCuoiKhoa.service.services.QuyenHanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quyenhan")
public class QuyenHanController {
    @Autowired
    QuyenHanService quyenHanService;

    @PostMapping("/add")
    ApiResponse<QuyenHan_Response> addQuyenHan(@RequestBody @Valid QuyenHan_Request request){
        ApiResponse<QuyenHan_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(quyenHanService.addQuyenHan(request));
        return apiResponse;
    }
    @PutMapping("/update/{id}")
    ApiResponse<QuyenHan_Response> updateQuyenHan(@PathVariable("id") int quyenHanId, @RequestBody @Valid QuyenHan_Request request){
        ApiResponse<QuyenHan_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(quyenHanService.updateQuyenHan(quyenHanId, request));
        return apiResponse;
    }
    @DeleteMapping("/delete/{id}")
    String deleteQuyenHan(@PathVariable("id") int quyenHanId){
        quyenHanService.deleteQuyenHan(quyenHanId);
        return "Delete Complete";
    }
    @GetMapping("/getall/{pageNo}-{pageSize}")
    ApiResponse<List<?>> getAllQuyenHan(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize){
        ApiResponse<List<?>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(quyenHanService.getall(pageNo, pageSize));
        return apiResponse;
    }
}
