/**
 * Stacks: Balanced Brackets
 * https://www.hackerrank.com/challenges/ctci-balanced-brackets
 * point: 19/19
 */

import java.util.*;

public class Main {


	boolean isOpenCharater(char ch) {
		return ((ch == '(') || (ch == '[') || (ch == '{'));
	}

	char getOpenCharacter(char ch) {
		if (ch == ')')
			return '(';
		if (ch == ']')
			return '[';
		if (ch == '}')
			return '{';
		return 0;
	}

	public boolean isBalanced(String expression) {
		Deque<Character> stack = new ArrayDeque<>(expression.length());
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (isOpenCharater(ch)) {
				stack.addLast(ch);
			} else {
				if (stack.isEmpty())
					return false;
				else if (stack.pollLast() != getOpenCharacter(ch))
					return false;
			}
		}
		return stack.isEmpty();
	}

	void run() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
		}
	}


	public static void main(String args[]) throws Exception {
		new Main().run();
	}
}
