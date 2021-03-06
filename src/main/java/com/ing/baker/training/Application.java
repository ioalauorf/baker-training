package com.ing.baker.training;

import com.ing.baker.runtime.javadsl.EventInstance;
import com.ing.baker.training.recipe.OpenInvestmentAccountCampaignRecipe;
import com.ing.baker.training.sensoryevents.StartSensoryEvent;
import com.ing.baker.training.utils.BakerProvider;
import com.ing.baker.training.utils.BakerVisualization;
import com.ing.baker.training.utils.RecipeIdProvider;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class Application {
    public static void main(final String[] args) {
        final var baker = BakerProvider.get();
        final var recipeId = RecipeIdProvider.get(OpenInvestmentAccountCampaignRecipe.getName());
        final var recipeInstanceId = UUID.randomUUID().toString();
        final var startSensoryEvent = StartSensoryEvent.builder()
                .customerId(UUID.randomUUID().toString())
                .build();
        final var eventInstance = EventInstance.from(startSensoryEvent);

        BakerVisualization.createSVGDiagramForRecipe(baker, "recipeVisualState", recipeId);

        baker.bake(recipeId, recipeInstanceId)
                .thenCompose(ignored -> baker.fireEventAndResolveWhenCompleted(recipeInstanceId, eventInstance))
                .thenCompose(sensoryEventResult -> {
                    System.out.println(sensoryEventResult);
                    return baker.getVisualState(recipeInstanceId);
                })
                .thenAccept(dot -> BakerVisualization.createSVGDiagramForDotRepresentation("recipeInstanceIdVisualState", dot))
                .join();
    }
}
