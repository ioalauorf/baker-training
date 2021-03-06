package com.ing.baker.training.ingredients;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Currency;

@Value
@Builder
public class Account {
    String iban;
    BigDecimal amount;
    AccountType type;
    Currency currency;

    public enum AccountType {
        CURRENT, SAVINGS
    }
}
