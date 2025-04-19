# Data Structures
## Physical Data Structures
### MyArrayList<T>
### MyLinkedList<T>
## Logical Data Structures
### MyStack<T> (with ArrayList)
1. boolean empty()
2. int size()
3. peek()
4. push()
5. pop()
6. clear()
### MyQueque<T> (with LinkedList)
1. boolean empty()
2. int size()
3. peek()
4. enqueque()
5. dequeque()
6. clear()
### MyMinHeap<T> (with ArrayList)
Public:
1. boolean empty()
2. int size()
3. getMin()
4. extractMin()
5. insert(T item)
6. clear()
7. getArrOfHeap()

Private:
8. heapify(int index)
9. traverseUp(int index)
10. int leftChildOf(int index)
11. int rightChildOf(int index)
12. int parentOf(int index)
13. swap(int index1, int index2)
