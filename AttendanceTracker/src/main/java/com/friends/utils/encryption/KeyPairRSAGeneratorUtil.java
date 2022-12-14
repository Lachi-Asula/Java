package com.friends.utils.encryption;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.friends.utils.AdapterUtils.getStackTrace;

@Component
public class KeyPairRSAGeneratorUtil {

    private final static Logger logger = Logger.getLogger(KeyPairRSAGeneratorUtil.class.getName());

    public static void main(String[] args) throws Exception {
        createKeys();
    }

    private static void createKeys() throws NoSuchAlgorithmException, IOException {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair kp = kpg.generateKeyPair();
            PrivateKey aPrivate = kp.getPrivate();
            PublicKey aPublic = kp.getPublic();

            try (FileOutputStream outPrivate = new FileOutputStream("key.priv")) {
                outPrivate.write(aPrivate.getEncoded());
            }

            try (FileOutputStream outPublic = new FileOutputStream("key.pub")) {
                outPublic.write(aPublic.getEncoded());
            }

            System.out.println("Private key: " + aPrivate.getFormat());

            System.out.println("Public key: " + aPublic.getFormat());
        }catch (Exception ex){
            logger.log(Level.SEVERE, getStackTrace(ex));
        }
    }

    public PrivateKey loadPrivateKey() {
        PrivateKey privateKey = null;
        File privateKeyFile = null;
        try {
            privateKeyFile = new File("key.priv");
            byte[] privateKeyBytes = Files.readAllBytes(privateKeyFile.toPath());

            KeyFactory privateKeyFactory = KeyFactory.getInstance("RSA");
            EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            privateKey = privateKeyFactory.generatePrivate(privateKeySpec);
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }finally {
            if(privateKeyFile != null){
                privateKeyFile = null;
            }
        }
        return privateKey;
    }

    public PublicKey loadPublicKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        PublicKey publicKey = null;
        File publicKeyFile = null;
        try {
            publicKeyFile = new File("key.pub");
            byte[] publicKeyBytes = Files.readAllBytes(publicKeyFile.toPath());

            KeyFactory publicKeyFactory = KeyFactory.getInstance("RSA");
            EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
            publicKey = publicKeyFactory.generatePublic(publicKeySpec);
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }finally {
            if(publicKeyFile != null){
                publicKeyFile = null;
            }
        }
        return publicKey;
    }

}