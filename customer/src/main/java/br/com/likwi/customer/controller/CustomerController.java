package br.com.likwi.customer.controller;

import br.com.likwi.customer.record.CustomerRegistrationRequest;
import br.com.likwi.customer.record.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@Slf4j
@RestController
@RequestMapping("api/v001/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        log.info(MessageFormat.format("new customer registration {0}", customerRegistrationRequest));

        customerService.registerCustomer(customerRegistrationRequest);
    }
}
