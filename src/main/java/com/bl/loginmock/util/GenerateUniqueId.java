package com.bl.loginmock.util;

import java.util.concurrent.atomic.AtomicLong;

public class GenerateUniqueId {

    public static int getUniqueId() {
        AtomicLong counter = new AtomicLong();
        return (int) counter.incrementAndGet();
    }
}
