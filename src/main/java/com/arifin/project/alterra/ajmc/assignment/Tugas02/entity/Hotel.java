package com.arifin.project.alterra.ajmc.assignment.Tugas02.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="hotel")
@NoArgsConstructor
// @Where(clause = "is_deleted = false")
public class Hotel extends BaseEntity{
    // @Id
    // @GeneratedValue (strategy = GenerationType.IDENTITY)
    // private long hotelId;

    @Id
    @Column(name="code",length = 10, unique = true)
    private String code;

    @Column(length=50)
    private String name;

    @Column(columnDefinition="Decimal(2,1)")
    private Double rating;

    @Column(length=50)
    private String website;

    @Column(name="citycode", length=10)
    private String citycode;

    // TODO define relationship

    // @ManyToOne( optional = false)
    // @JoinColumn(name = "citycode", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    // // @JsonIgnore
    // private City city;

    
}
