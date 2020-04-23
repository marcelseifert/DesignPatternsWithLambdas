package de.mse.hamburg.registry;

import de.mse.hamburg.factory.GenericFactory;

public interface Builder<T> {

    void register(String label, GenericFactory<T> factory);
}
