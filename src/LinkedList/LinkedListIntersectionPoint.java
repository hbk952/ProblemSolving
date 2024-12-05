package LinkedList;

import java.util.HashSet;

/*
 * 10->
 * 		15->30
 * 3->6->
 */

public class LinkedListIntersectionPoint {

	public static void main(String[] args) {
		// creation of first list
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);

      // creation of second list
        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);
        head2.next.next.next = head1.next;

      Node intersectionPoint
          = getIntersectionNode(head1, head2);

      if (intersectionPoint == null)
          System.out.print(" No Intersection Point \n");
      else
          System.out.print("Intersection Point: "
                           + intersectionPoint.data);
	}
	static Node getIntersectionNode(Node head1, Node head2) {
        HashSet<Node> visitedNodes = new HashSet<>();

        // Traverse the first list and store all nodes 
          // in a set
        Node curr1 = head1;
        while (curr1 != null) {
            visitedNodes.add(curr1);
            curr1 = curr1.next;
        }

        // Traverse the second list and check if any node is
        // in the set
        Node curr2 = head2;
        while (curr2 != null) {
            if (visitedNodes.contains(curr2)) {
                  
                  // Intersection point found
                return curr2; 
            }
            curr2 = curr2.next;
        }

        return null;
    }

}

