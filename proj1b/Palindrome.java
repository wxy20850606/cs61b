public class Palindrome {

    static ArrayDeque L = new ArrayDeque();

    public static Deque<Character> wordToDeque(String word) {
        int stringLength = word.length();
        //ArrayDeque L = new ArrayDeque();
        char charAt = word.charAt(0);
        L.addFirst(charAt);
        for (int i = 1; i < stringLength; i++) {
            charAt = word.charAt(i);
            L.addLast(charAt);
        }
        return L;

    }

    private Boolean isPalidromeHelper(Deque L) {
        if (L.removeFirst() != L.removeLast() && L.removeLast() != null) {
            return false;
        }
        else if(L.removeLast() == null){
            return true;
        }
        return isPalidromeHelper(L);
    }

    public boolean isPalindrome(String word) {
        int length = word.length();
        if (length < 2) {
            return true;
        }
        wordToDeque(word);
        return isPalidromeHelper(L);
    }

}

