package ru.osiptsoff.npaws.util;

import java.util.UUID;

public class UuidUtil {
    private UuidUtil() {

    }

    public static UUID generateUuid() {
        return UUID.randomUUID();
    }
}
