package org.gonduyil.start.samples;

import java.util.HashMap;
import java.util.Map;

public class RealMain {

    public static void main(String[] args) {
        System.out.println("realMain执行.................");


        Map<String, String> params = new HashMap<>();
        params.put("userId", "test");
        // 只有agent可以解析的参数.
        params.put("pass", "true");

        System.out.println(String.format("result: %s", Auth.auth(params)));
    }
}
