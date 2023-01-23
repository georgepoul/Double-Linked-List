import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/***
 * created by gp
 */
class MyListTest {

    MyList list = new MyList();

    @Test
    void getHead() {

        //given
        int head = 10;
        list.addFirst(head);

        //when

        //then
        assertEquals(list.getHead().getData(), head);
    }

    @Test
    void setHead() {

        //given
        Node head = new Node(100);

        //when

        //then
        assertEquals(head.getData(), 100);
    }

    @Test
    void getLength() {


        //given
        list.addFirst(10);
        list.addFirst(20);

        //when

        //then
        assertEquals(list.getLength(), 2);
    }

    @Test
    void addFirst() {

        //given
        list.addFirst(100);
        list.addFirst(200);

        //when

        //then
        assertEquals(list.getHead().getData(), 200);
    }

    @Test
    void addLast() {

        //given
        list.addLast(100);
        list.addLast(200);

        //when

        //then
        assertEquals(list.getHead().getNext().getData(), 200);
    }

    @Test
    void removeLast() {
        //given
        list.addLast(100);
        list.removeLast();

        //when

        //then
        assertNull(list.getHead());

    }

    @Test
    void addInPlace() {

        //given
        list.addFirst(100);


        list.addInPlace(0, 1);
        list.addInPlace(1, 100);
        list.addInPlace(4, 500);

        //when

        //then

        assertEquals(list.getHead().getData(), 1);
        assertEquals(list.getHead().getNext().getData(), 100);
        assertEquals(list.getHead().getNext().getNext().getData(), 100);
        assertEquals(list.getHead().getNext().getNext().getNext().getData(), 0);
        assertEquals(list.getHead().getNext().getNext().getNext().getNext().getData(), 500);

    }

    @Test
    void minimum() {

        // given
        list.addFirst(100);


        list.addInPlace(0, 1);
        list.addInPlace(1, 100);
        list.addInPlace(4, 500);

        // when

        // then
        assertEquals(0, list.minimum(list.getHead()).getData());

    }

    @Test
    void selectionSort() {

        // given
        list.addFirst(100);


        list.addInPlace(0, 1);
        list.addInPlace(1, 100);
        list.addInPlace(4, 500);

        // when
        list.selectionSort();

        // then
        assertEquals(0, list.getHead().getData());
        assertEquals(1, list.getHead().getNext().getData());
        assertEquals(100, list.getHead().getNext().getNext().getData());
        assertEquals(100, list.getHead().getNext().getNext().getNext().getData());
        assertEquals(500, list.getHead().getNext().getNext().getNext().getNext().getData());
    }

    @Test
    void bubbleSort() {

        // given
        list.addFirst(100);


        list.addInPlace(1, 1);
        list.addInPlace(1, 100);
        list.addInPlace(4, 500);

        // when
        list.bubbleSort();

        // then
        assertEquals(0, list.getHead().getData());
        assertEquals(1, list.getHead().getNext().getData());
        assertEquals(100, list.getHead().getNext().getNext().getData());
//       ds
    }
}