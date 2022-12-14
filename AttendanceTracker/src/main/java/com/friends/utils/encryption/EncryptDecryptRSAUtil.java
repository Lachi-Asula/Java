package com.friends.utils.encryption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.friends.utils.AdapterUtils.getStackTrace;

@Component
public class EncryptDecryptRSAUtil {

    @Autowired
    private KeyPairRSAGeneratorUtil loadKeys;

    private static Logger logger = Logger.getLogger(EncryptDecryptRSAUtil.class.getName());

    public String encode(String toEncode) {
        try {
            PublicKey publicKey = loadKeys.loadPublicKey();

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] bytes = cipher.doFinal(toEncode.getBytes(StandardCharsets.UTF_8));
            return new String(Base64.getEncoder().encode(bytes));
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }
        return null;
    }

    public String decode(String toDecode) {
        try {
            PrivateKey privateKey = loadKeys.loadPrivateKey();

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(toDecode));
            return new String(bytes);
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }
        return null;
    }

    /*public static void main(String[] args)throws Exception {
        String pass = "Ajay@123";
        String encStr = new EncryptDecryptRSAUtil().encode(pass);
        System.out.println(encStr);
        String decStr = new EncryptDecryptRSAUtil().decode(encStr);
        System.out.println(decStr);
    }*/

}