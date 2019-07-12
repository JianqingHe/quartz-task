package quartz.task.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.google.gson.Gson;
import lombok.Data;

import java.io.Serializable;

/**
 * 定制任务表
 *
 * @author hejq
 * @date 2019/7/12 13:50
 */
@TableName("sys_job")
@Data
public class SysJob implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId
    private Long jobId;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务beanName
     */
    private String beanName;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 参数
     */
    private String methodParams;

    /**
     * corn表达式
     */
    private String cornExpression;

    /**
     * 任务状态（0正常 1暂停）
     */
    private String status;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
