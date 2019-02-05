package com.calculator.app;

import java.io.Console;
import java.util.Stack;

import com.calculator.app.models.Notation;
import com.calculator.app.models.NumberNotation;

public class RPNCalculator {



	// ================================================
	// Public Methods
	// ================================================
	public void runCalculator() {

		System.out.println("Welcome to RPN Calculator! Press Ctrl^C to Quit.");

		// Initialize the stack 
		Stack<NumberNotation> numberStack = new Stack<NumberNotation>();

		// Loop until user terminates the application
		while(true) {
			// Prompt the calculator input
			String notations = new String();
			Console console = System.console();
		    if (console==null) {
		        System.out.print("console not available ");
		        break;
		    } else
			    notations = console.readLine("");

			// Split using space and loop through the notation
			String[] stringNotations = notations.split(" ");
			for (int i = 0; i < stringNotations.length; i++ ) {
				// Initialize notation
				Notation notation = new Notation(stringNotations[i]);
				// Distinguish the notation
				if (notation.isNumber())
					numberStack.push(new NumberNotation(notation.getValue()));
				else if(notation.isClearOperator())
					numberStack.clear();
				else if(notation.isUndoOperator()) {
					if (numberStack.isEmpty() == false)
						numberStack.pop();
				} else if(notation.isSqrtOperator()) {
					if (numberStack.isEmpty()) {
						System.out.println(new StringBuilder("operator ").append(stringNotations[i]).append(" (position: ").append(i + i).append("): insufficient parameters.").toString());
						break;
					} else
						numberStack.push(new NumberNotation(notation.sqrt(numberStack.pop())));
				} else if(notation.isCalculateOperator()) {

					// Terminate distinguishing of notation when parameter is insufficient
					if (numberStack.size() < 2) {
						System.out.println(new StringBuilder("operator ").append(stringNotations[i]).append(" (position: ").append(i + 1 + i).append("): insufficient parameters.").toString());
						break;
					}

					// Perform computation
					NumberNotation number1 = numberStack.pop();
					NumberNotation number2 = numberStack.pop();
					numberStack.push(new NumberNotation(notation.calculate(number1.getNumber(), number2.getNumber())));
				}
			}
			// Show console
			StringBuilder stackConsole = new StringBuilder("stack: ");
			for (NumberNotation number : numberStack)
				stackConsole.append(number.getNumber()).append(" ");

			System.out.println(stackConsole.toString());

		}

	}

}
