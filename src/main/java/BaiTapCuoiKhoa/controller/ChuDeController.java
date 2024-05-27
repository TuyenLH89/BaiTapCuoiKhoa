package BaiTapCuoiKhoa.controller;

import BaiTapCuoiKhoa.dto.request.ChuDe_Request;
import BaiTapCuoiKhoa.dto.request.ChuDe_Update_Request;
import BaiTapCuoiKhoa.dto.response.ApiResponse;
import BaiTapCuoiKhoa.dto.response.ChuDe_Response;
import BaiTapCuoiKhoa.service.services.ChuDeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chude")
public class ChuDeController {
    @Autowired
    ChuDeService chuDeService;

    @PostMapping("/add")
    ApiResponse<ChuDe_Response> addChuDe(@RequestBody @Valid ChuDe_Request request){
        return ApiResponse.<ChuDe_Response>builder()
                .result(chuDeService.addChuDe(request))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<ChuDe_Response> updateChuDe(@PathVariable("id") int chuDeId, @RequestBody @Valid ChuDe_Update_Request request){
        return ApiResponse.<ChuDe_Response>builder()
                .result(chuDeService.updateChuDe(chuDeId, request))
                .build();
    }

    @DeleteMapping("/delete/{id}")
    String deleteChuDe(@PathVariable("id") int chuDeId){
        chuDeService.deleteChuDe(chuDeId);
        return "Delete Complete";
    }

    @GetMapping("/getall/{pageNo}-{pageSize}")
    ApiResponse<List<?>> getAll(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize){
        ApiResponse<List<?>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(chuDeService.getAll(pageNo, pageSize));
        return apiResponse;
    }
}
