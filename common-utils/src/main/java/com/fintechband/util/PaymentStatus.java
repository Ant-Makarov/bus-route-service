package com.fintechband.util;

import java.util.Random;

public enum PaymentStatus {
    NEW,
    FAILED,
    DONE;

    public static PaymentStatus getRandomStatus() {
        return PaymentStatus.values()[new Random().nextInt(3)];
    }
}
