/**
 * Day 0: Mean, Median, and Mode
 * link: https://www.hackerrank.com/challenges/s10-basic-statistics
 * point: 4/4
 */

import java.util.*;

public class Main {
	float median(List<Integer> list) {

		List<Integer> sortedList = new ArrayList<>(list);
		Collections.sort(sortedList);
		int size = sortedList.size();
		if (size % 2 == 1)
			return sortedList.get(size / 2 + 1);
		else
			return (sortedList.get(size / 2 - 1) + sortedList.get(size / 2)) / 2f;
	}

	float mean(List<Integer> list) {
		float sum = list.stream().mapToInt(x -> x).sum();
		return sum / list.size();
	}

	int mode(List<Integer> list) {
		Map<Integer, Integer> frequency = new HashMap<>(list.size());
		for (int a : list) {
			if (frequency.containsKey(a))
				frequency.put(a, frequency.get(a) + 1);
			else
				frequency.put(a, 1);
		}
		int maxFrequency = 0;
		int value = -1;
		for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
			if (maxFrequency < entry.getValue()) {
				maxFrequency = entry.getValue();
				value = entry.getKey();
			} else if (maxFrequency == entry.getValue()) {
				if (value > entry.getKey())
					value = entry.getKey();
			}
		}
		return value;
	}
	void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> list = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			list.add(scanner.nextInt());
		System.out.println(String.format("%.1f", mean(list)));
		System.out.println(String.format("%.1f", median(list)));
		System.out.println(mode(list));
	}

	public static void main(String[] args) {
		new Main().run();
	}
}