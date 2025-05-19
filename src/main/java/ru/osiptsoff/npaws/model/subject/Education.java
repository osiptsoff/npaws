package ru.osiptsoff.npaws.model.subject;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Education {
    SECONDARY("SECONDARY"),
    SPECIALITY("SPECIALITY");

    @Getter
    private final String name;
}
