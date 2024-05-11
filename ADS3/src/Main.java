public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass("Key" + i);
            Student value = new Student("Name" + i);
            table.put(key, value);
        }

        table.printBucketSizes();

        BST<Integer, String> tree = new BST<>();
        tree.put(5, "Five");
        tree.put(2, "Two");
        tree.put(8, "Eight");
        tree.put(1, "One");
        tree.put(3, "Three");

        System.out.println("Size: " + tree.size());

        System.out.println("Inorder traversal:");
        for (Integer key : tree.inOrderTraversal()) {
            System.out.println("Key is " + key + " and value is " + tree.get(key));
        }
    }
}
