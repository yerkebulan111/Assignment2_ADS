import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size = 0;

    public MyLinkedList() {}

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        MyNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
        }
        else if (index == size) {
            addLast(item);
        }
        else {
            MyNode<T> newNode = new MyNode<>(item);
            MyNode<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode;
            newNode.prev = currentNode.prev;
            currentNode.prev.next = newNode;
            currentNode.prev = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        MyNode<T> currentNode = head;
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
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
        if(index == size - 1) {
            removeLast();
        }
        else {
            MyNode<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }
        size--;
    }

    @Override
    public void removeFirst() {
        if (head == null) {
            return;
        }
        if (size == 1) {
            head = tail = null;
        }
        else {
            head = head.next;
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (head == null) {
            return;
        }
        if (size == 1) {
            head = tail = null;
        }
        else {
            tail = tail.prev;
        }
        size--;
    }

    @Override
    public void sort() {
        if (size < 2) return;

        for (int i = 0; i < size - 1; i++) {
            MyNode<T> current = head;

            for (int j = 0; j < size - i - 1; j++) {
                if (current.data.compareTo(current.next.data) > 0) {
                    swap(current, current.next);
                }
                current = current.next;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            if ((object == null && currentNode.data == null) || (object != null && object.equals(currentNode.data))) {
                return i;
            }
            currentNode = currentNode.next;
        }

        return -1; //when object not found
    }


    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> currentNode = tail;
        for (int i = size - 1; i >= 0; i--) {
            if ((object == null && currentNode.data == null) ||
                    (object != null && object.equals(currentNode.data))) {
                return i;
            }
            currentNode = currentNode.prev;
        }
        return -1; //when object not found
    }


    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        MyNode<T> current = head;

        for (int i = 0; i < size; i++) {
            result[i] = current.data;
            current = current.next;
        }

        return result;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {return size;}


    @Override
    public Iterator<T> iterator() {
        return null;
    }


    private static class MyNode<E> {
        E data;
        MyNode<E> next;
        MyNode<E> prev;

        MyNode(E data) {
            this.data = data;
        }
    }


    private void swap(MyNode<T> a, MyNode<T> b) {
        T temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

}