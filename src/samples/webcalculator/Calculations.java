package samples.webcalculator;

public final class Calculations {
	private Calculations(){
		
	}
	
	public static String addition(String currentNumber, String storedNumber){
		Integer addedNumber = null;
		addedNumber = (Integer.parseInt(storedNumber) + Integer.parseInt(currentNumber));
		return addedNumber.toString();
	}
	
	public static String subtraction(String currentNumber, String storedNumber){
		Integer subtractedNumber = null;
		subtractedNumber = (Integer.parseInt(storedNumber) - Integer.parseInt(currentNumber));
		return subtractedNumber.toString();
	}
	
	public static String multiplication(String currentNumber, String storedNumber){
		Integer multipliedNumber = null;
		multipliedNumber = (Integer.parseInt(storedNumber) * Integer.parseInt(currentNumber));
		return multipliedNumber.toString();
	}
	
	public static String division(String currentNumber, String storedNumber){
		Integer dividedNumber = null;
		Integer remainderNumber = null;
		String entireResult = "";
		dividedNumber = (Integer.parseInt(storedNumber) / Integer.parseInt(currentNumber));
		remainderNumber = (Integer.parseInt(storedNumber) % Integer.parseInt(currentNumber));
		entireResult = dividedNumber.toString() + " r " + remainderNumber.toString();
		return entireResult;
	}
	
	public static String divideBy1(String currentNumber, String storedNumber){
		//THERE IS NO REASON TO EVER DO THIS! 
		//IT'S TO TEST FINDBUGS
		Integer dividedNumber = null;
		Integer remainderNumber = null;
		String entireResult = "";
		dividedNumber = (Integer.parseInt(storedNumber) / 1);
		remainderNumber = (Integer.parseInt(storedNumber) % 1);
		entireResult = dividedNumber.toString() + " r " + remainderNumber.toString();
		return entireResult;
	}
}
