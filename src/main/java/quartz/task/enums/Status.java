package quartz.task.enums;

/**
 * 任务状态
 *
 * @author hejq
 * @date 2019/7/16 9:39
 */
public enum  Status {

    /**
     * 正常
     */
    NORMAL("0"),
    /**
     * 暂停
     */
    PAUSE("1");

    private String value;

    private Status(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
