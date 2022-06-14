package com.xm.pages;

import com.xm.annotations.Url;
import com.xm.widgets.economiccalendar.RiskWarningBlock;
import com.xm.widgets.economiccalendar.EconomicCalendar;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Url(pattern = ".*/research/economicCalendar")
public class EconomicCalendarPage extends AbstractPage<EconomicCalendarPage> {

    @Getter private EconomicCalendar economicCalendar = new EconomicCalendar();
    @Getter private RiskWarningBlock riskWarningBlock = new RiskWarningBlock($x(".//div[@class = 'container mt-400']"));

    public boolean isOpened() {
        return economicCalendar.isDisplayed();
    }

    public EconomicCalendarPage open() {
        return openPage(EconomicCalendarPage.class).waitForPageLoaded();
    }
}
