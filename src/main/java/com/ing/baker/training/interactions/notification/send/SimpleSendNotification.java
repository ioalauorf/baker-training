package com.ing.baker.training.interactions.notification.send;

import com.ing.baker.training.ingredients.Notification;
import com.ing.baker.training.interactions.notification.send.SendNotificationEvents.SendNotificationFailed;
import com.ing.baker.training.interactions.notification.send.SendNotificationEvents.SendNotificationOutcome;
import com.ing.baker.training.interactions.notification.send.SendNotificationEvents.SendNotificationSucceeded;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleSendNotification implements SendNotification {
    private final SendNotificationService sendNotificationService;

    public SimpleSendNotification(final SendNotificationService sendNotificationService) {
        this.sendNotificationService = sendNotificationService;
    }

    @Override
    public SendNotificationOutcome apply(final Notification notification) {
        try {
            final var outcome = sendNotificationService.send(notification);
            if (outcome) {
                log.info("Notification sent successfully");
                return new SendNotificationSucceeded();
            }
            return new SendNotificationFailed();
        } catch (Exception e) {
            log.error("Error while sending notification", e);
            return new SendNotificationFailed();
        }
    }
}
