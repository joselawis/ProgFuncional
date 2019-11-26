package functional.programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6);

		// Predicado
		lista.stream().filter(getPredicado()).forEach(getForEach());
	}

	public static Consumer<Integer> getForEach() {
		return new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		};
	}

	public static Predicate<Integer> getPredicado() {
		return new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
		};
	}
}
