package br.com.likwi.customer.service;

import br.com.likwi.clients.fraud.FraudCheckResponse;
import br.com.likwi.clients.fraud.FraudClient;
import br.com.likwi.customer.config.CustomerConfig;
import br.com.likwi.customer.dao.CustomerRepository;
import br.com.likwi.customer.model.Customer;
import br.com.likwi.customer.record.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(
        CustomerRepository customerRepository,
        CustomerConfig customerConfig,
        FraudClient fraudClient) {

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        final Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();

        //todo: checks
        customerRepository.saveAndFlush(customer);

        //using FeignClient class
        final FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.isFraudster())
            throw new IllegalStateException("Fraudster");
    }
}
