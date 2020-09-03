package cn.yuehai.common.exception;

import cn.yuehai.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class YhException extends RuntimeException{
    private ExceptionEnum exceptionEnum;
}
