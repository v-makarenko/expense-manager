package ru.fes.dto.common;

import java.util.UUID;

/**
 * Created by VMakarenko on 5/7/2015.
 */
public class IdDto extends AbstractDto {
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
