/***
 * created by gp
 */
public class MyList {

    private Node head;

    private Node tail;

    private int length;

    public MyList() {
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    /***
     * prints the nodes address
     */
    public void node_print(Node node) {

        System.out.println(node.getData());
    }

    public void printHead() {

        if (this.head == null) {
            System.out.println("The head is: null");
        } else {
            System.out.println("The head is: " + head.getData());
        }
    }

    /***
     * prints the hole list
     */
    public void printList() {

        Node current = head;

        while (current != null) {

            node_print(current);

            current = current.getNext();
        }
    }

    /***
     * add a node in the first place of my list
     * @param in data that I want to add to my list
     */
    public void addFirst(int in) {

        Node tmp = new Node(in);

        if (length > 0) {

            tmp.setNext(this.head);

            head.setPrevious(tmp);

        } else {

            tail = tmp;
        }

        this.head = tmp;

        length++;
    }

    /***
     * add a node in the last place of my list
     * @param in data that I want to add to my list
     */
    public void addLast(int in) {

        Node tmp = new Node(in);

        if (length == 0) {

            tail = head = tmp;

        } else {

            tmp.setPrevious(tail);

            tail.setNext(tmp);

            tail = tmp;
        }

        this.length++;

    }

    /***
     * remove the last node of the list
     * @return -1 if the list is empty or the data of the node I removed
     */
    public int removeLast() {

        Node current = head;

        int result = -1;

        if (length == 0) {

            System.out.println("List is empty");

        } else if (length == 1) {

            result = head.getData();

            head = tail = null;

            this.length--;

        } else {

            result = tail.getData();

            tail = tail.getPrevious();

            tail.setNext(null);

            length--;

        }

        return result;
    }

    /***
     * Adds a value in a specific position
     * if the position is in upper out of the list then adds zero data nudes and the value in the position we want
     * if the position is not valid print a message
     * @param position the position for the value to be added
     * @param value the value to be added
     */
    public void addInPlace(int position, int value) {

        Node current = head;

        int isInplace = 0;

        if (position == 0) {

            addFirst(value);

        } else if (position > 0 && position < this.length) {

            while (isInplace != position - 1) {

                current = current.getNext();

                isInplace++;
            }

            Node newNode = new Node(value);

            current.getNext().setPrevious(newNode);

            newNode.setNext(current.getNext());

            current.setNext(newNode);

            newNode.setPrevious(current);

            isInplace++;

            System.out.println("The value: " + value + " added in position: " + isInplace);

            length++;

        } else if (position > this.length) {

            for (int i = this.length; i < position; i++) {

                addLast(0);
            }

            addLast(value);

            System.out.println("The value: " + value + " added in position: " + position);

        } else {

            System.out.println("The position you have insert is not valid. Please try again");

        }
    }

    /***
     * Finds the minimum data in the list
     * @param first the first element of the list that methode starts
     * @return the Node with the minimum data
     */
    public Node minimum(Node first) {

        printList();
        System.out.println("=======================================");
        Node min = first;


        if (first != this.tail) {
            Node current = first.getNext();

            while (current != null) {

                if (min.getData() > current.getData()) {

                    min = current;
                }

                current = current.getNext();
            }
        }

        return min;
    }


    public void selectionSort() {

        Node cursor = this.head;

        for (int i = 0; i < this.length - 1; i++) {

            Node min = minimum(cursor);

            if (cursor != min) {

                if (cursor == head && min == tail) {

                    if (cursor.getNext() != min) {
                        min.setNext(this.head.getNext());
                        cursor.setNext(null);
                        cursor.setPrevious(min.getPrevious());

                        cursor.getPrevious().setNext(cursor);

                        min.setPrevious(null);

                        min.getNext().setPrevious(min);


                        head = min;

                    } else {

                        cursor.setPrevious(min.getPrevious());

                        min.setNext(cursor.getNext());
                        min.setPrevious(null);

                        head = min;

                        cursor.setNext(null);

                    }
                    tail = cursor;
                    cursor = min;

                } else if (cursor == head) {

                    if (cursor.getNext() != min) {

                        cursor.getNext().setPrevious(min);

                    }
                    min.getNext().setPrevious(cursor);
                    min.getPrevious().setNext(cursor);
                    cursor.setPrevious(min.getPrevious());
                    min.setPrevious(cursor.getNext());
                    cursor.setNext(min.getNext());
                    min.setNext(min.getPrevious());
                    min.setPrevious(null);

                    head = min;

                    cursor = min;

                } else if (min == tail) {

                    if (cursor.getNext() != min) {
                        min.setNext(cursor.getNext());
                        min.getPrevious().setNext(cursor);

                        cursor.getNext().setPrevious(min);
                        cursor.getPrevious().setNext(min);
                        cursor.setNext(min.getPrevious());

                        min.setPrevious(cursor.getPrevious());

                        cursor.setPrevious(cursor.getNext());
                        cursor.setNext(null);

                    } else {

                        cursor.getPrevious().setNext(min);

                        min.setPrevious(cursor.getPrevious());
                        min.setNext(cursor);

                        cursor.setPrevious(min);
                        cursor.setNext(null);

                    }

                    tail = cursor;

                    cursor = min;

                } else {

                    if (cursor.getNext() == min) {

                        min.getNext().setPrevious(cursor);
                        min.getNext().getPrevious().setNext(min.getNext());

                        cursor.getPrevious().setNext(min);

                        min.setPrevious(cursor.getPrevious());

                        cursor.setNext(min.getNext());
                        cursor.setPrevious(min);

                        min.setNext(cursor);

                        cursor = min;

                    } else {

                        Node help;

                        cursor.getPrevious().setNext(min);
                        cursor.getNext().setPrevious(min);

                        min.getNext().setPrevious(cursor);
                        min.getPrevious().setNext(cursor);

                        help = cursor.getPrevious();

                        cursor.setPrevious(min.getPrevious());

                        min.setPrevious(help);

                        help = cursor.getNext();

                        cursor.setNext(min.getNext());

                        min.setNext(help);

                        cursor = min;
                    }
                }
            }
            cursor = cursor.getNext();
        }
    }
}

