package com.ing.baker.training.recipe;

import com.ing.baker.recipe.javadsl.Recipe;
import com.ing.baker.training.interactions.account.GetAccounts;
import com.ing.baker.training.interactions.customer.GetCustomer;
import com.ing.baker.training.interactions.eligibility.CheckEligibility;
import com.ing.baker.training.interactions.eligibility.CheckEligibilityEvents.CheckEligibilitySucceeded;
import com.ing.baker.training.interactions.notification.create.CreateNotification;
import com.ing.baker.training.interactions.notification.send.SendNotification;
import com.ing.baker.training.sensoryevents.StartSensoryEvent;

import static com.ing.baker.recipe.javadsl.InteractionDescriptor.of;

public class OpenInvestmentAccountCampaignRecipe {
    private static final String RECIPE_NAME = OpenInvestmentAccountCampaignRecipe.class.getSimpleName();

    public static String getName() {
        return RECIPE_NAME;
    }

    public static Recipe getRecipe() {
        return new Recipe(RECIPE_NAME)
                .withSensoryEvent(StartSensoryEvent.class)
                .withInteractions(
                        of(GetAccounts.class),
                        of(GetCustomer.class),
                        of(CheckEligibility.class),
                        of(CreateNotification.class)
                                .withRequiredEvent(CheckEligibilitySucceeded.class),
                        of(SendNotification.class));
    }
}
