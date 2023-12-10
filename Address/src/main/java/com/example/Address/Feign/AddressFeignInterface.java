package com.example.Address.Feign;

import com.example.Address.Model.Address;
import com.example.Address.Response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("EMPLOYEE-SERVICE")
public interface AddressFeignInterface {

    @RequestMapping(value = "employee/{eid}", method = RequestMethod.GET)
    public abstract AddressResponse getEmployeeAddress(@PathVariable("eid") int id);

}
