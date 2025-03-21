import io.jsonwebtoken.security.Keys;
import java.util.Base64;

public class JwtKeyGenerator {
    public static void main(String[] args) {
        byte[] keyBytes = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256).getEncoded();
        String encodedKey = Base64.getEncoder().encodeToString(keyBytes);
        System.out.println("Generated Secret Key: " + encodedKey);
    }
}

