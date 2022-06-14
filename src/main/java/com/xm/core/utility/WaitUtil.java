package com.xm.core.utility;

import com.xm.core.properties.PropertyController;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.awaitility.Duration;
import org.awaitility.core.ConditionFactory;

import java.net.ConnectException;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WaitUtil {
    public static final Duration TIMEOUT = new Duration(Long.parseLong(PropertyController.appTimeoutConfig().waitTimeout()), TimeUnit.SECONDS);
    public static final Duration TIMEOUT_MEDIUM = new Duration(Long.parseLong(PropertyController.appTimeoutConfig().waitMediumTimeout()), TimeUnit.SECONDS);
    private static final Duration INTERVAL = Duration.ONE_SECOND;

    public static ConditionFactory doWait() {
        return doWait(INTERVAL, TIMEOUT);
    }

    public static ConditionFactory doWaitMedium() {
        return doWait(INTERVAL.multiply(3L), TIMEOUT_MEDIUM);
    }

    private static ConditionFactory doWait(Duration pollInterval, Duration timeout) {
        return await().ignoreException(ConnectException.class).with().pollInSameThread()
                .await()
                .atMost(timeout)
                .with()
                .pollInterval(pollInterval)
                .pollDelay(1L, TimeUnit.MILLISECONDS);    // skip waiting at 1st iteration
    }
}
