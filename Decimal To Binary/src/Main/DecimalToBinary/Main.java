package Main.DecimalToBinary;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		
		//gets your number
		int number;
		
		//scans the text in console
		Scanner in = new Scanner(System.in);
		
		//asked for a posivite int and gets the number
		System.out.println("Enter A Positive Int");
		number = in.nextInt();
		
		//if the number is < than zero then it displays its not a positive int
		if(number < 0){
			System.out.println("Thats not a POSITIVTE Int");
		}else{
			/*
			 * if the number is else( number > 0) it tells you the number converted to binary
			 * by accessing the printBinary void 
			 */
			System.out.println(number + " Converted to binary is : ");
			printBinary(number);
		}
	}
	
	public static void printBinary(int number){
		int remainder;
		
		//if number is greater than 1 then print the number
		if(number <= 1){
			System.out.print(number);
			return;
		}
		
		//sets the remainder to %2 of number and prints the number as binary
		remainder = number %2;
		printBinary(number >> 1);
		System.out.print(remainder);
	}

}
//Dan Warman