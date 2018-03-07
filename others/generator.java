import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class Main {
    static boolean debug = false;


    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input text: ");
        String originalString = scanner.next();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                originalString.getBytes(StandardCharsets.UTF_8));
        String hash = bytesToHex(encodedhash);
        System.out.println("Hash: " + hash);
        String s = Base64.getEncoder().encodeToString(encodedhash);
        System.out.println("Encode: " + s);

        List<Integer> list =  new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(charToInt(s.charAt(i)));
        }
        System.out.print("convert : ");
        list.forEach(integer -> System.out.print(integer + ", "));
        System.out.println();
        System.out.println();


        System.out.println("====================");
        System.out.println("====================");
        System.out.println("Mega 6/45");
        quay(list, 45);
        System.out.println("====================");
        System.out.println("====================");
        System.out.println("Power 6/55");
        quay(list, 55);
    }

    private static void quay(List<Integer> list, int n) {
        System.out.println("------BEGIN -----");
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int i : list) {
            if (i > 0 && i <= n) {
                if (Collections.frequency(result, i) == 0) {
                    result.add(i);
                    if (result.size() == 6) {
                        Collections.sort(result);
                        count++;
                        System.out.println("*** bo so " + count + ": ");
                        result.forEach(integer -> System.out.print(integer + ", "));
                        System.out.println();
                        System.out.println();
                        result.clear();
                    }
                }
            }
        }
        System.out.println("----- END -----");
    }

    private static int charToInt(char a) {
        if (a >= 'A' && a <= 'Z')
            return a - 'A';
        if (a >= 'a' && a <= 'z')
            return a - 'a' + 26;
        if (a >= '0' && a <= '9')
            return a - '0' + 52;
        if (a == '+')
            return 62;
        if (a == '=')
            return 63;
        return -1;
    }

    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
