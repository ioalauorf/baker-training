package com.ing.baker.training.interactions.eligibility;

import com.ing.baker.training.ingredients.Account;
import com.ing.baker.training.ingredients.Customer;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Currency;
import java.util.List;

@Slf4j
public class SimpleEligibilityService implements EligibilityService {
    private static final Currency EURO = Currency.getInstance("EUR");
    private static final BigDecimal AMOUNT_THRESHOLD = new BigDecimal("50");
    private static final int MATURITY_THRESHOLD = 30;

    @Override
    public boolean check(final Customer customer, final List<Account> accounts) {
        return hasSufficientMaturity(customer) && hasSufficientAmount(accounts);
    }

    private int calculateAge(final Customer customer) {
        var birthday = customer.getBirthday();
        var now = LocalDate.now();
        var period = Period.between(birthday, now);
        return period.getYears();
    }

    private boolean hasSufficientMaturity(final Customer customer) {
        final var age = calculateAge(customer);
        log.info("Customer is {} years old", age);
        return age >= MATURITY_THRESHOLD;
    }

    private boolean hasSufficientAmount(final List<Account> accounts) {
        final var totalAmount = accounts.stream()
                .filter(account -> EURO.getCurrencyCode().equals(account.getCurrency().getCurrencyCode()))
                .map(Account::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        log.info("Customer has a total of {} EUR in his/her accounts", totalAmount);
        return totalAmount.compareTo(AMOUNT_THRESHOLD) >= 0;
    }
}
