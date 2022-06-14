package com.xm.widgets.economiccalendar;


import com.codeborne.selenide.SelenideElement;
import com.xm.pages.RiskDisclosurePage;
import com.xm.widgets.Widget;

public class RiskWarningBlock extends Widget<RiskWarningBlock> {

    private SelenideElement hereLink = getSelf().$x(".//a[text() = 'here']");

    public RiskWarningBlock(SelenideElement self) {
        super(self);
    }

    public RiskDisclosurePage clickHereLink() {
        getSelf().scrollTo();
        hereLink.click();
        return new RiskDisclosurePage();
    }
}