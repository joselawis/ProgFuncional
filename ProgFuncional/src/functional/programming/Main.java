package functional.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import functional.programming.enums.Genero;

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
		
		ejemploPersona();
	}
	
	public static void ejemploPersona() {
		List<Persona> listaPersonas = new ArrayList<Persona>(Arrays.asList(
			new Persona("Juan",Genero.HOMBRE, 24, new ArrayList<String>(Arrays.asList("666123456", "999123456"))),
			new Persona("Pepe",Genero.HOMBRE, 20, new ArrayList<String>(Arrays.asList("980123456", "888123456"))),
			new Persona("Maria",Genero.MUJER, 27, new ArrayList<String>(Arrays.asList("678123456", "777123456"))),
			new Persona("Natalia",Genero.MUJER, 24, new ArrayList<String>(Arrays.asList("690123456")))
			));
		
		
		// Media edad por genero
		Map<Genero, Double> e1 = listaPersonas.stream().collect(Collectors.groupingBy(Persona::getGenero, Collectors.averagingInt(Persona::getEdad)));
		System.out.println(e1);
		// Persona mas vieja
		listaPersonas.stream().max(Comparator.comparing(Persona::getEdad)).ifPresent(p -> System.out.println(p.nombre));
		// Mujer mas joven
		listaPersonas.stream().filter(p->Genero.MUJER == p.getGenero()).min(Comparator.comparing(Persona::getEdad)).ifPresent(p -> System.out.println(p.nombre));
		// Todos los numeros son de red movil?
		boolean isRedMovil = listaPersonas.stream().map(Persona::getTelefonos)
									.flatMap(Collection::stream)
									.map(Object::toString)
									.allMatch(s -> s.startsWith("6") || s.startsWith("7"));
		System.out.println(isRedMovil);
		
		
		// Sumatorio edad con mapToInt
		listaPersonas.stream()  					// tenemos un Stream<Personas>
					.mapToInt(Persona::getEdad)		// Convertimos el Stream<Persona> a Stream<Integer>
					.sum();
		
		// Sumatorio sin mapToInt
		listaPersonas.stream()
					.map(Persona::getEdad)
					//.reduce(0, (acumulado,edad) -> acumulado+edad);		// en cada iteracion al acumulado se le sumara la edad
					.reduce(0, Integer::sum);
		
		// Sumatorio con summaryStatistics
		long suma = listaPersonas.stream()
					.mapToInt(Persona::getEdad)
					.summaryStatistics().getSum();
		
		System.out.println(suma);
		
		// Listar los nombres
		listaPersonas.stream()
					.map(Persona::getNombre)
					.reduce((acc, curr) -> acc + ", "+ curr).ifPresent(System.out::println);
		
		// Otra forma de listar los nombres
		String nombres = listaPersonas.stream()
								.map(Persona::getNombre)
								.collect(Collectors.joining(", "));
		System.out.println(nombres);
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
