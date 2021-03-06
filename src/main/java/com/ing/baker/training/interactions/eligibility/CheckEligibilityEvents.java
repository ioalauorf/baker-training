package com.ing.baker.training.interactions.eligibility;

public class CheckEligibilityEvents {
    public interface CheckEligibilityOutcome {}

    public static class CheckEligibilitySucceeded implements CheckEligibilityOutcome {}

    public static final class CheckEligibilityFailed implements CheckEligibilityOutcome {}
}
