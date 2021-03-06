package com.ing.baker.training.utils;

import akka.actor.ActorSystem;
import com.ing.baker.compiler.RecipeCompiler;
import com.ing.baker.runtime.akka.AkkaBaker;
import com.ing.baker.runtime.javadsl.Baker;
import com.ing.baker.runtime.javadsl.InteractionInstance;
import com.ing.baker.training.recipe.OpenInvestmentAccountCampaignRecipe;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;

@Slf4j
public class BakerProvider {
    private static final String BAKER_ACTOR_SYSTEM_NAME = "baker-training";
    private static Baker BAKER;

    private BakerProvider() {
    }

    public static synchronized Baker get() {
        if (BAKER == null) {
            init();
        }
        return BAKER;
    }

    private static void init() {
        final var actorSystem = ActorSystem.create(BAKER_ACTOR_SYSTEM_NAME);
        BAKER = AkkaBaker.javaLocalDefault(actorSystem);

        final var interactions = InteractionProvider.getAll();
        final var recipe = OpenInvestmentAccountCampaignRecipe.getRecipe();
        final var compiledRecipe = RecipeCompiler.compileRecipe(recipe);

        /* converts interaction implementations to object expected by Baker */
        final var interactionInstances = interactions.stream()
                .map(InteractionInstance::from)
                .collect(Collectors.toList());

        /* and adds them to Baker */
        BAKER.addInteractionInstances(interactionInstances)
                .thenCompose(ignored -> BAKER.addRecipe(compiledRecipe))
                .thenAccept(recipeId -> RecipeIdProvider.add(recipe.name(), recipeId))
                .join();
    }
}
