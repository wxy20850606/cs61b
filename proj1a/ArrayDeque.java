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


    /**grow the list if needed to add items*/
    private void resize(int capacity){
       T[] a = (T []) new Object[capacity];
       for(int i = 0; i < (length - nextLast);i++){
           a[i] = items[nextLast+i];}
       System.arraycopy(items,0,a,(size - nextLast),(nextFirst+1));
       items = a;
       nextLast = length;
       nextFirst = length*2 - 1;
    }

    /**shrink capacity if needed after removing items*/
    private int optimizeCapacity(){
        while(length > 16 && length > size/0.25){
            length = length/ 2;
        }
        return length;
    }

    /**shrink the list if needed after removing items*/
    private void shrink(int capacity){
        T[] a = (T []) new Object[capacity];
        /**copy first half*/
        if(nextFirst<nextLast){
            for(int i = 0; i< size;i++){
                a[i] = items[nextFirst + 1 + i];
            }
        }
        /** copy first and last half*/
        else{
            int copyQTY = 0;
            /** copy first half*/
            for(int i = 0; i < length*2 -nextFirst-1;i++){
                a[i] = items[nextFirst+1+i];
                copyQTY = copyQTY + 1;
            }
            /** copy last half*/
            for(int i = 0; i < (size - copyQTY);i++){
                a[copyQTY+i] = items[i];
            }
        }
        items = a;
        nextLast = size;
        nextFirst = length - 1;
    }
    /** Inserts X into the first of the list. */
    public void addLast(T item){
        if(size == items.length){
            resize(size * 2);
            length = length * 2;
        }
        items[nextLast] = item;
        size = size + 1;
        nextLast += 1;
        if(nextLast == length){
            nextLast = nextLast - length;
        }
    }

    public void addFirst(T item){
        if(size == items.length){
            resize(size * 2);
            length = length * 2;
        }
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
        int firstItemIndex = nextFirst + 1;
        for(int i = 0; i < length-firstItemIndex; i += 1){
            System.out.print(items[firstItemIndex+i]+" ");
        }
        int lastItemIndex = nextLast - 1;
        for(int i = 0; i < lastItemIndex; i += 1){
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }
    public T removeLast(){
        if(nextLast == 0){
            nextLast = length;
        }
        T item = items[nextLast-1];
        items[nextLast-1] = null;
        nextLast -= 1;
        size -= 1;
        if(size < length * 0.25 && length >16){
            shrink(optimizeCapacity());
        }
        return item;
    }
    public T removeFirst(){
        int lastIndex = nextFirst+1;
        if(lastIndex==length){
            lastIndex = length-lastIndex;
            nextFirst = -1;
        }
        T item = items[lastIndex];
        items[lastIndex] = null;
        nextFirst += 1;
        size -= 1;
        if(size < length * 0.25){
            shrink(optimizeCapacity());
        }
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
        L.addLast("g");
        L.addLast("h");
        L.addLast("Z");
        for(int i=0;i<=100;i++){
            L.addFirst(i);
        }
        L.removeLast();
        for(int i=0;i<=75;i++){
            L.removeFirst();
        }
        for(int i=0;i<=20;i++){
            L.removeLast();
        }
        for(int i=0;i<=15;i++){
            L.removeLast();
        }
        L.printDeque();
        System.out.println(109/128);
    }
}
