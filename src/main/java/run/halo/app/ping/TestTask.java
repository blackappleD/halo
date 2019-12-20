package run.halo.app.ping;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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

    @Resource
    private OkHttpClient okHttpClient;

    @Scheduled(cron = "0 0/15 * * * ? ")
    public void test() throws IOException {
        log.info("开始请求！");
        Request request = new Request.Builder()
                .url("https://halo-tp.herokuapp.com/api/test")
                .get()
                .build();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            ResponseBody body = response.body();
            log.info(body != null ? body.toString() : null);
        }
    }
}
