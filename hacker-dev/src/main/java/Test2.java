/**
 * Created by trungdovan on 12/29/16.
 */
public class Test2 {
	static void process(int n) {
		System.out.println("n : " + n);
		int m = new Main().process(n);
		long t = new Test().process(n);
		System.out.println( m == t);
		System.out.println("main: " + m);
		System.out.println("test: " + t);
		System.out.println("-------------");
	}
	public static void main(String[] args) {
//		for (int i = 2; i <= 10; i++)
//			process(i);
		process(10);

		//System.out.println("kaka 222 a322");
	}
}
