/***
 * created by gp
 */
public class Main {

    public static void main(String[] args) {

        MyList list = new MyList();

        list.printHead();

        System.out.println("The list length is: " + list.getLength());

        System.out.println("Removed " + list.removeLast());


        list.addFirst(10);
        list.addFirst(15);

        System.out.println("The list length is: " + list.getLength());

        list.addFirst(30);
        list.addLast(9);
        list.addLast(5);


        System.out.println("The list length is: " + list.getLength());


        System.out.println("Removed " + list.removeLast());

        list.printHead();

        list.printList();

        System.out.println("The list length is: " + list.getLength());

        list.addInPlace(3 , 100);

        list.addLast(1000);

        list.printHead();

        list.printList();

        System.out.println("The list length is: " + list.getLength());

        System.out.println("==============================================================================================");


        list.printList();

        System.out.println("==============================================================================================");

        list.bubbleSort();

        list.printList();




//        list.selectionSort();
//
//        System.out.println("==============================================================================================");
//
//        list.printList();

    }
}