package com.example.Employees.FeignClients;

import com.example.Employees.Response.AddressResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//http://localhost:8085/address-app/api/
@FeignClient(name = "abc", url = "http://localhost:8085/address-app/api/")
//@FeignClient(name = "address-service", path = "/address-app/api/")
//@RibbonClient(name = "address-service")
public interface AddressFeignClient {

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    AddressResponse getAddressDetails(@PathVariable("id") int id);
}
