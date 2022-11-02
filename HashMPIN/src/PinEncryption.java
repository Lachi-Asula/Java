import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PinEncryption {

    public static void main(String[] args) {
        String s = null;
        try {
            s = getMpinHash("111111","121241509626411520",500);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(s);
    }

    public static String getMpinHash(String clearpin, String salt, int iterations) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        char[] hexmpinarr = hexFromString(clearpin).toCharArray();
        byte[] hexsaltarr = hexFromString(salt).getBytes();

        PBEKeySpec spec = new PBEKeySpec(hexmpinarr, hexsaltarr, iterations, 32 * 8);


        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        spec.clearPassword();

        return hexFromByteArray(hash);
    }
    public static String hexFromString(String str)
    {
        String hex = "";
        for (int i = 0; i < str.length(); i++)
        {
            int ascii = str.charAt(i);
            String hexChar = Integer.toHexString(ascii);
            hex = hex + hexChar;
        }
        return hex;
    }
    public static String hexFromByteArray(byte[] array) throws NoSuchAlgorithmException
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0)
        {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        }
        else
        {
            return hex;
        }
    }


}