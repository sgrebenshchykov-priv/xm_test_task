package com.xm.tests.ui.economiccalendar;

import com.xm.annotations.Screen1024x768;
import com.xm.pages.EconomicCalendarPage;
import com.xm.pages.HomePage;
import com.xm.pages.RiskDisclosurePage;
import com.xm.tests.ui.common.UiTest;
import com.xm.widgets.economiccalendar.DatePicker;
import com.xm.widgets.economiccalendar.EconomicCalendar;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static com.xm.widgets.economiccalendar.DateSelector.DateSelectorOptions.THIS_WEEK;
import static com.xm.widgets.economiccalendar.DateSelector.DateSelectorOptions.TODAY;
import static com.xm.widgets.economiccalendar.DateSelector.DateSelectorOptions.TOMORROW;
import static com.xm.widgets.economiccalendar.DateSelector.DateSelectorOptions.YESTERDAY;
import static com.xm.widgets.homepage.HomePageNavBar.HomePageNavBarButtons.RESEARCH_EDUCATION;
import static com.xm.widgets.homepage.ResearchBlock.ResearchBlockOptions.ECONOMIC_CALENDAR;

@Screen1024x768
public class EconomicCalendarDateFiltrationTest extends UiTest {
    private HomePage homePage = new HomePage();
    private EconomicCalendarPage economicCalendarPage = new EconomicCalendarPage();

    @BeforeAll
    void beforeAll() {
        homePage.open();
        homePage.getCookieModal().clickAcceptAllButton();

    }

    @BeforeEach
    void beforeEach() {
        homePage.getHomePageNavBar().clickButton(RESEARCH_EDUCATION);
        homePage.getResearchBlock().clickResearchOption(ECONOMIC_CALENDAR);
    }

    @Test
    void dateFiltrationAndDisclaimerHereLinkTest() {
        EconomicCalendar economicCalendar = economicCalendarPage.getEconomicCalendar().switchToIframe();
        DatePicker datePicker = economicCalendar.getDatePicker();
        LocalDate currentDate = LocalDate.now();

        economicCalendar.selectDateFilterWithWait(YESTERDAY);
        List<LocalDate> yesterday = datePicker.getPeriod();

        economicCalendar.selectDateFilterWithWait(TODAY);
        List<LocalDate> today = datePicker.getPeriod();

        economicCalendar.selectDateFilterWithWait(TOMORROW);
        List<LocalDate> tomorrow = datePicker.getPeriod();

        economicCalendar.selectDateFilterWithWait(THIS_WEEK);
        List<LocalDate> thisWeek = datePicker.getPeriod();

        economicCalendar.switchToDefaultContent();

        RiskDisclosurePage riskDisclosurePage = economicCalendarPage
                .getRiskWarningBlock()
                .clickHereLink()
                .waitForPageLoaded();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(yesterday.get(0))
                    .as("Start date of Yesterday period is incorrect")
                    .isEqualTo(currentDate.minusDays(1));

            softly.assertThat(yesterday.get(1))
                    .as("End date of Yesterday period is incorrect")
                    .isEqualTo(currentDate.minusDays(1));

            softly.assertThat(today.get(0))
                    .as("Start date of Today period is incorrect")
                    .isEqualTo(currentDate);

            softly.assertThat(today.get(1))
                    .as("End date of Today period is incorrect")
                    .isEqualTo(currentDate);

            softly.assertThat(tomorrow.get(0))
                    .as("Start date of Tomorrow period is incorrect")
                    .isEqualTo(currentDate.plusDays(1));

            softly.assertThat(tomorrow.get(1))
                    .as("End date of Tomorrow period is incorrect")
                    .isEqualTo(currentDate.plusDays(1));

            softly.assertThat(thisWeek.get(0))
                    .as("Start date of This Week period is incorrect")
                    .isEqualTo(currentDate.with(DayOfWeek.MONDAY).minusDays(1));

            softly.assertThat(thisWeek.get(1))
                    .as("End date of This Week period is incorrect")
                    .isEqualTo(currentDate.with(DayOfWeek.SATURDAY));

            softly.assertThat(riskDisclosurePage.getHeaderText())
                    .as("Header is incorrect")
                    .isEqualToIgnoringCase("Notification on Non-Independent Investment Research and Risk Warning");
        });
    }
}
