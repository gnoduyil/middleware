package org.gonduyil.start;

import java.lang.instrument.Instrumentation;

public class AgentMain {

    public static void premain(String agentOps, Instrumentation inst) {

        System.out.println("premain执行--------------------");
        //instrument(agentOps, inst);
        inst.addTransformer(new AuthTransformer());
    }

//    public static void agentmain(String agentOps, Instrumentation inst) {
//        instrument(agentOps, inst);
//    }

    /**
     * agentOps is aop target classname
     */
    private static void instrument(String agentOps, Instrumentation inst) {
        System.out.println(agentOps);
       // inst.addTransformer(new AOPTransformer(agentOps));
    }
}
