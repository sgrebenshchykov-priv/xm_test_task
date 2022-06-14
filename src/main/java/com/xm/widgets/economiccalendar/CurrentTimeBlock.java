package com.xm.widgets.economiccalendar;

import com.codeborne.selenide.SelenideElement;
import com.xm.widgets.Widget;

public class CurrentTimeBlock extends Widget<CurrentTimeBlock> {

    private SelenideElement currentTime = getSelf().$("#currentTime");

    public CurrentTimeBlock(SelenideElement self) {
        super(self);
    }

    public String getCurrentTime() {
        return currentTime.text();
    }
}
