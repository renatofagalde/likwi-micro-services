package br.com.likwi.customer.service;

import br.com.likwi.customer.config.CustomerConfig;
import br.com.likwi.customer.dao.CustomerRepository;
import br.com.likwi.customer.model.Customer;
import br.com.likwi.customer.record.CustomerRegistrationRequest;
import br.com.likwi.customer.record.FraudCheckResponse;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(
        CustomerRepository customerRepository,
        CustomerConfig customerConfig) {

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        final Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();

        //todo: checks
        customerRepository.saveAndFlush(customer);

        final FraudCheckResponse fraudCheckResponse = this.customerConfig().restTemplate().getForObject(
                "http://localhost:8081/api/v001/fraud-check/{customerId}",
                FraudCheckResponse.class, customer.getId()

        );
        if (fraudCheckResponse.isFraudster())
            throw new IllegalStateException("Fraudster");
    }
}
