public interface Deque<T> {

    public void addLast(T item);

    public void addFirst(T item);

    public T get(int index);

    public boolean isEmpty();

    public int size();

    public void printDeque();

    public T removeLast();

    public T removeFirst();
}