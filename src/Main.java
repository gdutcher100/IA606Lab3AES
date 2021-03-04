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

        switch (opmode){
            case "CBC":
                AES256 aesCbc = new AES256CBC();
                output(aesCbc, plaintext);

                break;
            case "CFB":
                AES256 aesCfb = new AES256CFB();
                output(aesCfb, plaintext);

                break;
            case "CTR":
                AES256 aesCtr = new AES256CTR();
                output(aesCtr, plaintext);

                break;
            case "OFB":
                AES256 aesOfb = new AES256OFB();
                output(aesOfb, plaintext);

                break;
            case "ECB":
                AES256 aesEcb = new AES256ECB();
                output(aesEcb, plaintext);

                break;
            default:
                System.out.println("Incorrect mode");
        }
    }

    public static void output(AES256 aes, String plaintext) throws NoSuchAlgorithmException, UnsupportedEncodingException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        SecretKey secretKey = Generator.generateKey(256);
        IvParameterSpec iv = Generator.generateIv();
        String cipherText;
        String decryptedPlaintext;
        String propagatedCipher;
        String propagatedPlaintext;

        cipherText = aes.encryptAes256(plaintext, iv, secretKey);
        decryptedPlaintext = aes.decryptAes256(cipherText, iv, secretKey);

        System.out.println("Ciphertext: " + cipherText);
        System.out.println("Decrypted Plaintext: " + decryptedPlaintext);
        System.out.println();

        propagatedCipher = aes.stringErrorPropagation(cipherText);
        propagatedCipher = StringUtil.hexToString(propagatedCipher);
        propagatedPlaintext = aes.decryptAes256(propagatedCipher, iv, secretKey);

        System.out.println();
        System.out.println("Original Plaintext Hex: " + StringUtil.stringToHex(decryptedPlaintext));
        System.out.println("Propagated Plaintext Hex: " + StringUtil.stringToHex(propagatedPlaintext));
    }
}
