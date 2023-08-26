package SHA2;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;



public class sha256 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the message you need to hash :");
        String Message = input.nextLine();

        System.out.println("And the SHA-256 hash is" + Hashing(Message));
    }

    static String Hashing(String input) {
        try {
            // creating new object of Messagedigest class and setting the instance to
            // SHA-256 (The hash function we need to perform)

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // now we are perfroming the hashing on the Message using digest method where we
            // get in bytes
            byte[] hash = md.digest(input.getBytes());
            // Now those bytes are converted into hexadecimal format
            StringBuilder hexHash = new StringBuilder();
            // loop through each bytes in hashes[] array
            for (byte h : hash) {
                // Convert the byte to a two-character hexadecimal representation and append to
                // hexHash
                hexHash.append(String.format("%02x", h));
            }
            // Return the hexadecimal representation of the hash

            return hexHash.toString();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;

        }

    }

}