package quartz.task.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import quartz.task.entity.SysJob;
import quartz.task.excepiton.TaskException;
import quartz.task.mapper.SysJobMapper;
import quartz.task.service.SysJobService;
import quartz.task.utils.ScheduleUtils;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 系统任务业务实现
 *
 * @author hejq
 * @date 2019/7/12 16:55
 */
@Service("SysJobService")
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements SysJobService {

    @Qualifier("schedulerFactoryBean")
    @Autowired
    private Scheduler scheduler;

    /**
     * 项目启动时，初始化定时器
     */
    @PostConstruct
    public void init() throws SchedulerException, TaskException {
        List<SysJob> jobList = this.selectList(null);
        for (SysJob job : jobList) {
            CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, job.getJobId());
            // 如果不存在，则创建
            if (cronTrigger == null) {
                ScheduleUtils.createScheduleJob(scheduler, job);
            } else {
                ScheduleUtils.updateScheduleJob(scheduler, job);
            }
        }
    }

    /**
     * 分页查询系统任务信息
     *
     * @param pageInfo 分页信息
     * @return 查询结果
     */
    @Override
    public Page<SysJob> findByPage(Page pageInfo) {
        return this.selectPage(pageInfo);
    }

    /**
     * 通过任务id立即执行一次任务
     *
     * @param jobId 任务id
     * @throws SchedulerException 任务执行异常
     */
    @Override
    public void run(Long jobId) throws SchedulerException {
        SysJob job = this.selectById(jobId);
        ScheduleUtils.run(scheduler, job);
    }
}
