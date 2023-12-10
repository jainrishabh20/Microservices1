package com.example.Address.Services;

import com.example.Address.Dao.AddressDao;
import com.example.Address.Feign.AddressFeignInterface;
import com.example.Address.Model.Address;
import com.example.Address.Response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse getAddress(int id){
        System.out.println("Rishabh Jain");
        Address address= this.addressDao.findById(id).orElse(null);
        AddressResponse addressResponse= modelMapper.map(address, AddressResponse.class);
        return addressResponse;

    }

}
