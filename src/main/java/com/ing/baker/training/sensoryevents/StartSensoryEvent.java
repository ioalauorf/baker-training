package com.ing.baker.training.sensoryevents;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class StartSensoryEvent {
    String customerId;
}
