package quartz.task.utils;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import quartz.task.constant.ScheduleConstants;
import quartz.task.entity.SysJob;
import quartz.task.excepiton.TaskException;

/**
 * 定时任务处理工具类
 *
 * @author hejq
 * @date 2019/7/15 9:01
 */
@Slf4j
public class SheduUtils {

    /**
     * 得到quartz任务类
     *
     * @param job 系统任务执行计划
     * @return 具体执行任务计划类
     */
    private static Class<? extends Job> getQuartzJobClass(SysJob job) {
        return QuartzDisallowConcurrentExecution.class;
    }

    /**
     * 获取触发器key
     */
    public static TriggerKey getTriggerKey(Long jobId) {
        return TriggerKey.triggerKey(ScheduleConstants.TASK_CLASS_NAME + jobId);
    }

    /**
     * 获取jobKey
     */
    public static JobKey getJobKey(Long jobId) {
        return JobKey.jobKey(ScheduleConstants.TASK_CLASS_NAME + jobId);
    }

    /**
     * 获取表达式触发器
     */
    public static CronTrigger getCronTrigger(Scheduler scheduler, Long jobId) {
        try {
            return (CronTrigger) scheduler.getTrigger(getTriggerKey(jobId));
        } catch (SchedulerException e) {
            log.error("getCronTrigger 异常：", e);
        }
        return null;
    }

    /**
     * 创建定时任务
     */
    public static void createScheduleJob(Scheduler scheduler, SysJob job) throws SchedulerException, TaskException
    {
        Class<? extends Job> jobClass = getQuartzJobClass(job);
        // 构建job信息
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(getJobKey(job.getJobId())).build();

        // 表达式调度构建器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());

        // 按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(job.getJobId()))
                .withSchedule(cronScheduleBuilder).build();

        // 放入参数，运行时的方法可以获取
        jobDetail.getJobDataMap().put(ScheduleConstants.TASK_PROPERTIES, job);

        scheduler.scheduleJob(jobDetail, trigger);

        // 暂停任务
        if (job.getStatus().equals(ScheduleConstants.Status.PAUSE.getValue())) {
            pauseJob(scheduler, job.getJobId());
        }
    }

    /**
     * 暂停任务
     *
     * @param scheduler 表达式构建器
     * @param jobId 任务id
     * @throws SchedulerException 暂停任务异常
     */
    private static void pauseJob(Scheduler scheduler, Long jobId) throws SchedulerException {
        scheduler.pauseJob(getJobKey(jobId));
    }
}


