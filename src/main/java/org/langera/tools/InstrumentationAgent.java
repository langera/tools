package org.langera.tools;

import java.lang.instrument.Instrumentation;

public class InstrumentationAgent {

    private static volatile Instrumentation globalInstrumentation;

    public static void premain(String args, Instrumentation inst) {
        globalInstrumentation = inst;
    }

    public static long sizeOf(Object obj) {
        if (globalInstrumentation == null) {
            throw new IllegalStateException("Agent not initialized");
        }
        return globalInstrumentation.getObjectSize(obj);
    }
}
