import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class MaxArrayDequeTest {

    @Test
    public void maxWithoutCompatatorTest(){
        MaxArrayDeque<Integer> test = new MaxArrayDeque(new intComparator());
        for(int i = 0; i < 7; i += 1){
            test.addFirst(i);
        }
        assertEquals((Integer) 6, test.max());
    }

    @Test
    public void maxCompatatorTest(){
        MaxArrayDeque<String> test = new MaxArrayDeque(new StringComparator());
        test.addFirst("i");
        test.addFirst("im");
        test.addFirst("i");
        assertEquals((String) "i", test.max());
    }




    private class intComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    private class StringComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            int minLength = Math.min(o1.length(),o2.length());
            for(int i = 0; i < minLength;i += 1){
                int i1 = o1.charAt(i) - o2.charAt(i);
                if(i1 != 0){
                    return -i1;
                }
            }
            return o2.length() - o1.length();
        }
    }
}
