/**
 * Day 2: Operators
 * link: https://www.hackerrank.com/challenges/30-operators
 * point: 4/4
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double mealCost = scan.nextDouble(); // original meal price
		int tipPercent = scan.nextInt(); // tip percentage
		int taxPercent = scan.nextInt(); // tax percentage
		scan.close();

		int totalCost = (int) Math.round( mealCost * (100 + tipPercent + taxPercent) / 100d );
		System.out.println(String.format("The total meal cost is %d dollars.",totalCost));

	}
}
