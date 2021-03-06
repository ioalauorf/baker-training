package com.ing.baker.training.interactions.notification.send;

public class SendNotificationEvents {
    public interface SendNotificationOutcome {}

    public static class SendNotificationSucceeded implements SendNotificationOutcome {}

    public static final class SendNotificationFailed implements SendNotificationOutcome {}
}
