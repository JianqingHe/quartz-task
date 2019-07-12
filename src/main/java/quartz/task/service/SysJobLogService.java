package quartz.task.service;

import com.baomidou.mybatisplus.service.IService;
import quartz.task.entity.SysJobLog;

/**
 * 系统任务日志信息
 *
 * @author hejq
 * @date 2019/7/12 15:42
 */
public interface SysJobLogService extends IService<SysJobLog> {

    /**
     * 新增任务日志
     *
     * @param sysJobLog 系统任务日志
     */
    void addJobLog(SysJobLog sysJobLog);
}
