package com.ing.baker.training.utils;

import com.ing.baker.runtime.javadsl.Baker;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.GraphvizV8Engine;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;

@Slf4j
public class BakerVisualization {
    public static void createSVGDiagramForRecipe(final Baker baker, final String filename, final String recipeId) {
        try {
            final var dot = baker.getRecipe(recipeId).get().getCompiledRecipe().getRecipeVisualization();
            final var file = GraphvizGenerator.generateSVGFile(filename, dot);
            log.info("Diagram created: {}", file.toURI());
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error while creating recipe visual state", e);
        }
    }

    public static void createSVGDiagramForDotRepresentation(final String filename, final String dot) {
        final var file = GraphvizGenerator.generateSVGFile(filename, dot);
        log.info("Diagram created: {}", file.toURI());
    }

    private static class GraphvizGenerator {
        private static final Format FORMAT = Format.SVG;

        static {
            Graphviz.useEngine(new GraphvizV8Engine());
        }

        public static File generateSVGFile(final String fileName, final String dotDiagram) {
            final var path = Paths.get("target", "diagrams", fileName + "." + FORMAT.name().toLowerCase());
            try {
                return Graphviz.fromString(dotDiagram).render(FORMAT).toFile(path.toFile());
            } catch (IOException e) {
                log.error(String.format("Cannot create file %s", path), e);
                throw new AssertionError(e.getMessage());
            }
        }
    }
}
