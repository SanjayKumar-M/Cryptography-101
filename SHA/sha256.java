package SHA;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class sha256{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the message you need to hash :");
        String Message = input.nextLine();
    
        System.out.println("And the SHA-256 hash is"+Hashing(Message));
    }

    static String Hashing(String input){
        try{

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(input.getBytes());
            
            StringBuilder hexHash = new StringBuilder();
            for(byte h: hash){
                hexHash.append(String.format("%02x", h));
            }

            return hexHash.toString();
        }
        catch(NoSuchAlgorithmException ex){
            ex.printStackTrace();
            return null;

        }

    }

}