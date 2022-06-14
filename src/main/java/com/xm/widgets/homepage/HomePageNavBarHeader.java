package com.xm.widgets.homepage;

import com.codeborne.selenide.SelenideElement;
import com.xm.widgets.Widget;

import static com.codeborne.selenide.Selenide.$x;

public class HomePageNavBarHeader extends Widget<HomePageNavBarHeader> {

    private SelenideElement logo = getSelf().$x(".//a[@class, 'navbar-brand logo']");

    public HomePageNavBarHeader() {
        super($x(".//div[contains(@class, 'navbar-header')]"));
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }
}
