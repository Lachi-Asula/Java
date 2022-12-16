package com.friends.utils.encryption;

import org.springframework.stereotype.Component;

import javax.crypto.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.friends.utils.AdapterUtils.getStackTrace;

@Component
public class EncryptDecryptRSAUtil {
    private static Logger logger = Logger.getLogger(EncryptDecryptRSAUtil.class.getName());
    private static final String PublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCMvGpgsL87+AyGiUp+mq9GmtuCnjwK9Rv/vysRSX20COVodCc91oUd3QUa4lrsK02Jx3UT96okM19mQpkeVK9KQDUhq1ERxlOAagbthB9q4+8vTABNftAPWcL41x3qLN3ivo4LBifYDk+uDpMJi7ZWCdyKwT76YY4PKQxb9+hWNwIDAQAB";
    private static final String PrivateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIy8amCwvzv4DIaJSn6ar0aa24KePAr1G/+/KxFJfbQI5Wh0Jz3WhR3dBRriWuwrTYnHdRP3qiQzX2ZCmR5Ur0pANSGrURHGU4BqBu2EH2rj7y9MAE1+0A9ZwvjXHeos3eK+jgsGJ9gOT64OkwmLtlYJ3IrBPvphjg8pDFv36FY3AgMBAAECgYA56FUFD/S/4iKVQOxsB43TSWjE6ALgp1Yr9ybraAfXCkoKnrB+20POs+Cj3Tt4LaEr7ewYmTFiz9iTJRgHyOSO0HlDtDd+FjqZKyIkqKaZnZJleBqLQs4pPcQm6RiqVeTE6JFDFERW7sDCYFSNWIn54Q+/jIVy4O0y/CkA8M+Y8QJBAPp36aYbFgtMwDGXBqlVaPEB9Fj+926Z/5xw3UTr88lmLtSTx3yiTMozV17NxAqWJRRvU1u1bQVkhaJAPUM6AmUCQQCP2BpA/TqKssI3dNJD7Ss0rZhqt6KbB5mkUh7JeFBwHxCAETQMYnucSeV5/a9APCyGYD4YsB7G4wB3ZitCA55rAkEA0FdCgSrysT+MdzN7FQu4mRDZIdYkF1n95zFyvMvQI2zd83FhdGjEm0UNngxmz6+I9HCN1DEbmGq/RfFNhEgSiQJBAIo2T8ugRa7dYkYc5qhD657bKjdoKUKjA9ri2RgmlcuV3angXc2El1ctneQggFLNPs8DDMd1+qyJk3omXmw4w+8CQBHtK79zzf67cvLbk8cz38XTBR4E6hyOwGAup5sLHMUlwkHzwo8XdceO/eQuwWYfHRjD23TsURK6xmsjevYUD8g=";
    public static String getEncrypted(String data, String Key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(Key.getBytes())));
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedbytes = cipher.doFinal(data.getBytes());
        return new String(Base64.getEncoder().encode(encryptedbytes));
    }

    public static String getDecrypted(String data, String Key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        PrivateKey pk = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(Key.getBytes())));
        cipher.init(Cipher.DECRYPT_MODE, pk);
        byte[] encryptedbytes = cipher.doFinal(Base64.getDecoder().decode(data.getBytes()));
        return new String(encryptedbytes);
    }

    public String encode(String decDate){
        try {
            return getEncrypted(decDate, PublicKey);
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }
        return null;
    }

    public String decode(String encData){
        try {
            return getDecrypted(encData, PrivateKey);
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }
        return null;
    }

    public void keyGeneration() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(448);
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.genKeyPair();

        String pubKey = new String(Base64.getEncoder().encode(keyPair.getPublic().getEncoded()));
        String priKey = new String(Base64.getEncoder().encode(keyPair.getPrivate().getEncoded()));
    }

//    public static void main(String[] args){
//        String str = "Ajay@123";
//        String cipherText = new EncryptDecryptRSAUtil().encode(str);
//        System.out.println("CHIPHER:" + cipherText);
//        String decryptedText = new EncryptDecryptRSAUtil().decode(cipherText);
//        System.out.println("DECRYPTED STRING:" + decryptedText);
//
//    }

}