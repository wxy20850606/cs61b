package hashmap;

import java.util.*;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    // You should probably define some more!
    private int initialCapacity = 16;
    private double loadFactor = 0.75;
    private  int size = 0;
    private int length=16;


    /** Constructors */
    public MyHashMap() {
        this(16,0.75);
    }

    public MyHashMap(int initialSize) {
        this(initialSize,0.75);
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        this.buckets = createTable(initialSize);
        this.loadFactor = maxLoad;
    }
    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        return new Node(key,value);
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *

     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        return new ArrayList<>();
    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     *
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */

    //update the following part from https://github.com/exuanbo/cs61b-sp21/tree/main/lab8/hashmap
    private Collection<Node>[] createTable(int tableSize) {
        Collection<Node>[] table = new Collection[tableSize];
        for(int i = 0; i < tableSize;i += 1){
            table[i] = createBucket();
        }
        return table;

    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!

    @Override
    public void clear(){
        size = 0;
        buckets = createTable(initialCapacity);
        length = initialCapacity;
    }

    @Override
    public boolean containsKey(K key){
        return getNode(key) != null;
    }
    private Node getNode(K key) {
        int mod = modCalculator(key);
        Collection<Node> bucket = buckets[mod];
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }
    @Override
    public  V get(K key){
        if(containsKey(key)){
            Node node = getNode(key);
            return node.value;
        }
        return null;
    }

    @Override
    public int size(){
        return size;
    }
    private void resize(int doubleBucket) {
        Collection<Node>[] newBuckets = createTable(doubleBucket);
        length = length * 2;
        for (int i = 0; i < buckets.length; i += 1) {
            for (Node node : buckets[i]) {
                if (node != null) ;
                int mod = modCalculator(node.key);
                newBuckets[mod].add(node);
            }
        }
        buckets=newBuckets;
    }

    // calculate the mode for a given key use Math.floorMod
    private int modCalculator(K key){
        int hashCode = key.hashCode();
        int mod = Math.floorMod(hashCode, length);
        return mod;
    }
    @Override
    public void put(K key, V value){
        Node node = getNode(key);
        if(node != null){
            node.value = value;
        }
        else{
        int mod = modCalculator(key);
        Node newNode = createNode(key,value);
        buckets[mod].add(newNode);
        size += 1;
        double currentLoadFactor = size * 1.0 / length;
        if(currentLoadFactor > loadFactor){
            resize(length * 2);
            }
        }
    }
    @Override
    public Set<K> keySet(){
        Set<K> set = new HashSet<>();
        for(int i = 0; i < length; i += 1){
            for(Node node:buckets[i]){
                set.add(node.key);
            }
        }
        return set;
    }
    @Override
    public V remove(K key){ throw new UnsupportedOperationException();
    }
    @Override
    public V remove(K key, V value){ throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator(){
        return keySet().iterator();
    }




}
