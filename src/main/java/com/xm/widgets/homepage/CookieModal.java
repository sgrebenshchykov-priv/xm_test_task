package com.xm.widgets.homepage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xm.pages.HomePage;
import com.xm.widgets.Widget;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CookieModal extends Widget<CookieModal> {

    private SelenideElement acceptAllButton = getSelf().$x(".//button[contains(@class, 'acceptDefaultCookie')]");

    public CookieModal() {
        super($("#cookieModal"));
    }

    public HomePage clickAcceptAllButton() {
        acceptAllButton.should(visible, enabled).click();
        return new HomePage();
    }
}
