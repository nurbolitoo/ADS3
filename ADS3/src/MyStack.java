
public class MyStack<T>  {
    private final MyList<T> list;

    public MyStack() {
        this.list = new MyArrayList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        T item = list.get(size() - 1);
        list.remove(size() - 1);
        return item;
    }

    public T peek() {
        return list.get(size() - 1);
    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return list.size();
    }
}