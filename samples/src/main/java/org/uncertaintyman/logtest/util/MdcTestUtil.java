package org.uncertaintyman.logtest.util;

import org.slf4j.MDC;

import java.util.UUID;

public class MdcTestUtil {

    public static void putToMdc() {
        MDC.put("traceId", UUID.randomUUID().toString().replace("-", ""));
        MDC.put("userId", "12345678910");
        MDC.put("roomId", "100001");
        MDC.put("sessionId", UUID.randomUUID().toString().replace("-", ""));
    }
}
