public class LinkedList{
    public static void main(String[] args) {
        // made up of many Nodes
        // a Node is a container for data
        // inherently ordered data structure
        // node pointing to Null = last node
        // first node = head
        // last node = tail

        // very similar to Array;
        // array indie = linked list node
        // array data must all be stored next to each other in memory
        LinkedList list = new LinkedList();
        for (int i = 1; i < 11; i++) {
            insert(list, i);
        }
        //printList(list);
        recursivePrint(list.head);
    }
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, int data){
        Node new_node = new Node(data);
        if(list.head == null){
            // this means the LinkedList is empty
            list.head = new_node;
        }
        else
        {
            Node last = list.head;
            while(last.next != null){
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static void printList(LinkedList list){
        Node currentNode = list.head;
        System.out.print("LinkedList: ");
        while(currentNode != null){
            // print the data
            System.out.print(currentNode.data + " ");
            // move to the next node
            currentNode = currentNode.next;
        }
    }

    public static void recursivePrint(Node head){
        Node currentNode = head;
        if(currentNode == null) return;
        // by switching the two lines of code below you can print in reverse
        recursivePrint(currentNode.next);
        System.out.print(currentNode.data + " ");
    }

//    public static LinkedList deletionByValue(LinkedList list, int data){
//
//    }
}