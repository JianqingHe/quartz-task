package quartz.task;

/**
 * @author hejq
 * @date 2019/7/9 15:52
 */
public class TicketWindowTest {

    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow("1号柜台");
        ticketWindow1.start();

        TicketWindow ticketWindow2 = new TicketWindow("2号柜台");
        ticketWindow2.start();

        TicketWindow ticketWindow3 = new TicketWindow("3号柜台");
        ticketWindow3.start();

        TicketWindow ticketWindow4 = new TicketWindow("4号柜台");
        ticketWindow4.start();
    }
}
