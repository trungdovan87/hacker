/**
 cac bo Test:
 10 4 108
 58 4 5286
 758123 4 75800002
 23758123 4 2137580000003
 237008123 4 21300580000003
 32508123 3 342500003
 62508123 3 642500003
 62508123 3 642500003 ???
 62508123 3 612500003 ???
 262508123 3 236112500003
 262508123 3 236002500003
 324 100 56789 ???
 234 100 56789 ?
 789 100 23456 ?
 1234 100 2156789 ?
 1789 100 100456 ?
 40001789 100 6000000456
 3001789 100 300000456  need
 */

import java.util.*;

class Main {
	String n,x;
	int k;
	int[] a;

	void input() {
		Scanner scanner = new Scanner(System.in);
		n = '0' + scanner.next();
		k = scanner.nextInt();
		x = '0' + scanner.next();

//		n = scanner.next();
//		k = scanner.nextInt();
//		x = scanner.next();
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
			// kiem tra xem co so tmp nao ma n[i] = a[tmp] khong
			for (int tmp = j; tmp < k; tmp++)
				if (n.charAt(i) == x.charAt(tmp)) {
					a[tmp] = i;
					for (int linhtinh = j; linhtinh < tmp; linhtinh++) {
						a[linhtinh] = -2;
					}
					i = i + 1;
					j = tmp + 1;
					isContinue = true;
					break;
				}
			if (isContinue)
				continue;
			// xu ly khi 2 xau con lai co do dai bang nhau
			if (n.charAt(i) < x.charAt(k)) {
				// neu n[i..] < x[k..]
				a[k] = i;
				// a[tmp] = -2 thi kq[tmp] = n[tmp]
				for (int tmp = i; tmp <= k -1; tmp++)
					a[tmp] = -2;
				for (int tmp = k + 1; tmp < x.length(); tmp++)
					a[tmp] = tmp - k + i;
				return;
			}

			if (n.charAt(i) == x.charAt(k)) {
				//neu n[i] = x[k]
				if (compareLastDigit(i + 1, k + 1) <= 0) {
					// xau N[i+1 ...] <= xau X[k+1 ..]
					for (int tmp = k + 1; tmp < x.length(); tmp++)
						a[tmp] = tmp - k + i;
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

	void output() {
		int[] kq = new int[x.length()];
		int i;

		if (debug) {
			for (i = 0; i < a.length; i++)
				System.out.println(a[i]);
			System.out.println("--------------");
		}

		// khoi tao kq[i] = -1
		for (i = 0; i < a.length; i++)
			kq[i] = -1;

		// xu ly cac so -1 o cuoi cung, kq[i] = a[i] neu a[i] = -1 o
		for (i = kq.length - 1; i >= 0; i--) {
			if (a[i] == -1)
				kq[i] = x.charAt(i) - '0';
			else
				break;
		}
		// bat dau tu cuoi voi so khac -1
		for (; i >= 0; i--) {
			if (a[i] >= 0) {
				// neu a[i] >= 0 thi dung n
				kq[i] = n.charAt(a[i]) - '0';
			} else if (a[i] == -2) {
				//a[i] = -2 thi dung x
				kq[i] = x.charAt(i) - '0';
			} else if (a[i] == -1) {
				//neu a[i] = -1, phai xu ly
				int j = i;

				// tim j gan nhat : a[j] != -1
				while (a[j] == -1) {
					j--;
				}
				// kiem tra xem x[j+1 -> i-1] == 0 khong
				boolean isZero = true;
				for (int linhtinh = j + 1; linhtinh <= i; linhtinh++) {
					if (x.charAt(linhtinh) - '0' != 0)
						isZero = false;
				}

				// neu tu x[j + 1 -> i - 1] == 0 het
				if (isZero) {
					if (x.charAt(j) > '0') {
						// neu x[j] > 0
						kq[i] = x.charAt(j) - '0';
						for (int linh = i - 1; linh >= j + 1; linh--) {
							kq[linh] = 9;
						}
						kq[j] = x.charAt(j) - '0' - 1;
						if (kq[j] < 0)
							throw new RuntimeException("kq[j] can not < 0, j = " + j + ", kq[j] = " + kq[j]);
					} else {
						// neu kq[j] = 0
						// tim l dau tien sao cho x[l] != 0
						int linhtinh = j - 1;
						// tim linhtinh dau tien sau cho x[linhtinh] > 0
						for (;  linhtinh >= 0; linhtinh --)
							if (x.charAt(linhtinh) > '0')
								break;
						for (int tmp = i; tmp >= (i - j + linhtinh + 1); tmp--)
							kq[tmp] = 0;
						kq[i - j + linhtinh] = x.charAt(linhtinh) - '0';
						for (int tmp = i - j + linhtinh - 1; tmp >= (linhtinh + 1); tmp--)
							kq[tmp] = 9;
						kq[linhtinh] = x.charAt(linhtinh) - '1';
						j = linhtinh;
					}
				} else {
					//if not zero, lay xau do - 1,
					for (int linhtinh = i; linhtinh >= j + 1; linhtinh--) {
						if (x.charAt(linhtinh) == '0')
							//gan tat ca so 0 cuoi = 9
							kq[linhtinh] = 9;
						else {
							// lay sau dau tien != 0, de tru di 1
							kq[linhtinh] = x.charAt(linhtinh) - '1';
							//giu nguyen doan con lai
							for (int tmp = linhtinh - 1; tmp >= j + 1; tmp--) {
								kq[tmp] = x.charAt(tmp) - '0';
							}
							break;
						}
					}
				}
				i = j;
			}
		}

		i = 1;
		while (kq[i] == 0)
			i++;

		for (; i < a.length; i++) {
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

	static boolean debug = false;
	public static void main(String args[]) throws Exception {
		new Main().run();
	}
}
