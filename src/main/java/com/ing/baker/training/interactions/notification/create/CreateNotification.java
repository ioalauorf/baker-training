package com.ing.baker.training.interactions.notification.create;

import com.ing.baker.recipe.annotations.FiresEvent;
import com.ing.baker.recipe.annotations.RequiresIngredient;
import com.ing.baker.recipe.javadsl.Interaction;
import com.ing.baker.training.ingredients.Customer;
import com.ing.baker.training.interactions.notification.create.CreateNotificationEvents.CreateNotificationFailed;
import com.ing.baker.training.interactions.notification.create.CreateNotificationEvents.CreateNotificationOutcome;
import com.ing.baker.training.interactions.notification.create.CreateNotificationEvents.CreateNotificationSucceeded;

public interface CreateNotification extends Interaction {
    @FiresEvent(oneOf = {CreateNotificationSucceeded.class, CreateNotificationFailed.class})
    CreateNotificationOutcome apply(@RequiresIngredient("customer") Customer customer);
}
