/**
 * Created by JIJUNJIANG    on 05/05/2017.
 * jiangjijun1994@gmail.com
 * it is an struction of HashMap with initial capacity of 2 and load factor 0.75
 * size()
 * isEmpty()
 * clear
 * put(K key, V value)
 * get(K key)
 * containsKey(K key)
 * remove()
 */

import java.util.*;

public class MyHashMap<K, V> {

    public static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static final int DEFALT_CAPACITY = 2;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node<K, V>[] array;
    private int size;
    private float loadFactor;

    public MyHashMap(int cap, float loadFactor) {
        if(cap <= 0) {
            throw new IllegalArgumentException("cap can not be <= 0");
        }
        this.array = (Node<K, V>[])(new Node[cap]); //java limitation can only althority transform array type
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    public MyHashMap() {
        this(DEFALT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(this.array, null);
        size = 0;
    }

    public int hash(K key) {
        if (key == null) {
            return 0;
        }
        return key.hashCode() & 0X7FFFFFFF;
    }

    private int getIndex(K key) {
        return hash(key) % array.length;
    }

    private boolean equalsValue(V v1, V v2) {
        return v1 == v2 || v1 != null && v2!= null && v1.equals(v2);
    }

    private boolean equalsKey(K k1, K k2) {
        return k1 == k2 || k1 != null && k2 != null && k1.equals(k2);
    }

    public boolean containsValue(V value) {
        if(isEmpty()) {
            return false;
        }
        for (Node<K, V> node : array) {
            while (node != null) {
                if (equalsValue(node.value, value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V>node = array[index];
        while (node != null) {
            if (equalsKey(node.key, key)) {
                return node.value;
            }
            node = node.next;
        }

        return null;
    }

    public V put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> node = head;
        while (node != null) {
            if (equalsKey(node.key, key)) {
                V result = node.value;
                node.value = value;
                return result;
            }
            node = node.next;
        }
        Node<K, V> newNode = new Node(key, value);
        newNode.next = head;
        array[index] = newNode;
        size ++;
        if (needRehashing()) {
            rehashing();
        }
        return null;

    }

    private boolean needRehashing() {
        float ratio = (float)size / array.length;
        return ratio >= loadFactor;
    }

    private boolean rehashing() {
        int newcap = array.length * 2;
        Node<K, V> copyList = (Node<K, V>) new Node(null, null);
        Node<K, V> copyHead = copyList;
        Node<K, V> copyNode = copyHead;

        for (int i = 0; i < array.length; i++) {
            Node<K, V> node = array[i];
                while (node != null) {
                    Node<K, V> addedNode = new Node(node.key, node.value);
                    copyNode.next = addedNode;
                    copyNode = copyNode.next;
                    node = node.next;
                }
        }
        size = 0;
        this.array = (Node<K, V>[])new Node[newcap];
        copyList = copyList.next;
        Node<K, V> head = copyList;
        Node<K, V> node = head;
        while (node!= null) {
            put( node.key, node.value);
            node = node.next;
        }

        return true;
    }

    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        if (equalsKey(head.key, key)) {
            V result = head.value;
            array[index] = null;
            size--;
            return result;
        }
        Node<K, V> node = head;
        Node<K, V> pre = node;
        node = head.next;
        while (node != null) {
            if (equalsKey(node.key, key)) {
                V result = node.value;
                pre.next = node.next;
                array[index] = head;
                size--;
                return result;
            }
            pre = node;
            node = node.next;
        }

        return null;

    }

}







