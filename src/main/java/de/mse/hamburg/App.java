package de.mse.hamburg;

import de.mse.hamburg.function.Consumer;

import java.util.function.Function;
import java.util.function.Predicate;

public class App {

    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println("c1 = " + s);
        Consumer<String> c2 = s -> System.out.println("c2 = " + s);

        Consumer<String> c3 = c1.andThen(c2);

        c3.accept("Hello");

        Predicate<String> p1 = s -> s != null;
        Predicate<String> p2 = s -> !s.isEmpty();
        Predicate<String> p3 = p1.and(p2);

        System.out.printf("%s%n", p3.test("ss"));

        Meteo meteo = new Meteo(20);

        Function<Meteo, Integer> f1 = m -> m.getTemperature();
        Function<Integer, Double> f2 = t -> t * 9d / 2d + 32d;

        Function<Meteo, Double> f3 = f2.compose(f1);

        System.out.printf("%s%n", f3.apply(meteo));
    }
}
