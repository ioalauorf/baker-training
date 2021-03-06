package com.ing.baker.training.interactions.customer;

import com.ing.baker.training.ingredients.Customer;

import java.time.LocalDate;
import java.time.Month;

public class SimpleCustomerService implements CustomerService {
    @Override
    public Customer get(final String customerId) {
        return Customer.builder()
                .id(customerId)
                .firstName("John")
                .lastName("Doe")
                .birthday(LocalDate.of(1990, Month.JANUARY, 1))
                .emailAddress("john.doe@ing.com")
                .build();
    }
}
