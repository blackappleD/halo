package run.halo.app.ping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2019/12/19 17:52
 */
@RestController
@RequestMapping(value = "/api/test")
@Slf4j
public class TestController {

    @GetMapping(value = "")
    public void test() {
        log.info("{}", System.currentTimeMillis());
    }
}
