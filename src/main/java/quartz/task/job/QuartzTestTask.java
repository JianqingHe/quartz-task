package quartz.task.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
        log.debug("[quartz task] 有参测试 -> 参数 {}", params);
    }

    /**
     * 无参测试
     */
    public void testWithNoParams() {
        log.debug("[quartz task] 无参测试");
    }
}
