import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Random;

public class StringUtil {
    public static String stringToHex(String arg) throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer();
        //Converting string to character array
        char ch[] = arg.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            String hexString = Integer.toHexString(ch[i]);
            sb.append(hexString);
        }

        return sb.toString();
    }

    public static String hexToString(String arg) {
        String result = new String();
        char[] charArray = arg.toCharArray();
        for(int i = 0; i < charArray.length; i=i+2) {
            String st = ""+charArray[i]+""+charArray[i+1];
            char ch = (char)Integer.parseInt(st, 16);
            result = result + ch;
        }

        return result;
    }

    public static String charToHex(char arg) {
        return Integer.toHexString((int) arg);
    }

    public static String replaceRandomCharInHexString(String s)
    {
        Random r = new Random();
        char[] characters = s.toCharArray();
        int rand = (int)(Math.random() * s.length() - 2);
        int offset = 0;
        if (rand % 2 == 1) {
            offset = 1;
        }

        String randomHex = charToHex((char)(r.nextInt(26) + 'a'));

        char selectedChar1 = characters[rand + offset];
        char selectedChar2 = characters[rand + offset + 1];
        characters[rand + offset] = randomHex.toCharArray()[0];
        characters[rand + offset + 1] = randomHex.toCharArray()[1];

        System.out.println("Modifying random byte: " + selectedChar1 + selectedChar2 + "->" + randomHex);

        return new String(characters);
    }
}
