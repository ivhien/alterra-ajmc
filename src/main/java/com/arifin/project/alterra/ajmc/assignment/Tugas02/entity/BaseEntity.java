package com.arifin.project.alterra.ajmc.assignment.Tugas02.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class BaseEntity {
    @Column(name = "created_at", nullable = false)
    protected LocalDateTime createAt;

    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

    @Column(name = "is_deleted")
    protected Boolean isDeleted;

    @PrePersist
    void onCreate(){
        this.createAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.isDeleted = false;
    }

    @PreUpdate
    void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
    
}
