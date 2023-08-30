import java.util.Scanner;

public class caesar {

    //Though it is not related to blockchain

    public static String encrypt(String plaintext, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encryptedText.append((char) ((c - base + shift) % 26 + base));
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String ciphertext, int shift) {
        return encrypt(ciphertext, 26 - shift);
    }

    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in); 
        System.out.println("Enter the Message to encrypt: ");
        String message = ip.nextLine();
        System.out.println("Enter the no of shifts needed :");
        int shift = ip.nextInt();

        String encryptedMessage = encrypt(message, shift);
        String decryptedMessage = decrypt(encryptedMessage, shift);

        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
