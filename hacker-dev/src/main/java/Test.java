/**
 * Day 0: Weighted Mean
 * link:https://www.hackerrank.com/challenges/s10-weighted-mean
 * point: 4/4
 */

import java.io.FileWriter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
	long hoanvi(long l) {
		long dv = l % 10;
		long chuc = l / 10;
		int mu = String.valueOf(l).length() - 1;
		long nhan = 1;
		for (int tmp = 0; tmp < mu; tmp++) {
			nhan *= 10;
		}
		return dv * nhan + chuc;
	}

	boolean check(long l) {
		return (hoanvi(l) % l == 0);
	}

	boolean firsDigitLarger5(String s) {
		return (s.charAt(0) - '0') >= 5;
	}

	boolean isRepeated(String s) {
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(0) != s.charAt(i))
				return false;
		}
		return true;
	}

	void writeLineToFile(String filename, String l) {
		try {
			FileWriter fw = new FileWriter(filename, true); //the true will append the new data
			fw.write(l + "\n");//appends the string to the file
			fw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	long process(int n) {
		long nhan = 1;
		for (int tmp = 0; tmp < n; tmp++) {
			nhan *= 10;
		}
		long result = 0;
		for (long i = 10; i < nhan; i++) {
			if (check(i))
				result = ((result + i) % 100000);
		}
		return result;
	}

	long l;

	void run() {
//		System.out.println(hoanvi(12340));
//		System.out.println(check(11));
//		System.out.println(check(12));
//		System.out.println(check(142857));
//		System.out.println(check(1428578));
		long min = (long) Math.pow(10, 1);
		long max = (long) Math.pow(10, 10);
		min = 790922193102l;
		max = Long.MAX_VALUE;

		//11

		ScheduledExecutorService scheduler =
				Executors.newScheduledThreadPool(2);
		scheduler.scheduleWithFixedDelay(() -> writeLineToFile("i.txt", "i: " + l), 0, 15, TimeUnit.MINUTES);

		l = min;
		while (l <= max) {
			String s = String.valueOf(l);
			if (s.charAt(0) >= '5') {
				StringBuilder next = new StringBuilder("1");
				for (int i = 0; i < s.length(); i++)
					next.append('0');
				l = Long.valueOf(next.toString());
			} else {
				if (check(l)) {
					boolean repeated = true;
					for (int i = 1; i < s.length(); i++) {
						if (s.charAt(0) != s.charAt(i)) {
							repeated = false;
							break;
						}
					}
					if (!repeated) {
						System.out.println(l);
						writeLineToFile("number.txt", String.valueOf(l));
					}
				}
				l++;
			}
		}
		System.exit(0);
	}

	public static void main(String[] args) throws Exception {
		new Test().run();
	}
}