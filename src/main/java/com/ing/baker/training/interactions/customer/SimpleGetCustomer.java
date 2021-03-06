package com.ing.baker.training.interactions.customer;

import com.ing.baker.training.interactions.customer.GetCustomerEvents.GetCustomerFailed;
import com.ing.baker.training.interactions.customer.GetCustomerEvents.GetCustomerOutcome;
import com.ing.baker.training.interactions.customer.GetCustomerEvents.GetCustomerSucceeded;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleGetCustomer implements GetCustomer {
    private final CustomerService customerService;

    public SimpleGetCustomer(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public GetCustomerOutcome apply(final String customerId) {
        try {
            final var customer = customerService.get(customerId);
            log.info("Retrieved customer: {}", customer);
            return new GetCustomerSucceeded(customer);
        } catch (Exception e) {
            log.error("Error while retrieving customer", e);
            return new GetCustomerFailed();
        }
    }
}
