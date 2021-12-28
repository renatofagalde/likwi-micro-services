package br.com.likwi.customer.record;

import br.com.likwi.customer.dao.CustomerRepository;
import br.com.likwi.customer.model.Customer;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        final Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();

        //todo: checks
        this.customerRepository.save(customer);
    }
}
