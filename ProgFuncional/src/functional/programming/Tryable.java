package functional.programming;

// Interfaz funcional
@FunctionalInterface
public interface Tryable {
	// Un unico metodo abstracto
	void tryIt() throws Exception;
}
