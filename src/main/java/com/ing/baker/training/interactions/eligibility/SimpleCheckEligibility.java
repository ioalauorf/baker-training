package com.ing.baker.training.interactions.eligibility;

import com.ing.baker.training.ingredients.Account;
import com.ing.baker.training.ingredients.Customer;
import com.ing.baker.training.interactions.eligibility.CheckEligibilityEvents.CheckEligibilityFailed;
import com.ing.baker.training.interactions.eligibility.CheckEligibilityEvents.CheckEligibilityOutcome;
import com.ing.baker.training.interactions.eligibility.CheckEligibilityEvents.CheckEligibilitySucceeded;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class SimpleCheckEligibility implements CheckEligibility {
    private final EligibilityService eligibilityService;

    public SimpleCheckEligibility(final EligibilityService eligibilityService) {
        this.eligibilityService = eligibilityService;
    }

    @Override
    public CheckEligibilityOutcome apply(final Customer customer, final List<Account> accounts) {
        try {
            final var isCustomerEligible = eligibilityService.check(customer, accounts);
            if (isCustomerEligible) {
                log.info("Customer is eligible");
                return new CheckEligibilitySucceeded();
            }
            return new CheckEligibilityFailed();
        } catch (Exception e) {
            log.error("Error while checking eligibility", e);
            return new CheckEligibilityFailed();
        }
    }
}
