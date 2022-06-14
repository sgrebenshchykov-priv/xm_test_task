package com.xm.widgets.economiccalendar;

import com.codeborne.selenide.SelenideElement;
import com.xm.widgets.Widget;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DatePicker extends Widget<DatePicker> {

    public static final String DATE_TIME_FORMAT = "dd/MM/yyyy";
    private SelenideElement dateRange = getSelf().$("#widgetFieldDateRange");
    private SelenideElement dateSelector = getSelf().$("#datePickerIconWrap");

    public DatePicker(SelenideElement self) {
        super(self);
    }

    public List<LocalDate> getPeriod() {
        return Arrays.stream(dateRange.text().split("-"))
                .map(date -> LocalDate.parse(date.trim(), DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)))
                .collect(Collectors.toList());
    }
}
