package de.mse.hamburg;

import de.mse.hamburg.function.Consumer;
import de.mse.hamburg.model.Body;
import de.mse.hamburg.model.Car;
import de.mse.hamburg.model.Engine;

public class PlayWithVisitor {
    public static void main(String[] args) {

        Car car = new Car();
        Engine engine = new Engine();
        Body body = new Body();

        Consumer<VisitorBuilder<String>> consumer = Visitor.<Car, String>forType(Car.class).execute(c -> "Visting car " + c)
                .forType(Engine.class).execute((Engine e) -> "Visiting engine " + e);

        Visitor<String> visitor = Visitor.of(consumer);

        visitor.visit(car);
        visitor.visit(engine);
        visitor.visit(body);

    }
}
