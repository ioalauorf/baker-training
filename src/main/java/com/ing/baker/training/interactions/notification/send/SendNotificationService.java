package com.ing.baker.training.interactions.notification.send;

import com.ing.baker.training.ingredients.Notification;

public interface SendNotificationService {
    boolean send(Notification notification);
}
