package com.ing.baker.training.interactions.notification.create;

import com.ing.baker.training.ingredients.Customer;
import com.ing.baker.training.interactions.notification.create.CreateNotificationEvents.CreateNotificationFailed;
import com.ing.baker.training.interactions.notification.create.CreateNotificationEvents.CreateNotificationOutcome;
import com.ing.baker.training.interactions.notification.create.CreateNotificationEvents.CreateNotificationSucceeded;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleCreateNotification implements CreateNotification {
    private final CreateNotificationService createNotificationService;

    public SimpleCreateNotification(final CreateNotificationService createNotificationService) {
        this.createNotificationService = createNotificationService;
    }

    @Override
    public CreateNotificationOutcome apply(final Customer customer) {
        try {
            final var notification = createNotificationService.create(customer);
            return new CreateNotificationSucceeded(notification);
        } catch (Exception e) {
            log.error("Error creating notification", e);
            return new CreateNotificationFailed();
        }
    }
}
