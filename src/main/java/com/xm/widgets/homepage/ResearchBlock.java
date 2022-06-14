package com.xm.widgets.homepage;

import com.codeborne.selenide.Condition;
import com.xm.widgets.Widget;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ResearchBlock extends Widget<ResearchBlock> {

    public ResearchBlock() {
        super($x(".//li[contains(@class, 'main_nav_research ')]//i[contains(@class, 'xmChart-search')]/../parent::div[@class='block']"));
    }

    public void clickResearchOption(ResearchBlockOptions option) {
        getSelf().$x(String.format(".//a[contains(@href, '%s')]", option.link)).shouldBe(visible, enabled).click();
    }

    @AllArgsConstructor
    @Getter
    public enum ResearchBlockOptions {
        MARKETS_OVERVIEW("Markets Overview", ""),
        NEWS("News", ""),
        XM_RESEARCH("XM Research", ""),
        TRADE_IDEAS("Trade Ideas", ""),
        TECHNICAL_SUMMARIES("Technical Summaries", ""),
        ECONOMIC_CALENDAR("Economic Calendar", "economicCalendar"),
        XM_TV("XM TV", ""),
        PODCAST("Podcast", "");

        private String name;
        private String link;
    }
}
