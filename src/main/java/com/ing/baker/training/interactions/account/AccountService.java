package com.ing.baker.training.interactions.account;

import com.ing.baker.training.ingredients.Account;

import java.util.List;

public interface AccountService {
    List<Account> get(String customerId);
}
