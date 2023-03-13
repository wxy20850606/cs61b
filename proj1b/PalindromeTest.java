import org.junit.Test;
import static org.junit.Assert.*;
public class PalindromeTest {
    static Palindrome palindrome = new Palindrome();

    @Test
    public static void testisPalindrome(){
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("kite"));
    }
    public static void main(String[] args) {
            testisPalindrome();
        }
}
