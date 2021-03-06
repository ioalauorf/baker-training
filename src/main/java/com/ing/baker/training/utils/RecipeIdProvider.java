package com.ing.baker.training.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RecipeIdProvider {
    private static final Map<String, String> RECIPE_INSTANCE_ID_MAP = new ConcurrentHashMap<>();

    private RecipeIdProvider() {
    }

    public static String get(final String recipeName) {
        return RECIPE_INSTANCE_ID_MAP.get(recipeName);
    }

    public static void add(final String recipeName, final String recipeInstanceId) {
        RECIPE_INSTANCE_ID_MAP.put(recipeName, recipeInstanceId);
    }
}
