import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

public class AES256ECB implements AES256 {
    @Override
    public String encryptAes256(String plaintext, IvParameterSpec iv, SecretKey key)
            throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        return null;
    }

    @Override
    public String decryptAes256(String cipherText, IvParameterSpec iv, SecretKey key)
            throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        return null;
    }

    @Override
    public String stringErrorPropagation(String ciphertext) {
        return null;
    }
}
