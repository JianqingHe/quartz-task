package quartz.task.excepiton;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import quartz.task.result.ResultMap;

/**
 * 运行异常统一捕获
 *
 * @author hejq
 * @date 2019/7/15 17:35
 */
@RestControllerAdvice
@Slf4j
public class RuntimeExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(TaskException.class)
    public ResultMap handleTaskException(TaskException e) {
        return ResultMap.error(e);
    }

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(Exception.class)
    public ResultMap handleException() {
        return ResultMap.error();
    }
}
