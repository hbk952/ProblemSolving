package LinkedList;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5 ->null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        
        System.out.print("Given Linked list:");
        printList(head);
        
        //head = reverseList(head);
        head = reverseListRecursion(head);

        System.out.print("\nReversed Linked List:");
        printList(head);

	}
	
	static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
    }
	
	//iterative approach - O(n) time and O(1) space
	static Node reverseList(Node head) {
        
        Node curr = head, prev = null, next; // Initialize three pointers: curr, prev and next

        while (curr != null) { // Traverse all the nodes of Linked List
            //in 1st iteration, current node points to 1st node
            next = curr.next; //next will point to the second node
            
            curr.next = prev;  //as prev point to null, next ref of curr/first node will have null - will work as last node
            // null <- 1  2 -> 3 -> 4 -> 5 ->null
            
            // Move pointers one position ahead
            prev = curr; //prev will now point to first node
            curr = next; //curr will point to second node
        }
        
        // Return the head of reversed linked list
        return prev;
    }
	
	//recursive approach - O(n) time and O(1) space
	static Node reverseListRecursion(Node head) {
		if (head == null || head.next == null) {
            return head;
	 	}
		
		Node rest = reverseList(head.next); //reverse the rest of linked list and put the first element at the end
		head.next.next = head; //Make the current head as last node of remaining linked list
		head.next = null;	// Update next of current head to NULL
		return rest;	//Return the reversed linked list

	}	
	
}


