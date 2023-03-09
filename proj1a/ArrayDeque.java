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

    /**resize */
    //public void resize(int capacity){}

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
        if(size == 0){
            return null;
        }
        return items[index];
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i = 0; i < size; i += 1){
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }
    public T removeLast(){
        T item = items[nextLast-1];
        items[nextLast-1] = null;
        nextLast -= 1;
        size -= 1;
        return item;
    }
    public T removeFirst(){
        T item = items[nextFirst+1];
        items[nextFirst+1] = null;
        nextFirst += 1;
        if(nextFirst == length){
            nextFirst = nextFirst-length;
        }
        size -= 1;
        return item;
    }
    
    public static void main(String[] args){
        ArrayDeque L = new ArrayDeque();
        L.addLast("a");
        L.addLast("b");
        L.addFirst("c");
        L.addLast("d");
        L.addLast("e");
        L.addFirst("f");
        //L.addLast("g");
        //L.addLast("h");
        L.removeLast();
        L.removeFirst();
        L.printDeque();
        System.out.println(L.get(6));
    }
}