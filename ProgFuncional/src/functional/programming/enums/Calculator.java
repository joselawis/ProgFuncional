package functional.programming.enums;

import java.util.function.BiFunction;

// Ejemplo de enum con functions lambda
public enum Calculator implements BiFunction<Double, Double, Double>{
	PLUS    ("+", (l, r) -> l + r),
    MINUS   ("-", (l, r) -> l - r),
    MULTIPLY("*", (l, r) -> l * r),
    DIVIDE  ("/", (l, r) -> l / r);

	private final String symbol;
    private final BiFunction<Double, Double, Double> binaryFunction;

    private Calculator(final String symbol, final BiFunction<Double, Double, Double> binaryFunction) {
        this.symbol = symbol;
        this.binaryFunction = binaryFunction;
    }

    public String getSymbol() {
        return symbol;
    }
    
    // Metodo a implementar del tipo (T,T)->T
	@Override
	public Double apply(Double t, Double u) {
		return binaryFunction.apply(t, u);
	}
}
