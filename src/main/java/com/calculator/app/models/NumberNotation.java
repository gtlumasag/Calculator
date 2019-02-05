package com.calculator.app.models;

import java.math.BigDecimal;

public class NumberNotation {

	// Private variables
	private BigDecimal _number;



	// ================================================
	// Constructors
	// ================================================
	public NumberNotation(String number) {
		_number = new BigDecimal(number);
	}
	
	public NumberNotation(BigDecimal number) {
		_number = number;
	}



	// ================================================
	// Public Methods
	// ================================================
	public BigDecimal getNumber() {
		if (isIntegerValue()) 
			return new BigDecimal(_number.stripTrailingZeros().toPlainString());
		else if (isScaleLessThanEqual15())
			return _number;
		else 
			return _number.setScale(15, BigDecimal.ROUND_HALF_DOWN);
	}

	public void setNumber(BigDecimal number) {
		_number = number;
	}



	// ================================================
	// Private Methods
	// ================================================
	private boolean isIntegerValue() {
		return _number.stripTrailingZeros().scale() <= 0;
	}
	
	private boolean isScaleLessThanEqual15() {
		return _number.scale() <= 15 && _number.scale() > 0;
	}

}
