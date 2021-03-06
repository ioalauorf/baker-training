package com.ing.baker.training.interactions.notification.create;

import com.ing.baker.training.ingredients.Notification;
import lombok.Value;

public class CreateNotificationEvents {
    public interface CreateNotificationOutcome {}

    @Value
    public static class CreateNotificationSucceeded implements CreateNotificationOutcome {
        Notification notification;
    }

    public static final class CreateNotificationFailed implements CreateNotificationOutcome {}
}
