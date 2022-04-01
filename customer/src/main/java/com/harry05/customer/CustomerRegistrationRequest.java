package com.harry05.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
