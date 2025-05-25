package ru.osiptsoff.npaws.model.visit;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum AppointmentStatus {
    APPOINTED("APPOINTED"),
    IN_PROGRESS("IN_PROGRESS"),
    FINISHED("FINISHED");

    @Getter
    private final String name;
}
