package de.mse.hamburg;

import de.mse.hamburg.factory.GenericFactory;
import de.mse.hamburg.model.Rectangle;
import de.mse.hamburg.model.Shape;
import de.mse.hamburg.model.Square;
import de.mse.hamburg.model.Triangle;
import de.mse.hamburg.registry.Builder;
import de.mse.hamburg.registry.Registry;

import java.util.function.Consumer;

public class PlayWithRegistry {

    public static void main(String[] args) {
        Consumer<Builder<Shape>> consumer1 =
                builder -> builder.register("rectangle", Rectangle::new);
        Consumer<Builder<Shape>> consumer2 =
                builder -> builder.register("triangle", Triangle::new);

        Consumer<Builder<Shape>> initializer = consumer1.andThen(consumer2);

        Registry<Shape> registry = Registry.createRegistry(
                initializer, s -> {
                    throw new IllegalArgumentException("Unknown shape: " + s);
                });

        GenericFactory<Rectangle> buildRectangleFactory =
                (GenericFactory<Rectangle>) registry.buildShapeFactory("rectangle");

        Rectangle rectangle = buildRectangleFactory.newInstance();
        System.out.println("Rectangle = " + rectangle);

        GenericFactory<Triangle> buildTriangleFactory =
                (GenericFactory<Triangle>) registry.buildShapeFactory("triangle");

        Triangle triangle = buildTriangleFactory.newInstance();
        System.out.println("Triangle = " + triangle);

        GenericFactory<Square> buildSquareFactory =
                (GenericFactory<Square>) registry.buildShapeFactory("square");
        Square square = buildSquareFactory.newInstance();
    }
}
