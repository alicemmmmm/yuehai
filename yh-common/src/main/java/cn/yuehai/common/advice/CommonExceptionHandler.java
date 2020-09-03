package cn.yuehai.common.advice;

import cn.yuehai.common.enums.ExceptionEnum;
import cn.yuehai.common.exception.YhException;
import cn.yuehai.common.vo.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
//默认拦截
public class CommonExceptionHandler {

    @ExceptionHandler(YhException.class)
    public ResponseEntity<ExceptionResult> handleException(YhException e){
        ExceptionEnum exceptionEnum = e.getExceptionEnum();
        return ResponseEntity.status(exceptionEnum.getCode())
                .body(new ExceptionResult(exceptionEnum));
    }
    /*@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }*/
}
