package ru.itis.chat.Exceptions;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
    private final ErrEntity entity;

    public ValidationException(ErrEntity entity) {
        super(entity.getMessage());
        this.entity = entity;
    }

    public ValidationException(String entityRawValue) {
        super(entityRawValue);
        this.entity = ErrEntity.valueOf(entityRawValue);
    }

    public ValidationException(ErrEntity entity, String message) {
        super(message);
        this.entity = entity;
    }
}
