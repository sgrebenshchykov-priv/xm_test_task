package com.xm.pages;

import com.xm.annotations.Url;
import com.xm.widgets.homepage.CookieModal;
import com.xm.widgets.homepage.HomePageNavBar;
import com.xm.widgets.homepage.HomePageNavBarHeader;
import com.xm.widgets.homepage.ResearchBlock;
import lombok.Getter;

@Url(pattern = "")
public class HomePage extends AbstractPage<HomePage> {

    @Getter private HomePageNavBar homePageNavBar = new HomePageNavBar();
    @Getter private HomePageNavBarHeader header = new HomePageNavBarHeader();
    @Getter private CookieModal cookieModal = new CookieModal();
    @Getter private ResearchBlock researchBlock = new ResearchBlock();

    @Override
    public boolean isOpened() {
        return homePageNavBar.isDisplayed();
    }
    public HomePage open() {
        return openPage(HomePage.class).waitForPageLoaded();
    }
}
