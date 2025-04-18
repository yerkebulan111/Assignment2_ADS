import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println();


        MyList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(5);
        myArrayList.add(23);
        myArrayList.add(3);
        myArrayList.add(8);
        myArrayList.add(16);
        myArrayList.add(37);
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(15);


        System.out.print("Array: ");
        Object[] arr = new Object[myArrayList.size()];
        arr = myArrayList.toArray();
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

       myArrayList.sort();

        System.out.print("Array: ");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(myArrayList.size());


        System.out.println();
        System.out.println("----------------------------");


        MyList<Integer> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(11);
        myLinkedList.add(2);
        myLinkedList.add(37);
        myLinkedList.add(4);
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(7);
        myLinkedList.add(9);

        Object[] linkedList = myLinkedList.toArray();
        System.out.print("Linked List: ");
        for (Object item : linkedList) {
            System.out.print(item + " ");
        }
        System.out.println();


        myLinkedList.sort();


        System.out.print("Linked List: ");
        Object[] linkedList2 = myLinkedList.toArray();
        for (Object item : linkedList2) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println(myLinkedList.size());


    }
}
