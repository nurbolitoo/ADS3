
import java.util.Iterator;


public class MyLinkedList<T> implements MyList<T> {
    private static class MyNode<T> {
        T data;
        MyNode<T> next;
        MyNode<T> prev;

        MyNode(T item) {
            this.data = item;
            this.next = null;
            this.prev = null;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    @Override
    public void set(int index, T item) {
        MyNode<T> node = getNodeAtIndex(index);
        node.data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index == size) {
            add(item);
            return;
        }
        MyNode<T> newNode = new MyNode<>(item);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            MyNode<T> current = getNodeAtIndex(index);
            MyNode<T> prev = current.prev;
            newNode.next = current;
            newNode.prev = prev;
            prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        MyNode<T> node = getNodeAtIndex(index);
        return node.data;
    }

    @Override
    public T getFirst() {
        return head.data;
    }

    @Override
    public T getLast() {
        return tail.data;
    }

    @Override
    public void remove(int index) {
        MyNode<T> node = getNodeAtIndex(index);
        removeNode(node);
    }

    @Override
    public void removeFirst() {
        removeNode(head);
    }

    @Override
    public void removeLast() {
        removeNode(tail);
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data == object)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data == object)
                return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode<T> current = head;
        int index = 0;
        while (current != null) {
            arr[index++] = current.data;
            current = current.next;
        }
        return arr;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) new MyIterator<>();
    }

    @Override
    public MyList.MyIterator<T> myIterator() {
        return new MyIterator<>();
    }

    private MyNode<T> getNodeAtIndex(int index) {
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void removeNode(MyNode<T> node) {
        if (node == head) {
            head = head.next;
            if (head != null)
                head.prev = null;
        } else if (node == tail) {
            tail = tail.prev;
            if (tail != null)
                tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }

    public class MyIterator<E> implements MyList.MyIterator<E> {
        private MyNode<T> cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            E data = (E) cursor.data;
            cursor = cursor.next;
            return data;
        }

        @Override
        public Iterator<E> iterator() {
            return null;
        }
    }
}