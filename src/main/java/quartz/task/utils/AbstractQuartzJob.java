package quartz.task.utils;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.BeanUtils;
import quartz.task.constant.Constants;
import quartz.task.constant.ScheduleConstants;
import quartz.task.entity.SysJob;
import quartz.task.entity.SysJobLog;
import quartz.task.service.SysJobLogService;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * quartz job 抽象类
 *
 * @author hejq
 * @date 2019/7/12 15:21
 */
@Slf4j
public abstract class AbstractQuartzJob implements Job {

    /**
     * 本地线程变量
     */
    private static ThreadLocal<LocalDateTime> threadLocal = new ThreadLocal<>();

    /**
     * fires that is associated with the Job
     *
     * @param context {@link JobExecutionContext#setResult(Object) result}
     * @throws JobExecutionException if there is an exception while executing the job.
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SysJob job = new SysJob();
        BeanUtils.copyProperties(job, context.getMergedJobDataMap().get(ScheduleConstants.TASK_PROPERTIES), SysJob.class);
        try {
            before();
            doExecute(context, job);
            after(context, job, null);
        } catch (Exception e) {
            log.error("任务执行异常  - ：", e);
            after(context, job, e);
        }
    }

    /**
     * 执行前
     *
     */
    private void before() {
        threadLocal.set(LocalDateTime.now());
    }

    /**
     * 执行方法，由子类重载
     *
     * @param context 工作执行上下文对象
     * @param job 系统计划任务
     * @throws Exception 执行过程中的异常
     */
    protected abstract void doExecute(JobExecutionContext context, SysJob job) throws Exception;

    /**
     * 执行后
     *
     * @param context 工作执行上下文对象
     * @param job 系统计划任务
     */
    private void after(JobExecutionContext context, SysJob job, Exception e) {
        LocalDateTime startTime = threadLocal.get();
        threadLocal.remove();

        final SysJobLog sysJobLog = new SysJobLog();
        sysJobLog.setJobName(job.getJobName());
        sysJobLog.setBeanName(job.getBeanName());
        sysJobLog.setMethodName(job.getMethodName());
        sysJobLog.setMethodParams(job.getMethodParams());
        sysJobLog.setStartTime(startTime);
        sysJobLog.setEndTime(LocalDateTime.now());
        long runMs = sysJobLog.getEndTime().toInstant(ZoneOffset.of("+8")).toEpochMilli() - sysJobLog.getStartTime().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        sysJobLog.setJobMessage(sysJobLog.getJobName() + " 总共耗时：" + runMs + "毫秒");
        if (e != null) {
            sysJobLog.setStatus(Constants.FAIL);
            String errorMsg = StringUtils.substring(e.getMessage(), 0, 2000);
            sysJobLog.setExceptionInfo(errorMsg);
        } else {
            sysJobLog.setStatus(Constants.SUCCESS);
        }

        // 写入数据库当中
        SpringUtils.getBean(SysJobLogService.class).addJobLog(sysJobLog);
    }

}
