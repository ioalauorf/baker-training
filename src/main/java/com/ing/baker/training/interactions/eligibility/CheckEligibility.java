package com.ing.baker.training.interactions.eligibility;

import com.ing.baker.recipe.annotations.FiresEvent;
import com.ing.baker.recipe.annotations.RequiresIngredient;
import com.ing.baker.recipe.javadsl.Interaction;
import com.ing.baker.training.ingredients.Account;
import com.ing.baker.training.ingredients.Customer;
import com.ing.baker.training.interactions.eligibility.CheckEligibilityEvents.CheckEligibilityFailed;
import com.ing.baker.training.interactions.eligibility.CheckEligibilityEvents.CheckEligibilityOutcome;
import com.ing.baker.training.interactions.eligibility.CheckEligibilityEvents.CheckEligibilitySucceeded;

import java.util.List;

public interface CheckEligibility extends Interaction {
    @FiresEvent(oneOf = {CheckEligibilitySucceeded.class, CheckEligibilityFailed.class})
    CheckEligibilityOutcome apply(@RequiresIngredient("customer") Customer customer, @RequiresIngredient("accounts") List<Account> accounts);
}
