package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {
	public static void main(String[] args) {
		Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
      
        head.next.next.next.next = head;

        if (detectLoop(head))
            System.out.println("true");
        else
            System.out.println("false");
    }
		
	
	static boolean detectLoop(Node head) {
        Set<Node> st = new HashSet<>();

        while (head != null) {

            // If this node is already present in hashmap it means there is a cycle
            if (st.contains(head))
                return true;

            // If we are seeing the node for the first time, insert it in hash
            st.add(head);

            head = head.next;
        }
        return false;
    }

}


