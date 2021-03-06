package com.ing.baker.training.utils;

import com.ing.baker.recipe.javadsl.Interaction;
import com.ing.baker.training.interactions.account.SimpleAccountService;
import com.ing.baker.training.interactions.account.SimpleGetAccounts;
import com.ing.baker.training.interactions.customer.SimpleCustomerService;
import com.ing.baker.training.interactions.customer.SimpleGetCustomer;
import com.ing.baker.training.interactions.eligibility.SimpleCheckEligibility;
import com.ing.baker.training.interactions.eligibility.SimpleEligibilityService;
import com.ing.baker.training.interactions.notification.create.SimpleCreateNotification;
import com.ing.baker.training.interactions.notification.create.SimpleCreateNotificationService;
import com.ing.baker.training.interactions.notification.send.SimpleSendNotification;
import com.ing.baker.training.interactions.notification.send.SimpleSendNotificationService;

import java.util.List;

public class InteractionProvider {
    private InteractionProvider() {}

    public static List<Interaction> getAll() {
        return List.of(new SimpleGetAccounts(new SimpleAccountService()),
                new SimpleGetCustomer(new SimpleCustomerService()),
                new SimpleCheckEligibility(new SimpleEligibilityService()),
                new SimpleCreateNotification(new SimpleCreateNotificationService()),
                new SimpleSendNotification(new SimpleSendNotificationService()));
    }
}
