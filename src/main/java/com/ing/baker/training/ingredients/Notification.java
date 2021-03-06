package com.ing.baker.training.ingredients;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Notification {
    String recipientAddress;
    String message;
}
