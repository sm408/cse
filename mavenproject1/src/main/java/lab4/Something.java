package lab4;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */

class LinkedList {
    Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public LinkedList insert(LinkedList list, int data) {

        Node new_node = new Node(data);

        if (list.head == null) {
            list.head = new_node;
        } 
        else {

            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }

        return list;
    }

    public void printList(LinkedList list) {
        Node current = list.head;

        System.out.print("LinkedList: ");

        while (current != null) {

            System.out.print(current.data + " ");

            current = current.next;
        }
    }
}
public class Something {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list = list.insert(list, 1);
        list = list.insert(list, 2);
        list = list.insert(list, 3);
        list = list.insert(list, 4);
        list = list.insert(list, 5);
        list = list.insert(list, 6);
        list = list.insert(list, 7);
        list = list.insert(list, 8);

        list.printList(list);
    }
}
