package ru.osiptsoff.npaws.service.exception;

import org.springframework.dao.NonTransientDataAccessException;

import lombok.experimental.StandardException;

@StandardException
public class MissingEntityException extends NonTransientDataAccessException {
    
}
