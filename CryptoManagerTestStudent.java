import static org.junit.Assert.*;
import org.junit.Test;

public class CryptoManagerTestStudent {

    @Test
    public void testIsStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("HELLO"));
        assertFalse(CryptoManager.isStringInBounds("hello"));  // Lowercase out of bounds
        assertFalse(CryptoManager.isStringInBounds("HELLO WORLD!"));  // '!' out of bounds
    }

    @Test
    public void testCaesarEncryption() {
        assertEquals("KHOOR", CryptoManager.caesarEncryption("HELLO", 3));
        assertEquals("F", CryptoManager.caesarEncryption("A", 5));
    }

    @Test
    public void testCaesarDecryption() {
        assertEquals("HELLO", CryptoManager.caesarDecryption("KHOOR", 3));
        assertEquals("A", CryptoManager.caesarDecryption("F", 5));
    }

    @Test
    public void testBellasoEncryption() {
        assertEquals("DOVGHSZ", CryptoManager.bellasoEncryption("ABCDEFG", "CMSC"));
        assertEquals("KQLLWVM", CryptoManager.bellasoEncryption("HELLOTHERE", "WORLD"));
    }

    
    @Test
    public void testBellasoDecryption() {
        // Test with the known Bellaso encryption example
        assertEquals("ABCDEFG", CryptoManager.bellasoDecryption("DOVGHSZ", "CMSC"));
        
        // Test with a longer string and a different key
        assertEquals("HELLOTHERE", CryptoManager.bellasoDecryption("KQLLWVM", "WORLD"));
        
        // Additional test cases to validate edge cases
        assertEquals("TEST", CryptoManager.bellasoDecryption("UJUV", "KEY"));
        assertEquals("CAESAR", CryptoManager.bellasoDecryption("FJHFRG", "SHIFT"));
    }

}
