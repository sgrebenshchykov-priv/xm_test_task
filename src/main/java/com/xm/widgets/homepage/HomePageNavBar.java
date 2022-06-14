package com.xm.widgets.homepage;

import com.xm.widgets.Widget;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePageNavBar extends Widget<HomePageNavBar> {

    public HomePageNavBar() {
        super($("#main-nav"));
    }

    public HomePageNavBar clickButton(HomePageNavBarButtons button) {
        getSelf().$x(String.format(".//li[contains(@class, 'main_nav_%s')]", button.value)).shouldBe(visible, enabled).click();
        return this;
    }

    @AllArgsConstructor
    @Getter
    public enum HomePageNavBarButtons {
        HOME("home"),
        TRADING("trading"),
        PLATFORMS("platforms"),
        RESEARCH_EDUCATION("research"),
        PROMOTIONS("promotions"),
        ABOUT_US("about"),
        PARTNERSHIPS("partners");

        private String value;
    }
}
