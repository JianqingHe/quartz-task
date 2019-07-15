package quartz.task.excepiton;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.client.RestClientException;
import quartz.task.enums.TaskCode;

import java.io.Serializable;

/**
 * 任务执行异常
 *
 * @author hejq
 * @date 2019/7/15 9:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TaskException extends RestClientException implements Serializable {

    private static final long serialVersionUID = 1L;

    private TaskCode code;

    private RestClientException restClientException;


    public TaskException(String msg, TaskCode code) {
        this(msg, code, null);
    }


    public TaskException(String msg, RestClientException restClientException) {
        super(msg);
        this.restClientException = restClientException;
    }

    public TaskException(String msg, TaskCode code, Exception nestedEx) {
        super(msg, nestedEx);
        this.code = code;
    }


}