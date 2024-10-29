import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Initialize the Scanner to take user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for plaintext to encrypt and convert it to uppercase
        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine().toUpperCase();

        // Prompt the user for a shift value (used for encryption)
        System.out.print("Enter the shift value (as a number): ");
        int shiftValue = scanner.nextInt();

        // Encrypt the plaintext using the custom cipher method
        String encryptedMessage = encrypt(plaintext, shiftValue);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Decrypt the encrypted message to verify it returns to the original text
        String decryptedMessage = decrypt(encryptedMessage, shiftValue);
        System.out.println("Decrypted Message: " + decryptedMessage);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }

    // Method to encrypt the plaintext
    public static String encrypt(String plaintext, int shiftValue) {
        // Initialize a StringBuilder to build the encrypted message
        StringBuilder encryptedText = new StringBuilder();

        // Loop through each character in the plaintext
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i); // Get each character
            if (Character.isLetter(c)) { // Check if the character is a letter
                if (i % 2 == 0) {
                    // For even indices: Shift the character forward by shiftValue
                    char encryptedChar = (char) (((c - 'A' + shiftValue) % 26) + 'A');
                    encryptedText.append(encryptedChar); // Append the shifted character
                } else {
                    // For odd indices: Shift the character backward by half of shiftValue
                    int halfShift = shiftValue / 2;
                    char encryptedChar = (char) (((c - 'A' - halfShift + 26) % 26) + 'A');
                    encryptedText.append(encryptedChar); // Append the shifted character
                }
            } else {
                // Non-letter characters are added as-is
                encryptedText.append(c);
            }
        }

        // Return the final encrypted text as a string
        return encryptedText.toString();
    }

    // Method to decrypt the ciphertext
    public static String decrypt(String ciphertext, int shiftValue) {
        // Initialize a StringBuilder to build the decrypted message
        StringBuilder decryptedText = new StringBuilder();

        // Loop through each character in the ciphertext
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i); // Get each character
            if (Character.isLetter(c)) { // Check if the character is a letter
                if (i % 2 == 0) {
                    // For even indices: Shift the character backward by shiftValue
                    char decryptedChar = (char) (((c - 'A' - shiftValue + 26) % 26) + 'A');
                    decryptedText.append(decryptedChar); // Append the shifted character
                } else {
                    // For odd indices: Shift the character forward by half of shiftValue
                    int halfShift = shiftValue / 2;
                    char decryptedChar = (char) (((c - 'A' + halfShift) % 26) + 'A');
                    decryptedText.append(decryptedChar); // Append the shifted character
                }
            } else {
                // Non-letter characters are added as-is
                decryptedText.append(c);
            }
        }

        // Return the final decrypted text as a string
        return decryptedText.toString();
    }
}


