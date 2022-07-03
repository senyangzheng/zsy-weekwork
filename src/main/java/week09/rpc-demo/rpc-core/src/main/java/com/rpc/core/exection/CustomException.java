package com.rpc.core.exection;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.core.exection
 * @className: CustomException
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 17:12
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {
    private String message;

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
        this.message = message;
    }
}
