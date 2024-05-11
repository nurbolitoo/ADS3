
import java.util.Iterator;

public class MyHashTable<K, V> {
    private static class HashNode<K, V> {
        private final K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + "=" + value + "}";
        }
    }

    private final MyArrayList<MyLinkedList<HashNode<K, V>>> chainArray;
    private int M = 11; // default number of chains
    private int size;

    public MyHashTable() {
        chainArray = new MyArrayList<>();
        for (int i = 0; i < M; i++) {
            chainArray.add(new MyLinkedList<>());
        }
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new MyArrayList<>();
        for (int i = 0; i < M; i++) {
            chainArray.add(new MyLinkedList<>());
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }

    public void put(K key, V value) {
        int index = hash(key);
        MyLinkedList<HashNode<K, V>> chain = chainArray.get(index);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        for (HashNode<K, V> node : chain) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        chain.add(newNode);
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        MyLinkedList<HashNode<K, V>> chain = chainArray.get(index);
        for (HashNode<K, V> node : chain) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public V remove(K key){
        int index = hash(key);
        MyLinkedList<HashNode<K,V>> chain=chainArray.get(index);
        Iterator<HashNode<K,V>> iterator= chain.iterator();
        while(iterator.hasNext()){
            HashNode<K,V> node = iterator.next();
            if(node.key.equals(key)){
                iterator.remove();
                size--;
                return node.value;
            }
        }
        return null;
    }

    public boolean cont(V value){
        for (MyLinkedList<HashNode<K,V>> chain : chainArray){
            for (HashNode<K,V> node : chain){
                if(node.value.equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    public K getKey(V value){
        for (MyLinkedList<HashNode<K,V>> chain : chainArray){
            for(HashNode<K,V> node : chain){
                if(node.value.equals(value)){
                    return node.key;
                }
            }
        }
        return null;
    }
    public void printBucketSizes() {
        MyList<Integer> bucketSizes = new MyArrayList<>();
        for (MyLinkedList<HashNode<K, V>> chain : chainArray) {
            bucketSizes.add(chain.size());
        }
        System.out.println("Number of elements in each bucket: " + bucketSizes);
    }



}