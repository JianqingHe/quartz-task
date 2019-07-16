package quartz.task.enums;

/**
 * 任务异常枚举
 *
 * @author hejq
 * @date 2019/7/15 9:15
 */
public enum TaskCode {
    /**
     * 任务已存在
     */
    TASK_EXISTS,

    /**
     * 任务不存在
     */
    NO_TASK_EXISTS,

    /**
     * 任务已启动
     */
    TASK_ALREADY_STARTED,

    /**
     * 位置异常
     */
    UNKNOWN,

    /**
     * 配置错误
     */
    CONFIG_ERROR,

    /**
     * 任务节点不可用
     */
    TASK_NODE_NOT_AVAILABLE
}
