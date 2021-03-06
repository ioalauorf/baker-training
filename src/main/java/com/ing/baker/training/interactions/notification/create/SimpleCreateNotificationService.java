package com.ing.baker.training.interactions.notification.create;

import com.ing.baker.training.ingredients.Customer;
import com.ing.baker.training.ingredients.Notification;

public class SimpleCreateNotificationService implements CreateNotificationService {
    private static final String NOTIFICATION_BODY_TEMPLATE = "Dear %s %s,%n%n" +
            "We created a recipe, then baked the ingredients and concluded that you are a prime candidate for opening an investment account.%n" +
            "Make an appointment to start benefiting immediately!%n%n" +
            "Kind regards,%n" +
            "Your local bakers";

    @Override
    public Notification create(final Customer customer) {
        final var message = String.format(NOTIFICATION_BODY_TEMPLATE, customer.getFirstName(), customer.getLastName());
        return Notification.builder()
                .recipientAddress(customer.getEmailAddress())
                .message(message)
                .build();
    }
}
