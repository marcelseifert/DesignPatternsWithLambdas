package de.mse.hamburg;

import de.mse.hamburg.factory.CircleFactory;
import de.mse.hamburg.factory.GenericFactory;
import de.mse.hamburg.model.Circle;

public class PlayWithFactory {

    public static void main(String[] args) {
        CircleFactory factory = () -> new Circle();

        System.out.printf("%s", factory.newInstance());

        GenericFactory<Circle> circleGenericFactory = GenericFactory.createFactoryForSingleton(Circle::new);
        System.out.printf("%n%s%n", circleGenericFactory.newInstance().hashCode());
        System.out.printf("%n%s%n", circleGenericFactory.newInstance().hashCode());
    }
}
