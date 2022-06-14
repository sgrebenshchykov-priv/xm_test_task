package com.xm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Getter
public enum Screens {
    _1024_768_("1024x768"),
    _800_600_("800x600");

    private String value;

    public static Screens of(String value) {
        return Arrays.stream(values())
                .filter(v -> v.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("Screen resolution for '%s' value is not found", value)));
    }
}
