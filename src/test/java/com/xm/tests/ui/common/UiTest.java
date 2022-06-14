package com.xm.tests.ui.common;

import com.codeborne.selenide.WebDriverRunner;
import com.xm.core.selenide.SelenideManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UiTest {

    @BeforeAll
    public void beforeAllTests() {
        SelenideManager.setup();
    }

    @AfterAll
    void afterAllTests() {
        WebDriverRunner.closeWebDriver();
    }
}
