package com.xm.pages;

import com.codeborne.selenide.Selenide;
import com.xm.annotations.Url;
import org.assertj.core.api.Assertions;

import static com.xm.core.properties.PropertyController.commonConfig;
import static com.xm.core.utility.WaitUtil.doWait;

public abstract class AbstractPage <T extends AbstractPage>{
    public abstract boolean isOpened();

    @SuppressWarnings("unchecked")
    public T waitForPageLoaded() {
        doWait().untilAsserted(() -> Assertions.assertThat(isOpened())
                .as("%s page was not loaded", getClass())
                .isTrue()
        );
        return (T) this;
    }

    public static <T> T openPage(Class<T> pageClass) {
        return openPageByUrl(pageClass, commonConfig().applicationHost());
    }

    private static <T> T openPageByUrl(Class<T> pageClass, String host) {
        String url = pageClass.isAnnotationPresent(Url.class) ?
                pageClass.getAnnotation(Url.class).pattern().replaceFirst("\\.\\*", "") :
                "";
        return Selenide.open(host + url, pageClass);
    }
}
