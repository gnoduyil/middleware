package org.uncertaintyman.logtest.controller;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uncertaintyman.logtest.util.CommonLog;
import org.uncertaintyman.logtest.util.MdcTestUtil;

import javax.annotation.PostConstruct;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RestController
public class TestDemo {

    ThreadLocal<CommonLog> threadLocal = new TransmittableThreadLocal<>();

    Logger logger = LoggerFactory.getLogger(TestDemo.class);

    static ExecutorService executorService = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue(1));

    @PostConstruct
    public void init() {
        logger.info("executorServiceInit");
        IntStream.rangeClosed(1, 10).forEach(i ->
                executorService.execute(() -> logger.info("thread init"))
        );
    }


    @GetMapping("test")
    public Object test() {
        logger.info("test method invoke begin");
        MdcTestUtil.putToMdc();
        CommonLog log = CommonLog.CommonLogBuilder.aCommonLog()
                .withSessionId(UUID.randomUUID().toString().replace("-", ""))
                .withTraceId(UUID.randomUUID().toString().replace("-", ""))
                .withUserId("a123456")
                .build();
        threadLocal.set(log);

//        executorService.execute(TtlRunnable.get(() -> logger.info("remote invoke mock")));
        executorService.execute(() -> logger.info("remote invoke mock, commonLog:{}", log));


        return "success";
    }
}
