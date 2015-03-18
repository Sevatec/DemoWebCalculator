package samples.webcalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculationsTest {

	@Test
	public void testAddition() {
		String number1 = "5";
		String number2 = "3";
		assertEquals("8",Calculations.addition(number1, number2));
	}

	@Test
	public void testSubtraction() {
		String number1 = "5";
		String number2 = "3";
		assertEquals("-2",Calculations.subtraction(number1, number2));
	}

	@Test
	public void testMultiplication() {
		String number1 = "5";
		String number2 = "3";
		assertEquals("15",Calculations.multiplication(number1, number2));
	}

	@Test
	public void testDivision() {
		String number1 = "5";
		String number2 = "15";
		assertEquals("3 r 0",Calculations.division(number1, number2));
		String number3 = "3";
		String number4 = "20";
		assertEquals("6 r 2",Calculations.division(number3, number4));
	}

}
