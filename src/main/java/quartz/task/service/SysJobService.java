package quartz.task.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import org.quartz.SchedulerException;
import quartz.task.entity.SysJob;

/**
 * 系统任务
 *
 * @author hejq
 * @date 2019/7/12 16:55
 */
public interface SysJobService extends IService<SysJob> {

    /**
     * 分页查询系统任务信息
     *
     * @param pageInfo 分页信息
     * @return 查询结果
     */
    Page<SysJob> findByPage(Page pageInfo);

    /**
     * 通过任务id立即执行一次任务
     *
     * @param jobId 任务id
     * @throws SchedulerException 任务执行异常
     */
    void run(Long jobId) throws SchedulerException;
}
