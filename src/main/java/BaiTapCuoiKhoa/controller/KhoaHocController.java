package BaiTapCuoiKhoa.controller;

import BaiTapCuoiKhoa.dto.request.KhoaHoc_Request;
import BaiTapCuoiKhoa.dto.response.ApiResponse;
import BaiTapCuoiKhoa.dto.response.KhoaHoc_Response;
import BaiTapCuoiKhoa.service.services.KhoaHocService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/khoahoc")
public class KhoaHocController {
    @Autowired
    KhoaHocService khoaHocService;
    //add
    @PostMapping("/addkhoahoc")
    ApiResponse<KhoaHoc_Response> addKhoaHoc(@RequestBody @Valid KhoaHoc_Request request){
        ApiResponse<KhoaHoc_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(khoaHocService.addKhoaHoc(request));
        return apiResponse;
    }

    //update
    @PutMapping("/update/{id}")
    ApiResponse<KhoaHoc_Response> updateKhoaHoc(@PathVariable("id") int khoaHocId, @RequestBody @Valid KhoaHoc_Request request){
        ApiResponse<KhoaHoc_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(khoaHocService.updateKhoaHoc(khoaHocId, request));
        return apiResponse;
    }

    //delete
    @DeleteMapping("/delete/{id}")
    String deleteKhoaHoc(@PathVariable("id") int khoaHocId){
        khoaHocService.deleteKhoaHoc(khoaHocId);
        return "Delete Comple";
    }

    //get all
    @GetMapping("/getall/{pageNo}-{pageSize}")
    ApiResponse<List<?>> getAll(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize){
        ApiResponse<List<?>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(khoaHocService.getAllKhoaHoc(pageNo, pageSize));
        return apiResponse;
    }

    //search by tên khóa học
    @GetMapping("/searchbyname/{pageNo}-{pageSize}")
    ApiResponse<List<?>> searchByName(@RequestParam("name") String tenKhoaHoc,@PathVariable("pageNo")  int pageNo,@PathVariable("pageSize") int pageSize){
        ApiResponse<List<?>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(khoaHocService.searchByTenKhoaHoc(tenKhoaHoc, pageNo, pageSize));
        return apiResponse;
    }



}
