package com.example.Employees.Services;

import com.example.Employees.Dao.EmployeeDao;
import com.example.Employees.EmployeesApplication;
import com.example.Employees.FeignClients.AddressFeignClient;
import com.example.Employees.Models.Employee;
import com.example.Employees.Response.AddressResponse;
import com.example.Employees.Response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    private RestTemplate restTemplate;


//    @Value("${addressservice.base.url}") //$ is used to get the dynamic value
//    private String addressBaseUrl;

    @Autowired
    private AddressFeignClient addressFeignClient;

//    @Autowired
//    private WebClient webClient;

//    public EmployeeService(@Value("${addressservice.base.url}") String addressBaseUrl ,RestTemplateBuilder builder){
//        System.out.println("Uri: "+addressBaseUrl);
//        this.restTemplate=builder
//                          .rootUri(addressBaseUrl)
//                          .build();
//    }

    public EmployeeResponse getEmployeeDetails(int id){
        // addressResponse-> set data by making a rst api call
       // AddressResponse addressResponse=new AddressResponse();
        Employee employee= this.employeeDao.findById(id).orElse(null);
//        EmployeeResponse employeeResponse=new EmployeeResponse();
//        employeeResponse.setId(employee.getId());
//        employeeResponse.setEmail(employee.getEmail());
//        employeeResponse.setEname(employee.getEname());
//        employeeResponse.setBgroup(employee.getBgroup());
        EmployeeResponse employeeResponse= modelMapper.map(employee, EmployeeResponse.class);
//        AddressResponse addressResponse= restTemplate.getForObject("/address/{id}", AddressResponse.class, id);  //baseUrl +endPoint //This is blocking in nature //Sync API call
//        AddressResponse addressResponse=webClient
//                                               .get()
//                                               .uri("/address/"+id)
//                                               .retrieve()
//                                               .bodyToMono(AddressResponse.class)
//                                               .block();  //Non-Blocking in Nature and It uses Reactive //Async API call
//        employeeResponse.setAddressResponse(addressResponse);

        AddressResponse addressResponse=addressFeignClient.getAddressDetails(id);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }
}
