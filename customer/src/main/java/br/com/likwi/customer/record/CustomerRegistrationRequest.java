package br.com.likwi.customer.record;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
