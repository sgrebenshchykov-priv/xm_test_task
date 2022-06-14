package com.xm.core.properties;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.aeonbits.owner.ConfigFactory;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PropertyController {
    private static CommonConfig commonConfig;
    private static AppTimeoutConfig appTimeoutConfig;
    private static GlobalSystemProperties globalSystemProperties;

    public static CommonConfig commonConfig() {
        return Optional.ofNullable(commonConfig).orElseGet(() ->
                commonConfig = ConfigFactory.create(CommonConfig.class));
    }

    public static AppTimeoutConfig appTimeoutConfig() {
        return Optional.ofNullable(appTimeoutConfig).orElseGet(() -> appTimeoutConfig = ConfigFactory.create(AppTimeoutConfig.class));
    }

    public static GlobalSystemProperties systemProperties() {
        return Optional.ofNullable(globalSystemProperties).orElseGet(() -> globalSystemProperties = ConfigFactory.create(GlobalSystemProperties.class, System.getProperties()));
    }
}
