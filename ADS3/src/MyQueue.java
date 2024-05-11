
public class MyQueue<T> {
    private final MyList<T> list;

    public MyQueue() {
        this.list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T peek() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return list.size();
    }
}