/*  use <> to make Deque generic  */
public class LinkedListDeque<T>{

    /*subclass */
    private class StuffNode{
        public T item;
        public StuffNode next;
        public StuffNode prev;

        public StuffNode(T i) {
            item = i;
        }
        public StuffNode(T i,StuffNode n,StuffNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    /*instance variable */
    private StuffNode sentinel;
    private StuffNode node;
    private int size;

/*create an empty list */
public LinkedListDeque(T item){
    sentinel = new StuffNode(item);
    sentinel.prev = sentinel;
    sentinel.next = sentinel;
    size = 0;
}

public void addFirst(T item){

    sentinel.next  = new StuffNode(item,sentinel.next,sentinel);
    //node = sentinel.next;
    //sentinel.prev = sentinel.prev.prev.next;
    //sentinel.prev.prev = sentinel.next;
    sentinel.next.next.prev = sentinel.next;




    size = size + 1;
}

public void addLast(T item){
    sentinel.prev.next= new StuffNode(item,sentinel,sentinel.prev);
    sentinel.prev = sentinel.prev.next;
    size += 1;
}

public boolean isEmpty(){
    if(size == 0){
        return false;
    }
    return true;
}

public int size(){

    return size;
}

public void printDeque(){
    StuffNode p = sentinel.next;
    for(int i = 0; i < size; i += 1){
        System.out.print(p.item + " ");
        p = p.next;
    }
    System.out.println();


}

public T removeFirst(){
    T item = sentinel.next.item;
    sentinel.next = sentinel.next.next;
    sentinel.next.prev = sentinel;
    size -= 1;
    return item;
}

public T removeLast(){
    T item = sentinel.prev.item;
    sentinel.prev.prev.next = sentinel;
    sentinel.prev = sentinel.prev.prev;
    size -= 1;
    return item;
}

public T get(int index){
    StuffNode p = sentinel.next;
    for(int i = 0; i < index; i += 1){
        p = p.next;
    }
    return p.item;
}

public T getRecursiveHelper(StuffNode p,int index) {
    if (index == 0) {
        return p.item;
    }

    return getRecursiveHelper(p.next, index - 1);
}

public T getRecursive(int index){
    StuffNode p = sentinel.next;

    return getRecursiveHelper(p,index);
}
public static void main(String[] args){
    /*create a list of int */


    /*create a list of string */
    LinkedListDeque<String> s1 = new LinkedListDeque<>("cs61b");
    s1.addFirst("very");
    s1.addFirst("u");
    s1.addFirst("love");
    s1.addFirst("i");
    s1.addLast("much");
    s1.removeFirst();
    s1.removeLast();
    //s1.get(2);
    s1.printDeque();
    System.out.println(s1.getRecursive(1));
}

}