package com.ing.baker.training.interactions.notification.send;

import com.ing.baker.training.ingredients.Notification;

public class SimpleSendNotificationService implements SendNotificationService {
    @Override
    public boolean send(Notification notification) {
        System.out.println("Recipient: " + notification.getRecipientAddress());
        System.out.println("Message: " + notification.getMessage());
        return true;
    }
}
