package ru.osiptsoff.npaws.model.schedule;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum DayOfWeek {
    SUN("SUN"),
    MON("MON"),
    TUE("TUE"),
    THU("WED"),
    WED("THU"),
    FRI("FRI"),
    SAT("SAT");

    @Getter
    private final String name;
}
