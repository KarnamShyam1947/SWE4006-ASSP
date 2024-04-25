package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {
    
    public static String hashPassword(String password) {

        MessageDigest messageDigest;
        StringBuilder hashedPassword = new StringBuilder();

        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(password.getBytes());
            byte[] passwordBytes = messageDigest.digest();
            for(byte b:passwordBytes) {
                hashedPassword.append(String.format("%02x", b));
            }
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashedPassword.toString();
    }

    public static boolean checkPassword(String hash, String password) {
        System.out.println("received hash : " + hash);
        System.out.println(hashPassword(password));
        return hash.equals(hashPassword(password));
    }

}
