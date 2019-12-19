package run.halo.app.controller;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2019/12/19 17:54
 */
@Component
@Slf4j
public class TestTask {


    @Scheduled(cron = "*/5 * * * * ?")
    public void test() throws IOException {
        log.info("开始请求！");
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://localhost:9090/api/test")
                .get()
                .build();
        Response response = httpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            ResponseBody body = response.body();
            log.info(body != null ? body.toString() : null);
        }
    }
}
