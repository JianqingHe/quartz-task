package quartz.task.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import quartz.task.entity.SysJobLog;
import quartz.task.mapper.SysJobLogMapper;
import quartz.task.service.SysJobLogService;

/**
 * 系统任务日志业务处理
 *
 * @author hejq
 * @date 2019/7/12 15:45
 */
@Service("SysJobLogService")
public class SysJobLogServiceImpl extends ServiceImpl<SysJobLogMapper, SysJobLog> implements SysJobLogService {

    /**
     * 新增任务日志
     *
     * @param sysJobLog 系统任务日志
     */
    @Override
    public void addJobLog(SysJobLog sysJobLog) {
        this.insert(sysJobLog);
    }
}
