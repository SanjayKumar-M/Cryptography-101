import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.util.encoders.Hex;

public class Blake2 {

    public static void main(String[] args) {
        String message = "Hello, BLAKE2!";
        byte[] inputBytes = message.getBytes();

        Blake2bDigest blake2 = new Blake2bDigest(null, 256, null, null);
        blake2.update(inputBytes, 0, inputBytes.length);

        byte[] hashBytes = new byte[blake2.getDigestSize()];
        blake2.doFinal(hashBytes, 0);

        String hashHex = Hex.toHexString(hashBytes);
        System.out.println("BLAKE2 Hash: " + hashHex);
    }
}
