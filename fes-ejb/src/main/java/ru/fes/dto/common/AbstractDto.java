package ru.fes.dto.common;

import java.util.UUID;

/**
 * Created by VMakarenko on 4/27/2015.
 */
public class AbstractDto {
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
