public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int length;

    /** create an empty array */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
        length = 8;
    }

    /** copy the old list to a new list after grow/shrink */
    private void copy(int capacity){
        T[] a = (T[]) new Object[capacity];
        int firstIndex = plusOne(nextFirst,length);
        int i = 0;
        while (i < size) {
            a[i] = items[firstIndex];
            firstIndex = plusOne(firstIndex, length);
            i++;}
        items = a;
    }
    /** grow the list if needed to add items */
    private void grow() {
        copy(length * 2);
        nextLast = length;
        nextFirst = length * 2 - 1;
    }

    /** shrink the list if needed after removing items */
    private void shrink(){
        copy(length / 2);
        nextLast = size;
        nextFirst = length - 1;
    }
    private int plusOne(int index, int length){
        index %= length;
        if (index == length - 1) {
            return 0;
        }
        return index + 1;
    }

    private int minusOne(int index, int length){
        if (index == 0){
            return length-1;
        }
        return index-1;
    }
    
    /** Inserts X into the first of the list. */
    public void addLast(T item){
        if(size == items.length){
            grow();
            length = length * 2;
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast,length);
        size = size + 1;
    }

    public void addFirst(T item){
        if(size == items.length){
            grow();
            length = length * 2;
        }
        items[nextFirst] = item;

        nextFirst = minusOne(nextFirst,length);
        size = size + 1;
    }

    public T get(int index){
        if(index >= size){
            return null;
        }
        int firstIndex = plusOne(nextFirst,length);
        for(int i = 0;i < index; i++){
            firstIndex = plusOne(firstIndex,length);
        }
        return items[firstIndex];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int firstIndex = plusOne(nextFirst,length);
        while(firstIndex != nextLast){
            System.out.print(items[firstIndex]+" ");
            firstIndex = plusOne(firstIndex,length);
        }
        System.out.println();
    }

    public T removeLast(){
        if(size ==0){
            return null;
        }
        int lastIndex = minusOne(nextLast,length);
        T item = items[lastIndex];
        items[lastIndex] = null;
        nextLast = minusOne(nextLast,length);
        size -= 1;
        if(size < length * 0.25 && length > 16){
            shrink();
        }
        return item;
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }
        int firstIndex = plusOne(nextFirst,length);
        T item = items[firstIndex];
        items[firstIndex] = null;
        nextFirst = plusOne(nextFirst,length);
        size -= 1;
        if(size < length * 0.25 && length > 16){
            shrink();
        }
        return item;
    }
}