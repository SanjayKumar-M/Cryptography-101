import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
//ecc is used to generate public key from private key
//Generally it is given by Generative point G on the curve denoted by F(x,y). so , Public Key = Private Key*G
public class ecc {
    public static void main(String[] args) throws Exception {
        // Add Bouncy Castle as a security provider
        Security.addProvider(new BouncyCastleProvider());

        // Choose an elliptic curve (e.g., secp256k1)
        ECNamedCurveTable ecParams = ECNamedCurveTable.getParameterSpec("secp256k1");

        // Generate an ECC key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDSA", "BC");
        keyPairGenerator.initialize(ecParams);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Get the public and private keys
        java.security.interfaces.ECPublicKey publicKey = (java.security.interfaces.ECPublicKey) keyPair.getPublic();
        java.security.interfaces.ECPrivateKey privateKey = (java.security.interfaces.ECPrivateKey) keyPair.getPrivate();

        System.out.println("Public Key: " + publicKey);
        System.out.println("Private Key: " + privateKey);
    }
}
