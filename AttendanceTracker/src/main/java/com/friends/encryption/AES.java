package com.friends.encryption;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.util.Base64;
import java.util.logging.Logger;

@Component
public class AES {

    Logger logger = Logger.getLogger(AES.class.getName());
    private SecretKey key;
    private int KEY_SIZE = 128;
    private int T_LEN = 128;

    private Cipher encryptionCipher;

    public void init(){
        try {
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(KEY_SIZE);
            key = generator.generateKey();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public AES() {
        init();
    }

    public String encrypt(String message){
        try{
            byte[] messageInBytes = message.getBytes();
            encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
            encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptionBytes = encryptionCipher.doFinal(messageInBytes);
            return encode(encryptionBytes);
        }catch (Exception e){
            logger.info("Error occurred while Encrypting data: " + e);
        }
        return null;
    }

    public String decrypt(String encryptedMessage){
        try {
            byte[] messageInBytes = decode(encryptedMessage);
            Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec spec = new GCMParameterSpec(T_LEN, encryptionCipher.getIV());
            decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
            byte[] decryptBytes = decryptionCipher.doFinal(messageInBytes);
            return new String(decryptBytes);
        }catch (Exception e){
            // logger.info("Error Occurred while decrypting data: " + e);
        }

        return null;
    }

    public String encode(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }

    public byte[] decode(String data){
        return Base64.getDecoder().decode(data);
    }

}
