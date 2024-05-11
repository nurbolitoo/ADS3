

public interface MyList<T> extends Iterable<T> {
    void add(T item);
    void set(int index, T item);
    void remove(int index);
    void add(int index, T item);
    void addFirst(T item);
    void addLast(T item);
    T get(int index);
    T getFirst();
    T getLast();
    void removeFirst();
    void removeLast();
    void sort();
    int indexOf(Object object);
    int lastIndexOf(Object object);
    boolean exists(Object object);
    Object[] toArray();
    void clear();
    int size();
    MyList.MyIterator<T> myIterator();
    interface MyIterator<E> extends Iterable<E> {

        boolean hasNext();

        E next();
    }

}