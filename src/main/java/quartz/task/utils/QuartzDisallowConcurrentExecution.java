package quartz.task.utils;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import quartz.task.entity.SysJob;

/**
 *  定时任务处理（禁止并发执行）
 *
 * @author hejq
 * @date 2019/7/15 9:00
 */
@DisallowConcurrentExecution
public class QuartzDisallowConcurrentExecution extends AbstractQuartzJob {
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
