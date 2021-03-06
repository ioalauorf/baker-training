package com.ing.baker.training.interactions.notification.send;

import com.ing.baker.recipe.annotations.FiresEvent;
import com.ing.baker.recipe.annotations.RequiresIngredient;
import com.ing.baker.recipe.javadsl.Interaction;
import com.ing.baker.training.ingredients.Notification;
import com.ing.baker.training.interactions.notification.send.SendNotificationEvents.SendNotificationFailed;
import com.ing.baker.training.interactions.notification.send.SendNotificationEvents.SendNotificationOutcome;
import com.ing.baker.training.interactions.notification.send.SendNotificationEvents.SendNotificationSucceeded;

public interface SendNotification extends Interaction {
    @FiresEvent(oneOf = {SendNotificationSucceeded.class, SendNotificationFailed.class})
    SendNotificationOutcome apply(@RequiresIngredient("notification") Notification notification);
}
