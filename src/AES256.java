import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Base64;

public interface AES256 {
    /*
        Encrypts plaintext hex
    */
    public String encryptAes256(String plaintext, IvParameterSpec iv, SecretKey key) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException;

    /*
        Decrypts ciphertext
    */
    public String decryptAes256(String cipherText, IvParameterSpec iv, SecretKey key) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException;

    /*
        Takes in a ciphertext and modifies a random byte
     */
    public String stringErrorPropagation(String ciphertext) throws UnsupportedEncodingException;
}
