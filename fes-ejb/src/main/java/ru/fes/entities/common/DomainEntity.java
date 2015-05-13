package ru.fes.entities.common;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by VMakarenko on 2/4/15.
 */
@MappedSuperclass
public class DomainEntity {
    @Id
    @Column(name="id")
    @Type(type="pg-uuid")
    private UUID id;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    @PrePersist
    public void prePersist(){
        id = UUID.randomUUID();
    }
}
