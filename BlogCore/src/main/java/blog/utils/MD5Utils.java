package blog.utils;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MD5Utils {

    public static String md5Code(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test() {
        String input = "s002611";
        String code = md5Code(input);
        System.out.println(code.toUpperCase());
    }
}
