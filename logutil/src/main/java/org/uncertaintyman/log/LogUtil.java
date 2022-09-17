package org.uncertaintyman.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class LogUtil {


    private void test() {
        Logger logger = LoggerFactory.getLogger(LogUtil.class);

    }

    public static void main(String[] args) {

        LogUtil.info("test:{}", "arg");
    }

    public static void info(String format, Object... arguments) {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        StackTraceElement[] stackTraceElements = allStackTraces.get(Thread.currentThread());
        String className = stackTraceElements[stackTraceElements.length - 1].getClassName();
        Logger logger = LoggerFactory.getLogger(className);
        logger.info(format, arguments);
    }

}

