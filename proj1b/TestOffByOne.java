import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void equalCharsTest() {
        assertTrue(offByOne.equalChars('x','y'));
        assertTrue(offByOne.equalChars('y','x'));
        assertFalse(offByOne.equalChars('a','c'));
        assertTrue(offByOne.equalChars('&', '%'));
        assertFalse(offByOne.equalChars('a','d'));
    }
}
