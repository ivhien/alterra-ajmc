package com.arifin.project.alterra.ajmc.assignment.Tugas02.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "city")
@NoArgsConstructor
public class City{
    @Id
    @Column(length=10)
    private String code;

    @Column(length=50)
    private String name;

    @Column(name="countrycode", length=2, nullable = false)
    private String countrycode;
    // TODO define relationship
    // @ManyToOne( optional = false)
    // @JoinColumn(name = "countrycode", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    // @JsonIgnore
    // private Country country;
}
