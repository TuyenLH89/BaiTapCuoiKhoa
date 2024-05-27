package BaiTapCuoiKhoa.exception;

import BaiTapCuoiKhoa.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException e){
        ErrorCode errorCode = ErrorCode.ERROR_KEY_NOT_EXIST;
        try {
            errorCode = e.getErrorCode();
        }catch (Exception ignored){

        }
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
    @ExceptionHandler(value = IllegalArgumentException.class)
    ResponseEntity<ApiResponse> handlingIllegalArgumentException(IllegalArgumentException e){
        String enumKey = e.getMessage();
        ErrorCode errorCode = ErrorCode.ERROR_KEY_NOT_EXIST;
        if (enumKey.contains("fromIndex") && enumKey.contains("toIndex")){
            errorCode = ErrorCode.PAGESIZE_INVALID;
        }else if (enumKey.contains("Page size must not be less than one")){
            errorCode = ErrorCode.PAGESIZE_INVALID1;
        }else if (enumKey.contains("Page index must not be less than zero")){
            errorCode = ErrorCode.PAGENO_INVALID;
        }
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingMethodArgumentNotValidException(MethodArgumentNotValidException e){
        String enumKey = e.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.ERROR_KEY_NOT_EXIST;
        try {
            errorCode = ErrorCode.valueOf(enumKey);
        }catch (Exception ignored){
        }
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
