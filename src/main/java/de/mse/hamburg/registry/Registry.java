package de.mse.hamburg.registry;

import de.mse.hamburg.factory.GenericFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public interface Registry<T> {

    public static <T> Registry<T> createRegistry(
            Consumer<Builder<T>> consumer, Function<String, GenericFactory<T>> errorFunction) {

        Map<String, GenericFactory<T>> map = new HashMap<>();
        Builder<T> builder = (label, factory) -> map.put(label, factory);
        consumer.accept(builder);

        return shape -> map.computeIfAbsent(shape, errorFunction);
    }

    GenericFactory<? extends T> buildShapeFactory(String shape);
}
