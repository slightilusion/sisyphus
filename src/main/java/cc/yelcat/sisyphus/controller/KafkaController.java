package cc.yelcat.sisyphus.controller;

import cc.yelcat.sisyphus.annotation.ControllerWebLog;
import cc.yelcat.sisyphus.annotation.DistributeLock;
import cc.yelcat.sisyphus.common.BaseRequest;
import cc.yelcat.sisyphus.common.BaseResponse;
import cc.yelcat.sisyphus.service.Data2Typecho;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {
    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    @Autowired
    private Data2Typecho data2Typecho;
    // 发送消息
    @GetMapping("/test/{message}")
    public void sendMessage1(@PathVariable("message") String normalMessage) {

        kafkaTemplate.send("topic1", normalMessage)
                .addCallback(
                        result -> logger.info("⽣产者成功发送消息到topic:{} partition:{}的消息", result.getRecordMetadata().topic(), result.getRecordMetadata().partition()),
                        ex -> logger.error("⽣产者发送消失败，原因：{}", ex.getMessage())
                );

        //  data2Typecho.data2Mysql("C:\\Users\\oo\\Downloads");
    }


    @PostMapping("/post-test")
    @ControllerWebLog(name = "接口日志 POST 请求测试", intoDb = true)
    @DistributeLock(key = "post_test_#{baseRequest.channel}", timeout = 10)
    public BaseResponse postTest(@RequestBody BaseRequest baseRequest) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return BaseResponse.addResult();
    }

}
