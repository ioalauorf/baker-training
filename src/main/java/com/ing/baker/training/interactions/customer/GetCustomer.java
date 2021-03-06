package com.ing.baker.training.interactions.customer;

import com.ing.baker.recipe.annotations.FiresEvent;
import com.ing.baker.recipe.annotations.RequiresIngredient;
import com.ing.baker.recipe.javadsl.Interaction;
import com.ing.baker.training.interactions.customer.GetCustomerEvents.GetCustomerFailed;
import com.ing.baker.training.interactions.customer.GetCustomerEvents.GetCustomerOutcome;
import com.ing.baker.training.interactions.customer.GetCustomerEvents.GetCustomerSucceeded;

public interface GetCustomer extends Interaction {
    @FiresEvent(oneOf = {GetCustomerSucceeded.class, GetCustomerFailed.class})
    GetCustomerOutcome apply(@RequiresIngredient("customerId") String customerId);
}
