import java.util.*;

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
        LinkedList list2 = new LinkedList();
        Random rand = new Random();
        int randInt;
        for (int i = 0; i < 25; i++) {
            randInt = rand.nextInt(1,20);
            insert(list2, randInt);
        }


        // testing print functions
        // -----------------------
        printList(list2);
        System.out.println();

        //recursivePrint(list.head);
//        list = reverseList(list);
//        printList(list);

        // testing merge function
//        LinkedList list2 = new LinkedList();
//        for(int i = 10; i > 0; i--){
//            insert(list2, i);
//        }


        // testing Reorder List Leetcode problem
//        reorderList(list);

        // testing addTwoNumber
        //addTwoNumber(list, list2);

        // testing sum function of one list
        //sumNumbers(list2);
        getValueAtIndex(list2, 10);
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
        int counter = 0;
        while(currentl1 != null || currentl2 != null){
            if(currentl1 != null && counter %2 == 0){
                insert(retList, currentl1.data);
                currentl1 = currentl1.next;
            }
            else {
                insert(retList, currentl2.data);
                currentl2 = currentl2.next;
            }
            counter++;
        }

        return retList;
    }

    public static void reorderList(LinkedList list){
        // to solve this problem I:
            // made two separate Lists
            // first half list
            // second half list
        // reversed the second half
        // merged the first and second half lists together

        if(list.head == null) return;

        // make 2 seperate lists
        LinkedList firstHalf = new LinkedList();
        LinkedList secondHalf = new LinkedList();
        int counter = 0;
        int sizeOfList = size(list);
        Node currentNode = list.head;
        while(currentNode != null){
            if(counter < sizeOfList /2){
                // this is the first half
                insert(firstHalf, currentNode.data);
            }
            else {
                insert(secondHalf, currentNode.data);
            }
            counter++;
            currentNode = currentNode.next;
        }

        // now we have two separate lists of the first and second half
        // reverse the 2nd half list
        secondHalf = reverseList(secondHalf);
        printList(firstHalf);
        System.out.println();
        printList(secondHalf);
        // now merge them together
        firstHalf = mergeTwoUnsortedList(firstHalf, secondHalf);
        // first half is the answer to the problem
        System.out.println();
        printList(firstHalf);
    }

    public static void addTwoNumber(LinkedList l1, LinkedList l2){
        // reverse both lists
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        // create a new list to store answer
        LinkedList retList = new LinkedList();
        int carry = 0;

        while(l1.head != null || l2.head != null){
            int x = (l1.head != null) ? l1.head.data: 0;
            int y = (l1.head != null) ? l2.head.data: 0;
            int sum = x + y + carry;
            if(sum >= 10){
                carry = 1;
                insert(retList, (sum -10));
            }
            else {
                carry = 0;
                insert(retList, sum);
            }

            // move the heads
            if(l1.head.next != null && l2.head.next != null){
                l1.head = l1.head.next;
                l2.head = l2.head.next;
            }
            else{
             break;
            }

        }

        if(carry == 1){
            insert(retList, 1);
        }
        // reverse retList
        retList = reverseList(retList);
        // print answer
        printList(retList);

    }

    public static void sumNumbers(LinkedList l1){
        int sum = 0;
        while(l1.head != null){
            sum += l1.head.data;
            if(l1.head.next == null){
                break;
            }
            else
                l1.head = l1.head.next;
        }
        System.out.println("Sum of all values in this LinkedList = " + sum);
    }

    public static void getValueAtIndex(LinkedList l1, int index){
        if(index <= 0){
            System.out.println("null");
        }
        int startVal = 0;
        Node currNode = l1.head;
        while(currNode != null){
            if(startVal == index){
                System.out.println(currNode.data);
                break;
            }

            if(currNode.next == null){
                break;
            }
            else {
                startVal++;
                currNode = currNode.next;
            }
        }
    }

}