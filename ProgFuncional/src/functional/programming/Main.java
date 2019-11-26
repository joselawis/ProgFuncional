package functional.programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6);

		// lista.stream().filter(((Predicate<Integer>)t -> t % 2 == 0).negate()).forEach(getForEach());
		// lista.stream().filter(t -> t % 2 == 0).forEach(getForEach());
		// lista.stream().filter(t -> t % 2 == 0).forEach(System.out::println);
		lista.stream()
			.filter(t -> t % 2 == 0) 		// Predicate
			.map(Main::cuadradoNumero)		// Function
			.forEach(System.out::println);	// Consumer
		
		Try.of(() -> {
			int i = 4/2;
			int j = 4/0;
		})
		.onFailure(e -> System.out.println("error!!"))
		.onComplete(n -> System.out.println("Fin!"))
		.tryIt();
	}
	
	// Se le puede llamar como MethodReference ya que funciona como un Function tiene una entrada y una salida
	public static double cuadradoNumero (Integer numero) {
		return Math.pow(numero, 2);
	}

	public static Consumer<Integer> getForEach() {
		return new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		};
	}
}

class MiPredicado implements Predicate<Integer> {
	@Override
	public boolean test(Integer t) {
		return t % 2 == 0;
	}
}
