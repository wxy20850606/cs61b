import static org.junit.Assert.*;

import org.junit.Test;
public class ArrayDequeTest {
    @Test
    public static void testgrowshrink() {
        ArrayDeque L = new ArrayDeque();
        L.addLast("a");
        L.addLast("b");
        L.addFirst("c");
        L.addLast("d");
        L.addLast("e");
        L.addFirst("f");
        L.addLast("g");
        L.addLast("h");
        L.addLast("Z");
        for(int i=0;i<=100;i++){
            L.addFirst(i);
        }
        for(int i=0;i<=100;i++){
            L.removeFirst();
        }
        for(int i=0;i<=100;i++){
            L.addLast(i);
        }
        for(int i=0;i<=100;i++){
            L.removeLast();
        }
        assertEquals( "Z",L.get(8));
}
    public static void main(String[] args) {
        testgrowshrink();
    }
}