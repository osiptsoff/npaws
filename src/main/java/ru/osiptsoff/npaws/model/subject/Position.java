package ru.osiptsoff.npaws.model.subject;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Position {
    ASSISTANT("ASSISTANT"),
    DOCTOR("DOCTOR");

    @Getter
    private final String name;
}
