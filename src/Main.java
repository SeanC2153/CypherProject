import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine().toUpperCase();

        System.out.print("Enter the keyword (as a number for shift): ");
        int shiftValue = scanner.nextInt();

        // Encrypting the message
        String encryptedMessage = encrypt(plaintext, shiftValue);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Decrypting the message
        String decryptedMessage = decrypt(encryptedMessage, shiftValue);
        System.out.println("Decrypted Message: " + decryptedMessage);

        scanner.close();
    }

    public static String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift) % 26 + base);
            }
            ciphertext.append(c);
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int shift) {
        StringBuilder plaintext = new StringBuilder();
        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base - shift + 26) % 26 + base);
            }
            plaintext.append(c);
        }
        return plaintext.toString();
    }
}

