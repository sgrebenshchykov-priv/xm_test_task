package com.xm.widgets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class Widget <T extends Widget>{
    private SelenideElement self;

    public Widget(SelenideElement self) {
        this.self = self;
    }

    public SelenideElement getSelf() {
        return self;
    }

    public T shouldBe(Condition condition) {
        self.shouldBe(condition);
        return (T) this;
    }

    public boolean isDisplayed() {
        return self.isDisplayed();
    }
}
