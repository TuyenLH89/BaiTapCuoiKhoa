package BaiTapCuoiKhoa.controller;

import BaiTapCuoiKhoa.dto.request.BaiViet_Request;
import BaiTapCuoiKhoa.dto.request.BaiViet_Update_Request;
import BaiTapCuoiKhoa.dto.response.ApiResponse;
import BaiTapCuoiKhoa.dto.response.BaiViet_Response;
import BaiTapCuoiKhoa.service.services.BaiVietService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baiviet")
public class BaiVietController {
    @Autowired
    BaiVietService baiVietService;

    @PostMapping("/add")
    ApiResponse<BaiViet_Response> addBaiViet(@RequestBody @Valid BaiViet_Request request){
        return ApiResponse.<BaiViet_Response>builder()
                .result(baiVietService.addBaiViet(request))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<BaiViet_Response> updateBaiViet(@PathVariable("id") int baiVietId, @RequestBody @Valid BaiViet_Update_Request request){
        return ApiResponse.<BaiViet_Response>builder()
                .result(baiVietService.updateBaiViet(baiVietId, request))
                .build();
    }

    @DeleteMapping("/delete/{id}")
    String deleteBaiViet(@PathVariable("id") int baiVietId){
        baiVietService.deleteBaiViet(baiVietId);
        return "Delete Complete";
    }

    @GetMapping("/getall/{pageNo}-{pageSize}")
    ApiResponse<List<?>> getAll(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize){
        return ApiResponse.<List<?>>builder()
                .result(baiVietService.getAll(pageNo, pageSize))
                .build();
    }

    @GetMapping("/searchbyname/{pageNo}-{pageSize}")
    ApiResponse<List<?>> getAll(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, @RequestParam("tenBaiViet") String tenBaiViet){
        return ApiResponse.<List<?>>builder()
                .result(baiVietService.searchByName(tenBaiViet, pageNo, pageSize))
                .build();
    }
}
