package quartz.task.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import quartz.task.entity.SysJob;
import quartz.task.mapper.SysJobMapper;
import quartz.task.service.SysJobService;

/**
 * 系统任务业务实现
 *
 * @author hejq
 * @date 2019/7/12 16:55
 */
@Service("SysLogService")
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements SysJobService {

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
}
