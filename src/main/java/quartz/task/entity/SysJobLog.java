package quartz.task.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.google.gson.Gson;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 任务执行日志
 *
 * @author hejq
 * @date 2019/7/12 13:59
 */
@Data
@TableName("sys_job_log")
public class SysJobLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId
    private Long logId;

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
     * 日志信息
     */
    private String jobMessage;

    /**
     * 执行状态（0正常 1失败）
     */
    private String status;

    /**
     * 异常信息
     */
    private String exceptionInfo;

    /**
     * 开始时间
     */
    @TableField(exist = false)
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @TableField(exist = false)
    private LocalDateTime endTime;

    /**
     * 日志创建时间
     */
    private LocalDateTime createTime;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
