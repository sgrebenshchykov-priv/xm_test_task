package com.xm.widgets.economiccalendar;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.xm.widgets.Widget;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.xm.core.utility.WaitUtil.doWait;
import static com.xm.widgets.economiccalendar.DateSelector.*;
import static org.assertj.core.api.Assertions.assertThat;

public class EconomicCalendar extends Widget<EconomicCalendar> {

    @Getter private CurrentTimeBlock currentTimeBlock = new CurrentTimeBlock($("#ecoCurrentTime"));
    @Getter private DateSelector dateSelector = new DateSelector($("#timeselector"));
    @Getter private DatePicker datePicker = new DatePicker($(".ecoTimeAndDate"));
    private SelenideElement loader = $("#economicCalendarLoading");
    public EconomicCalendar() {
        super($(".economic-calendar"));
    }

    public EconomicCalendar switchToIframe() {
        Selenide.switchTo().frame(0);
        return this;
    }
    public EconomicCalendar switchToDefaultContent() {
        Selenide.switchTo().defaultContent();
        return this;
    }

    public void selectDateFilterWithWait(DateSelectorOptions option) {
        dateSelector.selectDateFilter(option);
        waitForDataReloaded();
    }

    public void waitForDataReloaded() {
        waitForLoaderAppear();
        waitForLoaderDisappear();
    }

    private void waitForLoaderAppear() {
        doWait().untilAsserted(() -> assertThat(loader.getAttribute("style")).as("Loader is not appear").isEqualToIgnoringCase("display: block;"));
    }

    private void waitForLoaderDisappear() {
        doWait().untilAsserted(() -> assertThat(loader.isDisplayed()).as("Loader is not appear").isFalse());
    }
}
