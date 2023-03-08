/*  use <> to make Deque generic  */
public class LinkedListDeque<T>{

    /*subclass */
    private class StuffNode{
        public T item;
        public StuffNode next;

        public StuffNode(T i, StuffNode n) {
            item = i;
            next = n;
        }
    }

    /*instance variable */
    private StuffNode sentinel;
    private int size;

/*constructor/create a empty list */
public LinkedListDeque(){
    sentinel = new StuffNode;
    size = 0;
}
public LinkedListDeque(T item){
    sentinel = new StuffNode(item,null);

    sentinel.next = new StuffNode(item,sentinel);
    size = 1;
}

public void addFirst(T item){

    sentinel.next = new StuffNode(item,sentinel.next);

    size = size + 1;
}

public void addLast(T item){
    StuffNode p = sentinel.next;
    for(int i = 1;i < size; i += 1){
        p = p.next;
    }
    p.next = new StuffNode(item,sentinel);
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
    s1.addFirst("love");
    s1.addFirst("i");
    s1.addLast("last");
    s1.printDeque();
    System.out.println(s1.size);
}

}