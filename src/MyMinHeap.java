public class MyMinHeap<T extends Comparable<T>> {
    MyArrayList<T> array;

    public MyMinHeap() {
        array = new MyArrayList<>();
        array.add(null);
    }

    public boolean empty() {
        if (array.size() == 0) return true;
        return false;
    }

    public int size() {
        return array.size() - 1;
    }

    public T getMin() {
        if (array.size() == 0) return null;
        return (T) array.get(1);
    }

    public T extractMin() {
        array.set(1, array.get(array.size() - 1));
        array.removeLast();
        heapify(1);
        return array.get(1);
    }

    public void insert(T item) {
        array.add(item);
        traverseUp(array.size() - 1);
    }


    public Object[] getArrOfHeap() {
        return array.toArray();
    }


//PRIVATE METHODS:

    private void heapify(int index) {
        if(array.get(leftChildOf(index)) == null) {return;}
        if(array.get(rightChildOf(index)) == null) {
            T a = array.get(index);
            T b = array.get(leftChildOf(index));
            if(a.compareTo(b) > 0) {
                swap(index, leftChildOf(index));
                heapify(leftChildOf(index));
            }
        }
        else {
            T a = array.get(index);
            T b = array.get(leftChildOf(index));
            T c = array.get(rightChildOf(index));
            if(c.compareTo(b) > 0 && a.compareTo(b) > 0) {
                swap(index, leftChildOf(index));
                heapify(leftChildOf(index));
            }
            else if (b.compareTo(c) > 0 && a.compareTo(c) > 0) {
                swap(index, rightChildOf(index));
                heapify(leftChildOf(index));
            }
        }

    }

    private void traverseUp(int index) {
        if (index == 1) return;
        T a = (T) array.get(index);
        T b = (T) array.get(parentOf(index));
        if (b.compareTo(a) > 0) {
            swap(index, parentOf(index));
            traverseUp(parentOf(index));
        }
    }

    private int leftChildOf(int index) {
        return 2 * index;
    }

    private int rightChildOf(int index) {
        return 2 * index + 1;
    }

    private int parentOf(int index) {
        return index / 2;
    }

    private void swap(int index1, int index2) {
        T temp = (T) array.get(index1);
        array.set(index1, (T) array.get(index2));
        array.set(index2, temp);
    }



}
