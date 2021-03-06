package com.ing.baker.training.interactions.customer;

import com.ing.baker.training.ingredients.Customer;

public interface CustomerService {
    Customer get(String customerId);
}
