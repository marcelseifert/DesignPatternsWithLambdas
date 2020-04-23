package de.mse.hamburg.factory;

import de.mse.hamburg.model.Circle;

import java.util.function.Supplier;

public interface CircleFactory extends Supplier<Circle> {

    default Circle newInstance() {
        return get();
    }

}
