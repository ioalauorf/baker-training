package com.ing.baker.training.interactions.account;

import com.ing.baker.training.ingredients.Account;
import com.ing.baker.training.ingredients.Account.AccountType;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

public class SimpleAccountService implements AccountService {
    @Override
    public List<Account> get(final String customerId) {
        return generateAccounts();
    }

    private List<Account> generateAccounts() {
        final var currentAccount = Account.builder()
                .iban("BE0000000000")
                .currency(Currency.getInstance("EUR"))
                .amount(new BigDecimal("10"))
                .type(AccountType.CURRENT)
                .build();

        final var savingsAccount = Account.builder()
                .iban("BE0000000001")
                .currency(Currency.getInstance("EUR"))
                .amount(new BigDecimal("100"))
                .type(AccountType.SAVINGS)
                .build();

        return List.of(currentAccount, savingsAccount);
    }
}
