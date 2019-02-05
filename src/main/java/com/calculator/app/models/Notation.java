package com.calculator.app.models;

import java.math.BigDecimal;

public class Notation {

	// Private variables
	private String _value;



	// ================================================
	// Constructor
	// ================================================
	public Notation(String value) {
		_value = value;
	}



	// ================================================
	// Public Methods
	// ================================================
	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public boolean isNumber() {
		try {
			new BigDecimal(getValue());
			return true;
		} catch (NumberFormatException e) {
			return false;
		} 
	}

	public boolean isCalculateOperator() {
		String notation = getValue();
		return notation.equals("+") || notation.equals("-") 
				|| notation.equals("*") || notation.equals("/");
	}

	public boolean isClearOperator() {
		return getValue().equals("clear");
	}

	public boolean isUndoOperator() {
		return getValue().equals("undo");
	}

	public boolean isSqrtOperator() {
		return getValue().equals("sqrt");
	}

	public BigDecimal sqrt(NumberNotation number1) {
		return new BigDecimal(Math.sqrt(number1.getNumber().doubleValue()));
	}

	public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
		switch(this.getValue()) {
			case "+" : 
				return number1.add(number2);
			case "-" :
				return number1.subtract(number2);
			case "*" :
				return number1.multiply(number2);
			case "/" :
				return number1.divide(number2);
			default:
				throw new IllegalArgumentException("Invalid Operator");
		}
	}

}
