package quartz.task.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import quartz.task.entity.SysJob;

/**
 * @author hejq
 * @date 2019/7/12 16:53
 */
@Mapper
public interface SysJobMapper extends BaseMapper<SysJob> {
}
