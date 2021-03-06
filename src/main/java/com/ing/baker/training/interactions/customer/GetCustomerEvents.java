package com.ing.baker.training.interactions.customer;

import com.ing.baker.training.ingredients.Customer;
import lombok.Value;

public class GetCustomerEvents {
    public interface GetCustomerOutcome {}

    @Value
    public static class GetCustomerSucceeded implements GetCustomerOutcome {
        Customer customer;
    }

    public static final class GetCustomerFailed implements GetCustomerOutcome {}
}
