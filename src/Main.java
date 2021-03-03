import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
                String decryptedPlaintext = aesCbc.decryptAes256(cipherText, iv, secretKey);

                System.out.println("Ciphertext: " + cipherText);
                System.out.println("Decrypted Plaintext: " + decryptedPlaintext);
                System.out.println();

                String propagatedCipher = aesCbc.stringErrorPropagation(cipherText);
                propagatedCipher = StringUtil.hexToString(propagatedCipher);
                String propagatedPlaintext = aesCbc.decryptAes256(propagatedCipher, iv, secretKey);

                System.out.println();
                System.out.println("Original Plaintext Hex: " + StringUtil.stringToHex(decryptedPlaintext));
                System.out.println("Propagated Plaintext Hex: " + StringUtil.stringToHex(propagatedPlaintext));

                break;
            default:
                System.out.println("Incorrect mode");
        }
    }
}
