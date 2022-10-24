package com.arifin.project.alterra.ajmc.assignment.Tugas02.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long addressId;

    @Column(name="address",length = 250)
    private String address;

    @Column(name="zipcode",length = 20)
    private String zipCode;

    @Column(name="hotelcode", length = 10, nullable = false)
    private String hotelcode;
    // TODO define relationship

    // @ManyToOne( optional = false)
    // @JoinColumn(name = "hotelcode", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    // private Hotel hotel;

}
