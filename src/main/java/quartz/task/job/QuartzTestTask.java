package quartz.task.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * quartz任务测试
 *
 * @author hejq
 * @date 2019/7/15 16:19
 */
@Component("QuartzTestTask")
@Slf4j
public class QuartzTestTask {

    /**
     * 有参数测试
     *
     * @param params 传入参数
     */
    public void testWithParams(String params) {
        log.info("[quartz task] 有参测试 -> 参数 {} time {}", params, LocalDateTime.now());
    }

    /**
     * 无参测试
     */
    public void testWithNoParams() {
        log.info("[quartz task] 无参测试 time {}", LocalDateTime.now());
    }
}
