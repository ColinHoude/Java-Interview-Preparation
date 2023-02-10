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

        // testing print functions
        // -----------------------
        printList(list);
        System.out.println();

        //recursivePrint(list.head);
//        list = reverseList(list);
//        printList(list);

        // testing merge function
        LinkedList list2 = new LinkedList();
        for(int i = 10; i > 0; i--){
            insert(list2, i);
        }

        printList(list2);
        System.out.println();
        LinkedList mergedList = mergeTwoUnsortedList(list, list2);
        printList(mergedList);
        System.out.println();

        // testing Reorder List Leetcode problem

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

    public static int size(LinkedList list){
        int size = 0;
        Node currentNode = list.head;
        if(currentNode == null) return 0;
        while(currentNode != null){
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    public static void recursivePrint(Node head){
        Node currentNode = head;
        if(currentNode == null) return;
        // by switching the two lines of code below you can print in reverse
        recursivePrint(currentNode.next);
        System.out.print(currentNode.data + " ");
    }

    public static LinkedList deletionByValue(LinkedList list, int data){
        Node currentNode = list.head, previousNode = null;
        // base case -- the head is the node to be deleted
        if(currentNode != null && currentNode.data == data){
            list.head = currentNode.next;
            return list;
        }

        // case 2: -- the value is not the head node and need to traverse to find it
        while(currentNode != null && currentNode.data != data){
            // continue to next node
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        // if it gets to this point it has either
            // 1 - found the key
            // 2 - reached the end and has not found the key

        // 1 - it has found the key
        if(currentNode != null){
            // delete it by making the previous node point to the next node of the current
            // A -> B -> C
            previousNode.next = currentNode.next;
            // A -> C
        }

        if(currentNode == null){
            // this means it has reached the end and has not found the data value
            System.out.println(data + " not found...");
        }
        return list;
    }

    public static LinkedList deletionByPosition(LinkedList list, int position){
        Node currentNode = list.head, previousNode = null;
        int counter = 0;
        // base case -- the 0th position is the node to be deleted
        if(currentNode != null && counter == position){
            list.head = currentNode.next;
            return list;
        }

        // case 2: -- the position to be deleted is not 0 and need to traverse to find it
        while(currentNode != null && counter != position){
            // continue to next node
            previousNode = currentNode;
            currentNode = currentNode.next;
            counter++;
        }

        // if it gets to this point it has either
        // 1 - found the key
        // 2 - reached the end and has not found the key

        // 1 - it has found the key
        if(currentNode != null){
            // delete it by making the previous node point to the next node of the current
            // A -> B -> C
            previousNode.next = currentNode.next;
            // A -> C
        }

        if(currentNode == null){
            // this means it has reached the end and has not found the data value
            System.out.println();
            System.out.print("Position out of bounds... ");
        }
        return list;
    }

    public static LinkedList reverseList(LinkedList list){
        // going to basically use recursion
        // we need a new list to return
        LinkedList retList = new LinkedList();
        recursiveInt(retList, list.head);
        return retList;
    }

    public static void recursiveInt(LinkedList newList, Node head){
        // basically the recursive print function
        Node currentNode = head;
        if(currentNode == null) return;
        recursiveInt(newList, currentNode.next);
        insert(newList, currentNode.data);
    }

    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2){
        // create a new list to return
        LinkedList retList = new LinkedList();
        Node currentl1 = l1.head;
        Node currentl2 = l2.head;
        while(currentl1 != null || currentl2 != null){
            if(currentl1 != null && (currentl1.data <= currentl2.data)){
                insert(retList, currentl1.data);
                currentl1 = currentl1.next;
            }
            else {
                insert(retList, currentl2.data);
                currentl2 = currentl2.next;
            }
        }

        return retList;
    }
    public static LinkedList mergeTwoUnsortedList(LinkedList l1, LinkedList l2){
        LinkedList retList = new LinkedList();
        Node currentl1 = l1.head;
        Node currentl2 = l2.head;
        while(currentl1 != null || currentl2 != null){
            if(currentl1 != null){
                insert(retList, currentl1.data);
                currentl1 = currentl1.next;
            }
            else {
                insert(retList, currentl2.data);
                currentl2 = currentl2.next;
            }
        }

        return retList;
    }

    public static void reorderList(LinkedList list){
        // going to converge on the middle
        // need to first find the middle
        Node slow = list.head, fast = list.head, prev = null;
        while(fast != null && fast.next != null){
            // for every one slow goes next to -- fast goes 2x next
            // hence slow = 1/2 fast and when fast reaches the end slow will be at the middle of the list
            slow = slow.next;
            fast = fast.next.next;
        }

        // make a new list that stores the 


}