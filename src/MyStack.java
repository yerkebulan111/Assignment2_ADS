public class MyStack <T extends Comparable<T>> {
    private MyArrayList<T> array;

    public MyStack() { array = new MyArrayList<>(); }

    public boolean empty() {
        if (array.size() == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return array.size();
    }

    public T peek() {
        if (empty()) {
            return null;
        }
        return array.getLast();
    }

    public T push(T item) {
        array.add(item);
        return item;
    }

    public T pop() {
        if (empty()) {
            return null;
        }
        T last = array.getLast();
        array.removeLast();
        return last;
    }

    public void clean() {
        array.clear();
    }


}
