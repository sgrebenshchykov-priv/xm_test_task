package com.xm.core.properties;

import org.aeonbits.owner.Config;
import org.awaitility.Duration;


import static org.aeonbits.owner.Config.*;

@Sources("file:src/main/resources/properties/timeout.properties")
@LoadPolicy(LoadType.MERGE)
public interface AppTimeoutConfig extends Config {

    @Key("webdriver.wait.timeout")
    String webdriverWaitTimeout();

    @Key("wait.timeout")
    String waitTimeout();

    @Key("wait.medium.timeout")
    String waitMediumTimeout();
}
