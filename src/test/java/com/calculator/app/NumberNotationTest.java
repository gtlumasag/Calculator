package com.calculator.app;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.calculator.app.models.NumberNotation;

public class NumberNotationTest {

	@Test
	public void testGetNumber() {
		NumberNotation number = new NumberNotation(new BigDecimal(10));
		assertEquals(new BigDecimal(10), number.getNumber());
		NumberNotation number2 = new NumberNotation(new BigDecimal(10.1234567890123456));
		assertEquals(new BigDecimal(10.1234567890123456).setScale(15, BigDecimal.ROUND_HALF_DOWN), number2.getNumber());
	}

}
