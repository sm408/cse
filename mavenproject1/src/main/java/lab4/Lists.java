package lab4;

/**
 *
 * Name: Shubham Maurya 
 * Roll No.: 2010110615 
 * Course: CSD213
 */
class LinkedList {

    Node head;

    class Node {

        int a;
        Node next;

        public Node(int data) {
            a = data;
            next = null;
        }
    }

    public LinkedList insert(LinkedList list, int data) {
        Node temp = new Node(data);

        if (list.head == null) {
            list.head = temp;
        } 
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = temp;
        }
        return list;
    }
    
    public LinkedList insert(LinkedList list, int data, int pos) {
        Node temp = new Node(data);
        int count = 1;

        if (list.head == null && pos==0) {
            list.head = temp;
        } 
        else if(pos == 0){
            temp.next = head;
            list.head= temp;
        }
        else {
            Node last = list.head;
            while (last.next != null) {
                if(count == pos){
                    break;
                }
                count++;
                
                last = last.next;
            }
            temp.next = last.next;

            last.next = temp;
        }
        return list;
    }

    public void printList(LinkedList list) {
        Node current = list.head;

        System.out.println("Data in Linked List:\n");

        while (current != null) {
            System.out.print(current.a + " ");
            current = current.next;
        }

    }
    
    public LinkedList delete(LinkedList list, int data){
        Node current = list.head;
        
        if (current.a == data){
            head = head.next;
            return list;
        }

        while (current != null) {
            if(current.next.a==data){
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
        return list;
    }
}

public class Lists{
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
       // list = list.delete(list, 5);
        list = list.insert(list, 16,5);
        
        list.printList(list);
    }
}