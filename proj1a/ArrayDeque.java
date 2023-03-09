public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int length;

    /**
     * create an empty array
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
        length = 8;

    }

    /** Inserts X into the first of the list. */
    public void addLast(T item){
        items[nextLast] = item;
        size = size + 1;
        nextLast += 1;
        if(nextLast == length){
            nextLast = nextLast - length;
        }

    }

    public void addFirst(T item){
        items[nextFirst] = item;
        size = size + 1;
        nextFirst -= 1;
    }
    public T get(int index){
        return items[index];

    }

    public static void main(String[] args){
        ArrayDeque L = new ArrayDeque();
        L.addLast("a");
        L.addLast("b");
        L.addFirst("c");
        L.addLast("d");
        L.addLast("e");
        L.addFirst("f");
        L.addLast("g");
        L.addLast("h");
        System.out.println(L.get(6));
    }
}
/*  use <> to make Deque generic  */
