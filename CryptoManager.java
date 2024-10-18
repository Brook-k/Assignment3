/*
 * Class: CMSC203
 * Instructor: 
 * Description: Implements the Caesar and Bellaso ciphers and provides functionality to encrypt and decrypt phrases using these algorithms.
 * Due: MM/DD/YYYY
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Barkot Kifle
 */
public class CryptoManager {

    private static final char LOWER_RANGE = ' '; // ASCII value 32
    private static final char UPPER_RANGE = '_'; // ASCII value 95
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

    // Check if the string is in bounds
    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (plainText.charAt(i) < LOWER_RANGE || plainText.charAt(i) > UPPER_RANGE) {
                return false;
            }
        }
        return true;
    }

    // Caesar Cipher Encryption
    public static String caesarEncryption(String plainText, int key) {
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }
        
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char newChar = (char) ((plainText.charAt(i) + key - LOWER_RANGE) % RANGE + LOWER_RANGE);
            encryptedText.append(newChar);
        }
        return encryptedText.toString();
    }

    // Caesar Cipher Decryption
    public static String caesarDecryption(String encryptedText, int key) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char newChar = (char) ((encryptedText.charAt(i) - key - LOWER_RANGE + RANGE) % RANGE + LOWER_RANGE);
            decryptedText.append(newChar);
        }
        return decryptedText.toString();
    }

    // Bellaso Cipher Encryption
    public static String bellasoEncryption(String plainText, String bellasoStr) {
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }

        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            int bellasoIndex = i % bellasoStr.length();
            char newChar = (char) ((plainText.charAt(i) + bellasoStr.charAt(bellasoIndex) - 2 * LOWER_RANGE) % RANGE + LOWER_RANGE);
            encryptedText.append(newChar);
        }
        return encryptedText.toString();
    }

    // Bellaso Cipher Decryption
    public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        StringBuilder decryptedText = new StringBuilder();
        
        for (int i = 0; i < encryptedText.length(); i++) {
            char ch = encryptedText.charAt(i);
            char bellasoChar = bellasoStr.charAt(i % bellasoStr.length());
            
            // Subtract the bellaso key character from the encrypted character
            int newChar = ch - bellasoChar;
            
            // If the resulting character is below the allowed range, wrap it around
            if (newChar < LOWER_RANGE) {
                newChar += RANGE;
            }
            
            decryptedText.append((char) newChar);
        }
        
        return decryptedText.toString();
    }
    
}