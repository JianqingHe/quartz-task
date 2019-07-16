package quartz.task.excepiton;

import com.google.gson.Gson;
import lombok.Data;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * 自定义请求异常
 *
 * @author hejq
 * @date 2019/7/16 9:30
 */
public class MyErrorHandler implements ResponseErrorHandler {

    private ResponseErrorHandler errorHandler = new DefaultResponseErrorHandler();

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        //对body 的处理 (inputStream)
        Response res = convertStreamToString(response.getBody());
        try {
            errorHandler.handleError(response);
        } catch (RestClientException scx) {
            throw new TaskException(res.toString(), scx);
        }
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return errorHandler.hasError(response);
    }

    /**
     * inputStream 装换为 string
     *
     * @param is
     * @return
     */
    private Response convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String result = sb.toString();
        return new Gson().fromJson(result, Response.class);
    }

    /**
     * Auto-generated: 2019-04-23 9:8:15
     *
     * @author bejson.com (i@bejson.com)
     * @website http://www.bejson.com/java2pojo/
     */
    @Data
    public class Response {

        /**
         * 时间
         */
        private Date timestamp;

        /**
         * 态
         */
        private Integer status;

        /**
         * 异常
         */
        private String error;

        /**
         * 信息
         */
        private String message;

        /**
         * 路径
         */
        private String path;

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }


    }
}