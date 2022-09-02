package org.uncertaintyman.logtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Log4jTests {


    static ExecutorService executorService = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue(1));
    static ExecutorService executorServiceB = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue(1));

    static Logger logger = LoggerFactory.getLogger(Log4jTests.class);

    public static void main(String[] args) throws InterruptedException {
        MDC.put("traceId", UUID.randomUUID().toString().replace("-", ""));
        MDC.put("userId", "12345678910");
        MDC.put("roomId", "100001");
        MDC.put("sessionId", UUID.randomUUID().toString().replace("-", ""));

        logger.info("test......");

        IntStream.range(1, 4).forEach(i -> executorService.execute(() ->
                        {
                            logger.info("another-thread");
                            executorServiceB.execute(() -> logger.info("inner-thread"));
                        }
                )
        );


        TimeUnit.SECONDS.sleep(2);
        executorService.shutdown();
        executorServiceB.shutdown();

    }
}
