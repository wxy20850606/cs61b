package bstmap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V>  implements Map61B<K, V> {
    int size = 0;
    private BSTNode root;
    public BSTMap(){
        root = null;
        size = 0;
    }
    private class BSTNode {
        public K key;
        public V value;
        public BSTNode left;
        public BSTNode right;

        //constructor
        public BSTNode(K k, V v) {
            key = k;
            value = v;
        }
    }
    @Override
    public void clear() {
        size = 0;
        root = null;
    }
    @Override
    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key) {
        if (root == null) {
            return false;
        }
        return get(key) != null;
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return get(root,key);
    }


    private V get(BSTNode node, K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) > 0){
            return get(node.right,key);
        }
        else if(key.compareTo(node.key) < 0){
            return get(node.left,key);
        }
        return node.value;
    }

    @Override
    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }
    @Override
    /* Associates the specified value with the specified key in this map. */
    public void put(K key, V value) {

         root=putHelper(root,key,value);
    }
    private BSTNode putHelper(BSTNode x,K key,V value){
        if(x == null){
            size = size + 1;
            return new BSTNode(key,value);
        }
        if(key.compareTo(x.key) < 0){
           x.left = putHelper(x.left,key,value);
        }
        if(key.compareTo(x.key) > 0){
           x.right= putHelper(x.right,key,value);
        }
        if(key==x.key){
            x.value = value;
        }
        return x;
    }
    @Override
    /* Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        addKey(root,set);
        return set;
    }

    private void addKey(BSTNode node,Set<K> set){
        if(node == null){
            return;
        }
        set.add(node.key);
        addKey(node.left,set);
        addKey(node.right,set);
    }
    @Override
    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }


    @Override
    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    public V remove(K key, V value) {
        if(containsKey(key)){
        V val = get(key);
        if(val.equals(value)){
            root = removeHelper(root,key,value);
            size = size - 1;
            return val;
            }
        }
        return null;
    }
    private BSTNode removeHelper(BSTNode node,K key, V value){
        //find node key need to be removed
        if(key.compareTo(node.key) == 0){
            //if node to be removed have no child
            if(node.left == null && node.right == null){
                return null;
            }
            //if node to be removed have right child
            if(node.left == null && node.right != null){
                return node.right;
            }
            //if node to be removed have 1 left child
            if(node.left != null && node.right == null){
                return node.left;
            }
            //if node have 2 children
            else{
                BSTNode predecessor = findPredecessor(node.left);
                node.key = predecessor.key;
                node.value = predecessor.value;
                    return node;
            }
        }
        //search the right part to find the key
        if(key.compareTo(node.key) > 0){
            node.right = removeHelper(node.right,key,value);
        }
        //search the left part to find the key
        else{
            node.left = removeHelper(node.left,key,value);
        }
        return node;
    }

    //find predecessor,copy to make a new node,delete it and return the new node
    private BSTNode findPredecessor(BSTNode node){
        if(node.right.right == null){
            BSTNode predecessor = new BSTNode(node.right.key,node.right.value);
            //if predecessor have no child
            if(node.right.left== null){
                node.right = null;}
            //if the predesessor have 1 left child
            else{
                node.right = node.right.left;
            }
            return predecessor;
        }
        return findPredecessor(node.right);
    }
    @Override
    public Iterator<K> iterator(){
        return keySet().iterator();
    }

    public void printInOrder(){
        printHelper(root);
    }

    private void printHelper(BSTNode node){
    if(node == null){
        return;
    }
    printHelper(node.left);
    System.out.println(node.key.toString() + ":" + node.value.toString());
    printHelper(node.right);
    }
    public static void main(String[] args){
        BSTMap a = new BSTMap();
        a.put("d",1);
        a.put("b",2);
        a.put("f",3);
        a.put("a",4);
        a.put("cm",5);
        a.put("elf",6);
        a.put("eye",7);
        a.put("g",8);
        a.put("cf",9);
        a.printInOrder();
        a.keySet();
    }
}
