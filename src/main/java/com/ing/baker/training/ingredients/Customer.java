package com.ing.baker.training.ingredients;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class Customer {
    String id;
    String firstName;
    String lastName;
    LocalDate birthday;
    String emailAddress;
}
