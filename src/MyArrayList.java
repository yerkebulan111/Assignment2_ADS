import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] array;
    private int size = 0;
    private int capacity = 10;

    public MyArrayList() { array = new Object[capacity]; }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    @Override
    public void add(T item) {
        capacityRegulation();
        array[size++] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Given index is out of bounds." + " Index: " + index + ", Size: " + size);
        }

        capacityRegulation();

        for(int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = item;
        size++;
    }

    @Override
    public void set(int index, T item) {
        array[index] = item;
    }

    @Override
    public void addFirst(T item) {
        capacityRegulation();

        for(int i = size - 1; i > 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        capacityRegulation();
        array[size] = item;
        size++;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public T getFirst() {
        return (T) array[0];
    }

    @Override
    public T getLast() {
        return (T) array[size - 1];
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort(){
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T a = (T) array[j];
                T b = (T) array[j + 1];
                if (a.compareTo(b) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object == array[i]) {
                return i;
            }
        }
        throw new IllegalArgumentException("Object not found");
    }


    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (object == array[i]) {
                return i;
            }
        }
        throw new IllegalArgumentException("Object not found");
    }


    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (object == array[i]) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public void clear() {
        this.capacity = 10;
        this.array = new Object[capacity];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }




    private void increaseCapacity() {
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        for(int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private void capacityRegulation() {
        if (size == capacity) {
            increaseCapacity();
        }
    }

    private void swap(int index1, int index2) {
        Object temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}