package com.ing.baker.training.interactions.account;

import com.ing.baker.training.interactions.account.GetAccountsEvents.GetAccountsFailed;
import com.ing.baker.training.interactions.account.GetAccountsEvents.GetAccountsOutcome;
import com.ing.baker.training.interactions.account.GetAccountsEvents.GetAccountsSucceeded;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleGetAccounts implements GetAccounts {
    private final AccountService accountService;

    public SimpleGetAccounts(final AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public GetAccountsOutcome apply(final String customerId) {
        try {
            final var accounts = accountService.get(customerId);
            log.info("Retrieved accounts: {}", accounts);
            return new GetAccountsSucceeded(accounts);
        } catch (Exception e) {
            log.error("Error while retrieving accounts", e);
            return new GetAccountsFailed();
        }
    }
}
