package ru.osiptsoff.npaws.model.subject;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Position {
    ADMIN("admin"),
    ASSISTANT("assistant"),
    DOCTOR("doctor"),
    DIRECTOR("director");

    @Getter
    private final String name;
}
