package com.calculator.app;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.calculator.app.models.Notation;
import com.calculator.app.models.NumberNotation;

public class NotationTest {

	@Test
	public void testIsNumber() {
		Notation notation = new Notation("5");
		assertTrue(notation.isNumber());
	}

	@Test
	public void testIsCalculateOperator() {
		Notation notation = new Notation("*");
		assertTrue(notation.isCalculateOperator());
	}

	@Test
	public void testIsClearOperator() {
		Notation notation = new Notation("clear");
		assertTrue(notation.isClearOperator());
	}

	@Test
	public void testIsUndoOperator() {
		Notation notation = new Notation("undo");
		assertTrue(notation.isUndoOperator());
	}

	@Test
	public void testIsSqrtOperator() {
		Notation notation = new Notation("sqrt");
		assertTrue(notation.isSqrtOperator());
	}

	@Test
	public void testSqrt() {
		Notation notation = new Notation("sqrt");
		NumberNotation number = new NumberNotation("9");
		assertEquals(new BigDecimal(3), notation.sqrt(number));
	}

	@Test
	public void testCalculate() {
		Notation notation = new Notation("+");
		assertEquals(new BigDecimal(2), notation.calculate(new BigDecimal(1), new BigDecimal(1)));
		Notation notation2 = new Notation("-");
		assertEquals(new BigDecimal(3), notation2.calculate(new BigDecimal(5), new BigDecimal(2)));
		Notation notation3 = new Notation("*");
		assertEquals(new BigDecimal(10), notation3.calculate(new BigDecimal(5), new BigDecimal(2)));
		Notation notation4 = new Notation("/");
		assertEquals(new BigDecimal(5), notation4.calculate(new BigDecimal(10), new BigDecimal(2)));
	}

}
