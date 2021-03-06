package com.ing.baker.training.interactions.account;

import com.ing.baker.recipe.annotations.FiresEvent;
import com.ing.baker.recipe.annotations.RequiresIngredient;
import com.ing.baker.recipe.javadsl.Interaction;
import com.ing.baker.training.interactions.account.GetAccountsEvents.GetAccountsOutcome;
import com.ing.baker.training.interactions.account.GetAccountsEvents.GetAccountsFailed;
import com.ing.baker.training.interactions.account.GetAccountsEvents.GetAccountsSucceeded;

public interface GetAccounts extends Interaction {
    @FiresEvent(oneOf = {GetAccountsSucceeded.class, GetAccountsFailed.class})
    GetAccountsOutcome apply(@RequiresIngredient("customerId") String customerId);
}
