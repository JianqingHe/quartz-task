package quartz.task.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
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
}
