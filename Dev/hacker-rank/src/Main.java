import java.util.*;

class Main {
	String n,x;
	int k;
	int[] a;

	void input() {
		Scanner scanner = new Scanner(System.in);
		n = scanner.next();
		k = scanner.nextInt();
		x = scanner.next();
	}

	void init() {
		a = new int[x.length()];
		for (int i = 0 ; i < a.length; i++)
			a[i] = -1;
	}

	int compareLastDigit(int fromN, int fromX) {
		if (n.length() - fromN != x.length() - fromX)
			throw new RuntimeException("wrong fromN, fromX: " + fromN + " - " + fromX);
		int length = n.length() - fromN;

		for (int i = 0; i < length; i++) {
			int a = n.charAt(fromN + i);
			int b = x.charAt(fromX + i);
			if (a < b)
				return -1;
			if (a > b)
				return 1;
		}
		return 0;
	}

	void cutTail(int fromN, int fromX){
		if (n.length() - fromN != x.length() - fromX)
			throw new RuntimeException("cutTail: wrong fromN, fromX: " + fromN + " - " + fromX);

		int length = n.length() - fromN;

		for (int i = 0; i < length; i++) {
			a[fromX + i] = fromN + i;
		}
	}

	void solution() {

		int i = 0;
		int j = 0;

		while (true) {
			if (i >= n.length() || j >= x.length())
				return;
			int k = x.length() - n.length() + i;
			boolean isContinue = false;
			for (int tmp = j; tmp < k; tmp++)
				if (n.charAt(i) == x.charAt(tmp)) {
					a[tmp] = i;
					for (int linhtinh = j; linhtinh < tmp; linhtinh++) {
						a[linhtinh] = -2;
					}
					//recursive(i + 1, tmp + 1);
					i = i + 1;
					j = tmp + 1;
					isContinue = true;
					break;
				}
			if (isContinue)
				continue;
			// 2 xau con lai co do dai bang nhau
			if (n.charAt(i) < x.charAt(k)) {
				// neu n[i..] < x[k..]
				a[k] = i;
				for (int tmp = k + 1; tmp < n.length(); tmp++)
					a[tmp] = tmp;
				return;
			}

			if (n.charAt(i) == x.charAt(k)) {
				if (compareLastDigit(i + 1, k + 1) <= 0) {
					// xau N <= xau X
					for (int tmp = k + 1; tmp < n.length(); tmp++)
						a[tmp] = tmp;
					return;
				} else { // neu no lon hon, xu ly giong ben duoi
					cutTail(i, k);
					return;
				}
			}
			if (n.charAt(i) > x.charAt(k)) {
				cutTail(i, k);
				return;
			}
		}
	}

//	void recursive(int i, int j) {
//		int k = x.length() - n.length() + i;
//
//		if (i >= n.length() || j >= x.length())
//			return;
//		for (int tmp = j; tmp < k; tmp++)
//			if (n.charAt(i) == x.charAt(tmp)) {
//				a[tmp] = i;
//				for (int linhtinh = j; linhtinh < tmp; linhtinh++) {
//					a[linhtinh] = -2;
//				}
//				recursive(i + 1, tmp + 1);
//				return;
//			}
//
//		// 2 xau con lai co do dai bang nhau
//		if (n.charAt(i) < x.charAt(k)) {
//			// neu n[i] < x[k]
//			a[k] = i;
//			for (int tmp = k + 1; tmp < n.length(); tmp++)
//				a[tmp] = tmp;
//			return;
//		}
//
//		if (n.charAt(i) == x.charAt(k)) {
//			if (compareLastDigit(i + 1, k + 1) <= 0) {
//				// xau N <= xau X
//				for (int tmp = k + 1; tmp < n.length(); tmp++)
//					a[tmp] = tmp;
//				return;
//			} else { // neu no lon hon, xu ly giong ben duoi
//				cutTail(i, k);
//				return;
//			}
//		}
//		if (n.charAt(i) > x.charAt(k)) {
//			cutTail(i, k);
//			return;
//		}
//	}

	void output() {
		int[] kq = new int[x.length()];
		int i;

//		for (i = 0; i < a.length; i++)
//			System.out.println(a[i]);
//		System.out.println("--------------");
//		//--------
		for (i = 0; i < a.length; i++) {
			kq[i] = -1;
		}

		for (i = kq.length - 1; i >= 0; i--) {
			kq[i] = -1;
			if (a[i] == -1)
				kq[i] = x.charAt(i) - '0';
			else
				break;
		}
		for (; i >= 0; i--) {
			kq[i] = -1;
			if (a[i] >= 0) {
				kq[i] = n.charAt(a[i]) - '0';
			} else if (a[i] == -2) {
				kq[i] = x.charAt(i) - '0';
			} else if (a[i] == -1) {
				//kq[i] = 9;
				int j = i;
				while (a[j] == -1) {
					j--;
				}
				// neu tu x[j + 1 -> i - 1] == 0 het
				boolean isZero = true;
				for (int linhtinh = j + 1; linhtinh <= i; linhtinh++) {
					if (x.charAt(linhtinh) - '0' != 0)
						isZero = false;
				}

				if (isZero) {
					kq[i] = x.charAt(j) - '0';
					for (int linh = i - 1; linh >= j +1; linh--) {
						kq[linh] = 9;
					}
					kq[j] = x.charAt(j) - '0' - 1;
				} else {
					//if not zero
					for (int linhtinh = i; linhtinh >= j + 1; linhtinh--) {
						if (x.charAt(linhtinh) == '0')
							kq[linhtinh] = 9;
						else {
							kq[linhtinh] = x.charAt(linhtinh) - '1';
							for (int tmp = linhtinh - 1; tmp >- j + 1; tmp--) {
								kq[tmp] = x.charAt(tmp) - '0';
							}
							break;
						}
					}
				}
				i = j;
			}
		}

		for (i = 0; i < a.length; i++) {
			System.out.print(kq[i]);
		}
		System.out.println();

	}

	void process() {
		if (k < x.length() - n.length()) {
			for (int i = 0; i < 1; i++)
				System.out.print(9);
			System.out.println(n);
			return;
		}
		if (x.length() == n.length()) {
			System.out.println(n);
			return;
		}
		init();
		solution();
		output();
	}

	void run() {
		input();
		process();
	}

	public static void main(String args[]) throws Exception {
		new Main().run();
	}
}
