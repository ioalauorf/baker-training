package com.ing.baker.training.interactions.account;

import com.ing.baker.training.ingredients.Account;
import lombok.Value;

import java.util.List;

public class GetAccountsEvents {
    public interface GetAccountsOutcome {}

    @Value
    public static class GetAccountsSucceeded implements GetAccountsOutcome {
        List<Account> accounts;
    }

    public static final class GetAccountsFailed implements GetAccountsOutcome {}
}
