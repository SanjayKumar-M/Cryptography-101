package SHA3;

// keccak is an algorithm used in SHA3 family to produce 256 bits of hash. It is itself an algorithm not a function

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Keccak256 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.println("Enter the Message you need to hash :");
        String Message = ip.nextLine();
        System.out.println("The SHA-3 or Keccak Hash of the message is : ");
        System.out.println(KeccakHash(Message));

    }
    static String KeccakHash(String message){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-3-256");
            byte[] hash = md.digest(message.getBytes());

            StringBuilder OutputHash = new StringBuilder();
            for(byte h: hash){
                OutputHash.append(String.format("%02x", h));
            }

            return OutputHash.toString();
        }
        catch(NoSuchAlgorithmException ex){
            ex.printStackTrace();
            return null;
        }
    }

}
