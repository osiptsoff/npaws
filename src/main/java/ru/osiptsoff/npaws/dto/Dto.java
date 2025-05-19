package ru.osiptsoff.npaws.dto;

import java.util.UUID;

public abstract class Dto<T> {
    public abstract T getEntity();
    public abstract Dto<T> fillByEntity(T entity);
    public abstract UUID getId();
    public abstract void setId(UUID id);

    public static final <T> Dto<T> instantiate(final Class<? extends Dto<T>> clazz) {
        final String errorMessageTemplate = "Cannot call no args constructor for '%s'.";

        try {
            return clazz.getConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(String.format(errorMessageTemplate, clazz.getName()));
        }
    }

    public static final <T> Dto<T> instantiate(final Class<? extends Dto<T>> clazz, final T entity) {
        return instantiate(clazz).fillByEntity(entity);
    }
}
