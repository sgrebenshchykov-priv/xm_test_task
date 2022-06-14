package com.xm.widgets.economiccalendar;

import com.codeborne.selenide.SelenideElement;
import com.xm.widgets.Widget;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class DateSelector extends Widget<DateSelector> {
    public DateSelector(SelenideElement self) {
        super(self);
    }

    public DateSelector selectDateFilter(DateSelectorOptions option) {
        SelenideElement date = getSelf().$x(".//a[contains(@class, 'toggleButton ')]");
        if (date.isDisplayed()) {
            date.click();
        }
        getSelf().$x(String.format(".//a[contains(@id, '%s')]", option.link)).click();
        return this;
    }

    @AllArgsConstructor
    @Getter
    public enum DateSelectorOptions {
        YESTERDAY("Yesterday", "yesterday"),
        TODAY("Today", "today"),
        TOMORROW("Tomorrow", "tomorrow"),
        THIS_WEEK("This Week", "thisWeek");

        private String name;
        private String link;
    }
}
