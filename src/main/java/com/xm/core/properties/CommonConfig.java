package com.xm.core.properties;

import org.aeonbits.owner.Config;

@Config.Sources({"file:src/main/resources/properties/common.properties"})
@Config.LoadPolicy(Config.LoadType.MERGE)
public interface CommonConfig extends Config {

    @Key("chrome.version")
    String chromeVersion();

    @Key("application.host")
    String applicationHost();

    @Key("ws.host")
    String wsHost();
}
