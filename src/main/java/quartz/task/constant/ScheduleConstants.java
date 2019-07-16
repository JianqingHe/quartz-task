package quartz.task.constant;

/**
 * 任务调度通用常量
 *
 * @author hejq
 * @date 2019/7/12 15:29
 */
public class ScheduleConstants {

    /**
     * Task Class name
     */
    public static String TASK_CLASS_NAME = "TASK_CLASS_NAME";

    /**
     * 执行目标key
     */
    public static String TASK_PROPERTIES = "TASK_PROPERTIES";

    /**
     * 默认
     */
    public static String MISFIRE_DEFAULT = "0";

    /**
     * 立即触发执行
     */
    public static String MISFIRE_IGNORE_MISFIRES = "1";

    /**
     * 触发一次执行
     */
    public static String MISFIRE_FIRE_AND_PROCEED = "2";

    /**
     * 不触发立即执行
     */
    public static String MISFIRE_DO_NOTHING = "3";

}
