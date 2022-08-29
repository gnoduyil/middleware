package org.uncertaintyman.logtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Log4jTests {


    static ExecutorService executorService = new ThreadPoolExecutor(
            10,
            10,
            1000,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue(1)
    );

    static Logger logger = LoggerFactory.getLogger(Log4jTests.class);

    public static void main(String[] args) {


        logger.info("test......");



    }
}
