package helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MeshPassword {
    public static String mesh(String password, String salt) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println("No such algorithm");
            return "none";
        }
        messageDigest.reset();
        String beforeHash = password + new String(salt);
        byte[] hash = messageDigest.digest(beforeHash.getBytes());
        return new String(hash);
    }
}
