package com.example.Address.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int aid;
    private String lan1;
    private String lan2;
    private long zip;
    private String state;


}
