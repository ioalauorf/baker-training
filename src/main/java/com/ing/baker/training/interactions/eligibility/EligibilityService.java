package com.ing.baker.training.interactions.eligibility;

import com.ing.baker.training.ingredients.Account;
import com.ing.baker.training.ingredients.Customer;

import java.util.List;

public interface EligibilityService {
    boolean check(Customer customer, List<Account> accounts);
}
