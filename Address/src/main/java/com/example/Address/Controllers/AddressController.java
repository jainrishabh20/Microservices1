package com.example.Address.Controllers;

import com.example.Address.Dao.AddressDao;
import com.example.Address.Model.Address;
import com.example.Address.Response.AddressResponse;
import com.example.Address.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "address/{id}", method = RequestMethod.GET)
    public ResponseEntity<AddressResponse> getAddressDetails(@PathVariable("id") int id){
        System.out.println("Rishabh Jain");
        AddressResponse addressResponse=this.addressService.getAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);

    }

}
