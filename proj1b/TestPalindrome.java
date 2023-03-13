import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void isPalindrome(){
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("aca"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("c"));
        assertTrue(palindrome.isPalindrome(" "));
    }
}
