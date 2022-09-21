package org.gonduyil.start;

import java.lang.instrument.Instrumentation;

public class AgentMain {

    public static void premain(String agentOps, Instrumentation inst) {

        try {
            System.out.println("premain执行--------------------");
            inst.addTransformer(new AuthTransformer());
        } catch (Exception e) {

        }
    }

}
