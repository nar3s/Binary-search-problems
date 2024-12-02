package LinkedList;
import java.util.Scanner;

public class LinkedListUse {
    public static void main(String[] args) {
        Node sample = takeInput();
        // Node sample2 = takeInput();
        // Node mergedList = mergeTwoSortedList(sample, sample2);
        Node insert = insertNode(5,2,sample);
        Node nodeDelete = deleteNode(2,sample);
        printLinkedList(insert);
    }

    private static Node deleteNode(int i, Node sample) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteNode'");
    }

    private static Node insertNode(int i,int j,Node head) {
        Node temp = new Node(i);
        Node ans = head;
        while (head != null) {
            if (head.val == j) {
                printLinkedList(ans);
                System.out.println();
                Node sam = head.next;
                printLinkedList(ans);
                System.out.println();
                temp.next = sam;
                head.next = temp;
                printLinkedList(ans);
                System.out.println();
               
                printLinkedList(ans);
                System.out.println();
                return ans;
            }
            head = head.next;
        }
        throw new UnsupportedOperationException("Unimplemented method 'insertNode'");
    }

    private static Node mergeTwoSortedList(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        Node ans = new Node(0);
        Node current = ans;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            printLinkedList(current);
            System.out.println();
            printLinkedList(ans);
            System.out.println();
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return ans.next;
    }

    public static Node takeInput(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        Node head = null, tail = null;
        while (data != -1) {
            Node value = new Node(data);
            if (head == null) {
                head = value;
            } else {
                tail.next = value;
            }
            tail = value;
            data = s.nextInt();
        }
        return head;
    }
    public static void printLinkedList(Node list){
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}
