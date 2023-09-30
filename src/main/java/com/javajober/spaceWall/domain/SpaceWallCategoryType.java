package com.javajober.spaceWall.domain;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum SpaceWallCategoryType {

    CAREER("career", "취업/이직"),
    PERSONAL("personal", "개인/소개"),
    EVENT("event", "이벤트/일상"),
    ENTERPRISE("enterprise", "기업/근로양식"),
    BASIC("basic", "기본 템플릿"),
    EMPTY("empty", "없음");

    private final String engTitle;
    private final String korTitle;

    SpaceWallCategoryType(String engTitle, String korTitle) {
        this.engTitle = engTitle;
        this.korTitle = korTitle;
    }

    public static SpaceWallCategoryType findSpaceWallCategoryTypeByString(String type) {
        return Arrays.stream(values())
            .filter(spaceWallCategoryType -> spaceWallCategoryType.getEngTitle().equals(type))
            .findAny()
            .orElse(EMPTY);
    }
}
