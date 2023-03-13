public class Palindrome {

    static ArrayDeque L = new ArrayDeque();

    public static Deque<Character> wordToDeque(String word) {
        int stringLength = word.length();
        //ArrayDeque L = new ArrayDeque();
        char charAt = Character.toUpperCase(word.charAt(0));
        L.addFirst(charAt);
        for (int i = 1; i < stringLength; i++) {
            charAt = Character.toUpperCase(word.charAt(i));
            L.addLast(charAt);
        }
        return L;

    }

    private Boolean isPalidromeHelper(Deque L) {

        if(L.size() <= 1){
            L.removeLast();
            return true;
        }
        else if (L.removeFirst() == L.removeLast()) {
            return isPalidromeHelper(L);
        }
        else{
            for(int i = 0; i < L.size(); i++){
                L.removeLast();
                L.removeFirst();
            }
            return false;
        }
    }

    public boolean isPalindrome(String word) {
        wordToDeque(word);
        return isPalidromeHelper(L);
    }

}

