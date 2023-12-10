package com.example.Address.Response;

import lombok.Data;

@Data
public class AddressResponse {
    private int aid;
    private String lan1;
    private String lan2;
    private long zip;
    private String state;
}
