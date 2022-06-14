package com.xm.pages;

import com.codeborne.selenide.SelenideElement;
import com.xm.annotations.Url;

import static com.codeborne.selenide.Selenide.$x;

@Url(pattern = ".*/research/risk_warning")
public class RiskDisclosurePage extends AbstractPage<RiskDisclosurePage> {

    private SelenideElement header = $x(".//h2");

    @Override
    public boolean isOpened() {
        return header.isDisplayed();
    }

    public String getHeaderText() {
        return header.text();
    }
}
