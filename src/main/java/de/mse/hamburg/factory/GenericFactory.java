package de.mse.hamburg.factory;

import java.util.function.Supplier;

public interface GenericFactory<T> extends Supplier<T> {

    static <T> GenericFactory<T> createFactoryForSingleton(Supplier<T> supplier) {
        T singleton = supplier.get();
        return () -> singleton;
    }

    default T newInstance() {
        return get();
    }
}
