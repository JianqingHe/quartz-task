package quartz.task;

/**
 * 模拟售票窗口
 *
 * @author hejq
 * @date 2019/7/9 15:49
 */
public class TicketWindow extends Thread {

    private static final int MAX = 50;

    private static int index = 1;

    private String name;

    public TicketWindow(String name) {
        this.name = name;
    }

    public void run() {
        while (index <= MAX) {
            System.out.println("柜台：" + name + " 当前号码是： " + (index++));
        }
    }
}
