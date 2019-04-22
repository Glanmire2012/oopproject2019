package dataentry;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputData {
	Scanner scan = new Scanner(System.in);
	public int selectionInt() {// input validation for ints

		int selection = 0;
		boolean test = false;
		while (test == false) {
			try {
				selection = scan.nextInt();
				test = true;
			}
			catch (InputMismatchException e) {// Catches input mismatch exceptions, and gives the user another go
				System.out.println("Error! Please use only numbers for your selection!");
				scan.next();
				continue;
			}
			
			}
		return selection;
	}
	public String input() {// input validation for Strings

		String input = null;
		boolean test = false;
		while (test == false) {
			try {
				input = scan.next();
				test = true;
			}
			catch (InputMismatchException e) {// Catches input mismatch exceptions, and gives the user another go
				System.out.println("Error! Please use only numbers for your selection!");
				scan.next();
				continue;
			}
			
			}
		return input;
	}
	public double phoneInput() {// input validation for doubles
		double input = 0;
		boolean test = false;
		while (test == false) {
			try {
				input = scan.nextDouble();
				test = true;
			}
			catch (InputMismatchException e) {// Catches input mismatch exceptions, and gives the user another go
				System.out.println("Error! Please use only numbers for your selection!");
				scan.next();
				continue;
			}
			
			}
		return input;
	}
}
