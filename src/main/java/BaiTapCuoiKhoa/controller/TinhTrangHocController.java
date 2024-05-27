package BaiTapCuoiKhoa.controller;

import BaiTapCuoiKhoa.dto.request.TinhTrangHoc_Request;
import BaiTapCuoiKhoa.dto.response.ApiResponse;
import BaiTapCuoiKhoa.dto.response.TinhTrangHoc_Response;
import BaiTapCuoiKhoa.service.services.TinhTrangHocService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tinhtranghoc")
public class TinhTrangHocController {
    @Autowired
    TinhTrangHocService tinhTrangHocService;
    @PostMapping("/add")
    ApiResponse<TinhTrangHoc_Response> addTinhTrangHoc(@RequestBody @Valid TinhTrangHoc_Request request){
        ApiResponse<TinhTrangHoc_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(tinhTrangHocService.addTinhTrangHoc(request));
        return apiResponse;
    }

    @PutMapping("/update/{id}")
    ApiResponse<TinhTrangHoc_Response> updateTinhTrangHoc(@PathVariable("id") int tinhTrangHocId, @RequestBody @Valid TinhTrangHoc_Request request){
        ApiResponse<TinhTrangHoc_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(tinhTrangHocService.updateTinhTrangHoc(tinhTrangHocId, request));
        return apiResponse;
    }

    @DeleteMapping("/delete/{id}")
    String deleteTinhTrangHoc(@PathVariable("id") int tinhTrangHoc){
        tinhTrangHocService.deleteTinhTrangHoc(tinhTrangHoc);
        return "Delete Complete";
    }
    @GetMapping("/getall")
    ApiResponse<List<TinhTrangHoc_Response>> getAll(){
        ApiResponse<List<TinhTrangHoc_Response>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(tinhTrangHocService.getAll());
        return apiResponse;
    }
}
