package ch.zmotions.linkit.service.util.auth;

import ch.zmotions.linkit.config.properties.AuthProperties;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AESEncryptorDecryptorTest {
    private AuthProperties authProperties;

    @Before
    public void setup() {
        authProperties = new AuthProperties();
        authProperties.setKey("test");
        authProperties.setSalt("test");
        authProperties.setInitialPass("testpassword");
    }

    @Test
    public void encrypt() {
        AESEncryptorDecryptor aesEncryptorDecryptor = new AESEncryptorDecryptor(authProperties);
        String passToEncrypt = "testpassword";
        assertNotEquals(passToEncrypt, aesEncryptorDecryptor.encrypt(passToEncrypt));
    }

    @Test
    public void decrypt() {
        AESEncryptorDecryptor aesEncryptorDecryptor = new AESEncryptorDecryptor(authProperties);
        String passToEncrypt = "testpassword";
        String encryptedPass = aesEncryptorDecryptor.encrypt(passToEncrypt);
        assertNotEquals(passToEncrypt, encryptedPass);
        assertEquals(passToEncrypt, aesEncryptorDecryptor.decrypt(encryptedPass));

    }
}