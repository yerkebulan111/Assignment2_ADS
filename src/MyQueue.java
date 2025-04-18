public class MyQueue<T extends Comparable<T>>  {
    private MyLinkedList<T> linlist;

    public MyQueue() {
        linlist = new MyLinkedList<>();
    }

    public boolean empty() {
        if(linlist.size() == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return linlist.size();
    }

    public T peek() {
        if(linlist.size() == 0) {
            return null;
        }
        return linlist.get(0);
    }

    public T enqueque(T item) {
        linlist.add(item);
        return item;
    }

    public T dequeque() {
        if(linlist.size() == 0) {
            return null;
        }
        T removed = linlist.getFirst();
        linlist.removeFirst();
        return removed;
    }

    public void clear() {
        linlist.clear();
    }
}
