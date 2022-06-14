package com.xm.core.selenide;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.xm.enums.Screens;
import com.xm.core.properties.PropertyController;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

import static com.xm.core.properties.PropertyController.commonConfig;
import static com.xm.core.properties.PropertyController.systemProperties;

public final class SelenideManager {
    public static void setup() {
        if (systemProperties().browserScreen().isEmpty()) {
            Configuration.startMaximized = true;
        } else {
            Configuration.browserSize = Screens.of(systemProperties().browserScreen()).getValue();
        }
        Configuration.browser = Browsers.CHROME;
        Configuration.baseUrl = commonConfig().applicationHost();
        Configuration.timeout = Long.parseLong(PropertyController.appTimeoutConfig().webdriverWaitTimeout());
        Configuration.reportsFolder = "target/selenide-screenshots";
        Configuration.browserCapabilities = getCapabilities();
    }

    private static DesiredCapabilities getCapabilities() {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        caps.setVersion(commonConfig().chromeVersion());
        return caps;
    }
}
