package com.arifin.project.alterra.ajmc.assignment.Tugas02.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="countries")
@NoArgsConstructor
public class Country {
    @Id
    @Column(name="code", length=2)
    private String code;

    @Column(name="name", length=50)
    private String name;
}
