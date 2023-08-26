package SHA;

import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha512 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Message you need to hash");
        String Message = input.nextLine();
        System.out.println("The Sha512 based Hash is: " + Hashing(Message));
    }

    static String Hashing(String Message) {
        try {
            // creating new object of Messagedigest class and setting the instance to
            // SHA-512 (The hash function we need to perform)
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            //now we are perfroming the hashing on the Message using digest method where we get in bytes 
            byte[] hashes = md.digest(Message.getBytes());
            //Now those bytes are converted into
            StringBuilder hexHash = new StringBuilder();
            for (byte bytes : hashes) {
                hexHash.append(String.format("%02x", bytes));
            }
            return hexHash.toString();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
