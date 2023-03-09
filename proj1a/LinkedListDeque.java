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
    StuffNode p = sentinel;
    for(int i = 0; i < size; i += 1){
        System.out.print(p.next.item + " ");
        p = p.next;
    }
    System.out.println();


}

public T removeFirst(){

    size -= 1;
    return sentinel.item;
}

public T removeLast(){

    return sentinel.item;
}

public T get(int index){

    return sentinel.item;
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
    s1.printDeque();
    System.out.println(s1.size);
}

}