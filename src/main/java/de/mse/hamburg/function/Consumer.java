package de.mse.hamburg.function;

import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {

    void accept(T t);

    default Consumer<T> andThen(Consumer<T> other) {
        Objects.nonNull(other);
        return (T t) -> {
            this.accept(t);
            other.accept(t);
        };
    }
}
