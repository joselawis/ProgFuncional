package functional.programming.enums;

import functional.programming.functions.CustomBinaryFunction;

// Ejemplo de enum con functions lambda
public enum Calculator implements CustomBinaryFunction {
	PLUS    ("+", (l, r) -> l + r),
    MINUS   ("-", (l, r) -> l - r),
    MULTIPLY("*", (l, r) -> l * r),
    DIVIDE  ("/", (l, r) -> l / r),
    POW 	("^", (l, r) -> Math.pow(l, r));

	private final String symbol;
	private final CustomBinaryFunction biFunction;

	private Calculator(final String symbol, final CustomBinaryFunction biFunction) {
		this.symbol = symbol;
		this.biFunction = biFunction;
	}

	public String getSymbol() {
		return symbol;
	}

	@Override
	public double apply(double l, double r) {
		return biFunction.apply(l, r);
	}
	
	public double apply(double l) {
		return biFunction.apply(l, l);
	}
}
