package ru.intensive.dz4.Emulator;

import java.util.ArrayList;
import java.util.List;

public class LimitedFrequencyMethodDecorator implements Method {
    private Method method;
    private int maxCallsPerMinute;
    private List<Long> calls;

    public LimitedFrequencyMethodDecorator(Method method, int maxCallsPerMinute) {
        this.method = method;
        this.maxCallsPerMinute = maxCallsPerMinute;
        this.calls = new ArrayList<>();
    }

    @Override
    public void call() {
        long now = System.currentTimeMillis();
        calls.add(now);
        calls.removeIf(call -> call < now - 60000);
        if (calls.size() > maxCallsPerMinute) {
            System.out.println("Method can't be called more than " + maxCallsPerMinute + " times per minute");
            return;
        }
        method.call();
    }
}
