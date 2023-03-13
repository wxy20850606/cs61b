import org.junit.Test;
import static org.junit.Assert.*;
public class PalindromeTest {
    static Palindrome palindrome = new Palindrome();

    @Test
    public static void testisPalindrome(){
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("Bob"));
        assertTrue(palindrome.isPalindrome(" "));
        assertFalse(palindrome.isPalindrome("kite"));
        assertTrue(palindrome.isPalindrome("saippuakivikauppias"));
        assertTrue(palindrome.isPalindrome("Rotavator"));
    }
    public static void main(String[] args) {
            testisPalindrome();
        }
}
