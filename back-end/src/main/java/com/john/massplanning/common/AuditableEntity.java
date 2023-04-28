package com.john.massplanning.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class AuditableEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -2621460117902270169L;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        String username = "nameFromAuthentication";
        this.createdBy = username;
        this.createdDate = now;
        this.updatedBy = username;
        this.updatedDate = now;
    }

    @PreUpdate
    public void preUpdate() {
        LocalDateTime now = LocalDateTime.now();
        String username = "nameFromAuthentication";
        this.updatedBy = username;
        this.updatedDate = now;
    }
}
