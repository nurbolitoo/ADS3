

import java.util.ArrayList;
import java.util.List;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size;


    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node node, K key, V val) {
        if (node == null) {
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, val);
        else if (cmp > 0) node.right = put(node.right, key, val);
        else node.val = val;
        return node;
    }

    public V get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else return current.val;
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = delete(node.left, key);
        else if (cmp > 0) node.right = delete(node.right, key);
        else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        size--;
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public Iterable<K> iterator() {
        MyArrayList<K> list = new MyArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    private void inOrderTraversal(Node node, MyArrayList<K> list) {
        if (node == null) return;
        inOrderTraversal(node.left, list);
        list.add(node.key);
        inOrderTraversal(node.right, list);
    }

    private V getValue(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else return current.val;
        }
        return null;
    }

    private class KeyValEnt{
        private K key;
        private V value;

        public KeyValEnt(K key,V value){
            this.key=key;
            this.value = value;

        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }

    public Iterable<KeyValEnt> keyValIter(){
        List<KeyValEnt> list = new ArrayList<>();
        inOrTravKeyVal(root,list);
        return list;
    }

    private void inOrTravKeyVal(Node node,List<KeyValEnt> list){
        if(node==null){
            return;
        }
        inOrTravKeyVal(node.left,list);
        list.add(new KeyValEnt(node.key,node.val));
        inOrTravKeyVal(node.right,list);
    }
    public int size(){
        return size;
    }
}
