package quartz.task.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import quartz.task.entity.SysJobLog;

/**
 * 系统任务日志
 *
 * @author hejq
 * @date 2019/7/12 15:46
 */
@Mapper
public interface SysJobLogMapper extends BaseMapper<SysJobLog> {
}
