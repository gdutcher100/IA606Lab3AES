import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException {
        Scanner input = new Scanner(System.in);

        System.out.println("Input Plaintext: ");
        String plaintext = input.nextLine();
        System.out.println("Input Opmode: ");
        String opmode = input.nextLine();
        opmode = opmode.toUpperCase();

        SecretKey secretKey = Generator.generateKey(256);
        IvParameterSpec iv = Generator.generateIv();

        switch (opmode){
            case "CBC":
                AES256 aesCbc = new AES256CBC();
                String cipherText = aesCbc.encryptAes256(plaintext, iv, secretKey);
                String cipherTextHex = StringUtil.toHex(cipherText);
                String decryptedPlaintext = aesCbc.decryptAes256(cipherText, iv, secretKey);

                System.out.println("Ciphertext: " + cipherText);
                //System.out.println("Ciphertext Hex: " + cipherTextHex);
                System.out.println("Decrypted Plaintext: " + decryptedPlaintext);

                //String propagatedCipher = aesCbc.stringErrorPropagation(cipherText);
                //System.out.println(propagatedCipher);
                //propagatedCipher = StringUtil.stringToHex(propagatedCipher);
                //System.out.println(propagatedCipher);
                //String propagatedPlaintext = aesCbc.decryptAes256(propagatedCipher, iv, secretKey);

                //System.out.println("Propagated Plaintext: " + propagatedPlaintext);

                break;
            default:
                System.out.println("Incorrect mode");
        }
    }
}
