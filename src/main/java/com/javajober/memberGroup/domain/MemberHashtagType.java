package com.javajober.memberGroup.domain;

import lombok.Getter;

@Getter
public enum MemberHashtagType {

    FRIEND("친구"),
    COLLEAGUE("직장동료");

    private final String description;

    MemberHashtagType(final String description) {
        this.description = description;
    }
}
