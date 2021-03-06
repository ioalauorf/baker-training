package com.ing.baker.training.interactions.notification.create;

import com.ing.baker.training.ingredients.Customer;
import com.ing.baker.training.ingredients.Notification;

public interface CreateNotificationService {
    Notification create(Customer customer);
}
