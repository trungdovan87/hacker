/*
give number X in base (-2)
calculate number in base (-2) ceil(X/2)
ex:
- if A = [1, 0, 0, 1, 1, 1] => X = -23 => return [1, 0, 1, 0, 1, 1] ( ceil(X/2) = -11)
- if A = [1, 0, 0, 1, 1] => X = 9 => return [1, 0, 1] ( ceil(X/2) = 5)
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ZERO;

public class BaseMinus2 {
    class Result {
        BigInteger div;
        int mod;

        Result(BigInteger div, int mod) {
            this.div = div;
            this.mod = mod;
        }
    }

    public final BigInteger BASE_BIG = new BigInteger("-2");
    public final BigInteger TWO = new BigInteger("2");

    public Result div2(BigInteger a) {
        BigInteger div = a.divide(TWO);
        int mod = a.mod(TWO).intValue();
        if (mod == 0 || div.compareTo(ZERO) > 0) {
            return new Result(div, mod);
        } else {
            return new Result(div.subtract(BigInteger.ONE), mod);
        }
    }

    public BigInteger reverse(BigInteger a) {
        return ZERO.subtract(a);
    }

    public Result divBase(BigInteger a) {
        if (a.compareTo(ZERO) > 0) {
            return new Result(reverse(a.divide(TWO)), a.mod(TWO).intValue());
        } else if (a.compareTo(ZERO) < 0) {
            Result result =  div2(a);
            return new Result(reverse(result.div), result.mod);
        }
        return new Result(ZERO, 0);
    }

    public BigInteger ceil(BigInteger a) {
        Result result = div2(a);
        if (result.mod > 0) {
            return result.div.add(BigInteger.ONE);
        }
        return result.div;
    }

    public BigInteger convertToDec(int[] A) {
        BigInteger exp = BigInteger.ONE;
        BigInteger result = ZERO;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                result = result.add(exp);
            }
            exp = exp.multiply(BASE_BIG);
        }
        return result;
    }

    public int[] convertToBinary(BigInteger a) {
        List<Integer> list = new ArrayList<>();

        while (a.compareTo(ZERO) != 0) {
            Result result = divBase(a);
            list.add(result.mod);
            a = result.div;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int[] solution(int[] A) {
        BigInteger a = convertToDec(A);
        BigInteger b = ceil(a);
        return convertToBinary(b);
    }

    public String print(int[] a) {
        String s = "";
        for (int i : a) {
            s += i;
        }
        return s;
    }

    public void run() {
        int[] a = new int[] {1, 0, 0, 1, 1, 1};
        System.out.println(print(solution(a)));

        a = new int[] {};
        System.out.println(print(solution(a)));

        a = new int[] {1, 0, 0, 1, 1};
        System.out.println(print(solution(a)));
    }

    public static void main(String[] args) {
        new BaseMinus2().run();
    }
}
