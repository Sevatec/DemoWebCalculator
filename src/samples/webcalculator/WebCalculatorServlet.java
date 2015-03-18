package samples.webcalculator;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebCalculatorServlet extends HttpServlet implements Servlet {
	String newNumber = "0";
	String currentNumber = "0";
	String storedNumber = "0";
	String operator;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		//Get the number in the input text box
		setNewNumber(request.getParameter("number"));
		
		//Get the number that was previously in the input text box
		setCurrentNumber((String)request.getSession(true).getAttribute("currentnumber"));
		setStoredNumber((String)request.getSession(true).getAttribute("storednumber"));
		setOperator((String)request.getSession(true).getAttribute("operator"));
		
		if(currentNumber == null){
			setCurrentNumber("0");
		}
		
		//Determine which button was pressed
		String action = request.getParameter("action");
		
		if(operator != null && operator.equals("=")){
			setCurrentNumber("0");
			request.getSession().setAttribute("operator", null);
		}
		
		if(action.equals("1") || action.equals("2") || action.equals("3") || action.equals("4") ||
				action.equals("5") || action.equals("6") || action.equals("7") ||
				action.equals("8") || action.equals("9") || action.equals("0") ) {
			this.appendDigit(action);
		}
		
		else if(action.equals("Clear")){
			/*setCurrentNumber("");
			setNewNumber("");
			request.getSession().setAttribute("storednumber", null);
			request.getSession().setAttribute("operator", null);*/
			this.reset(request);
		}
		else if(action.equals(("+"))){
			//Perform previously selected operation
			if(operator != null && operator.equals("+"))
				setCurrentNumber(Calculations.addition(currentNumber, storedNumber));
			
			//Set new Stored Value
			request.getSession().setAttribute("storednumber", currentNumber);
			
			//Set new Operation
			request.getSession().setAttribute("operator", "+");
			setCurrentNumber("0");
		}
		else if(action.equals(("-"))){
			//Perform previously selected operation
			if(operator != null && operator.equals("+"))
				setCurrentNumber(Calculations.addition(currentNumber, storedNumber));
			
			//Set new Stored Value
			request.getSession().setAttribute("storednumber", currentNumber);
			
			//Set new Operation
			request.getSession().setAttribute("operator", "-");
			setCurrentNumber("0");
		}
		else if(action.equals(("x"))){
			//Perform previously selected operation
			if(operator != null && operator.equals("+"))
				setCurrentNumber(Calculations.addition(currentNumber, storedNumber));
			
			//Set new Stored Value
			request.getSession().setAttribute("storednumber", currentNumber);
			
			//Set new Operation
			request.getSession().setAttribute("operator", "x");
			setCurrentNumber("0");
		}
		else if(action.equals(("/"))){
			//Perform previously selected operation
			if(operator != null && operator.equals("+"))
				setCurrentNumber(Calculations.addition(currentNumber, storedNumber));
			
			//Set new Stored Value
			request.getSession().setAttribute("storednumber", currentNumber);
			
			//Set new Operation
			request.getSession().setAttribute("operator", "/");
			setCurrentNumber("0");
		}
		
		else if(action.equals(("="))){
			//Perform previously selected operation
			if(operator != null && operator.equals("+"))
				currentNumber = Calculations.addition(currentNumber, storedNumber);
			/*else if(operator != null && operator.equals("-"))
				currentNumber = Calculations.subtraction(currentNumber, storedNumber);*/
			else if(operator != null && operator.equals("x"))
				currentNumber = Calculations.multiplication(currentNumber, storedNumber);
			else if(operator != null && operator.equals("/"))
				currentNumber = Calculations.division(currentNumber, storedNumber);
			//Set new Stored Value
			//storedNumber = "0";
			request.getSession().setAttribute("storednumber", null);
			//Set new Operation
			request.getSession().setAttribute("operator", "=");
		}
		
		//currentNumber = currentNumber.replaceFirst("^0+(?!$)", "");
		setCurrentNumber(this.removeLeadingZeros(currentNumber));
		request.setAttribute("InputNewNumber", currentNumber);
		
		request.getSession().setAttribute("currentnumber", currentNumber);
		getServletContext().getRequestDispatcher("/WebCalculator.jsp").forward(request, response);
	}
	
	protected void appendDigit(String action){
		this.setNewNumber(action);
		this.setCurrentNumber(getCurrentNumber().concat(getNewNumber()));
	}

	protected void reset(HttpServletRequest request){
		setCurrentNumber("0");
		setNewNumber("0");
		request.getSession().setAttribute("storednumber", null);
		request.getSession().setAttribute("operator", null);
	}
	
	protected String removeLeadingZeros(String number){
		return number.replaceFirst("^0+(?!$)", "");
	}
	
	public String getNewNumber() {
		return newNumber;
	}

	public void setNewNumber(String newNumber) {
		this.newNumber = newNumber;
	}

	public String getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(String currentNumber) {
		this.currentNumber = currentNumber;
	}

	public String getStoredNumber() {
		return storedNumber;
	}

	public void setStoredNumber(String storedNumber) {
		this.storedNumber = storedNumber;
	}
	
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}
