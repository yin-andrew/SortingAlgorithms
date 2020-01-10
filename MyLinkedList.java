//andrew


import java.util.*;

public class MyLinkedList
{
  /*******************************************************/
  class Node
  {
      private long data;
      private Node next;
      public Node(long data, Node next)
      {
          this.data = data;
          this.next = next;
      }
      public String toString(){ return "" + this.data; }

   }
   /********************************************************/

   private Node head;
   private int size;

   public MyLinkedList() {
      head = null;
      size = 0;
   }

   public int getSize(){ return size; }

   // Returns true if the list is empty
   public boolean isEmpty() {
     return head == null;
   }

   // Inserts a new node at the beginning of this list
   public void addFirst(long item) {
     head = new Node(item, head);
     size++;
   }

   // Inserts a new node to the end of this list
   public void addLast(long item) {
     if( isEmpty() )
        addFirst(item);
     else
     {
       Node current = head;
       while( current.next != null ) current = current.next;
       // Now current is pointing to the last element!
       current.next = new Node(item, null);
       size++;
     }
   }

   // Returns the first element (data) in the list
   public long getFirst() {
     if( isEmpty() ) throw new NoSuchElementException();
     return head.data;
   }

   // Returns the last element (data) in the list
   public long getLast() {
     if(head == null) throw new NoSuchElementException();
     Node tmp = head;
     while(tmp.next != null) tmp = tmp.next;
     return tmp.data;
   }

   // Returns a reference to the Node at the given position,
   // assuming that node indexes start at zero
   public Node get(int pos) {
     if (head == null) throw new IndexOutOfBoundsException();
     Node tmp = head;
     for (int k = 0; k < pos; k++){
       tmp = tmp.next;
       if( tmp == null ) throw new IndexOutOfBoundsException();
     }
     return tmp;
   }

   public long[] toArray() {
     if(head == null) throw new IndexOutOfBoundsException();
     long[] result = new long[getSize()];
     int i = 0;
     for(Node tmp = head; tmp != null; tmp = tmp.next){
       result[i] = tmp.data;
       i++;
     }
     return result;
   }

   // Removes and returns the first element (data) in the list.
   public long removeFirst() {
     long temp = getFirst();
     head = head.next;
     size--;
     return temp;
   }

   // Removes the first occurrence of the specified element in this list.
   public void remove(long key) {
     if(head == null)
        throw new RuntimeException("cannot delete");

     if( head.data == key ) {
        head = head.next;
        size--;
        return;
     }

     Node cur  = head;
     Node prev = null;
     while(cur != null && cur.data != key )
     {
        prev = cur;
        cur = cur.next;
     }
     if(cur == null) throw new RuntimeException("cannot delete");
     prev.next = cur.next;
     size--;
   }

   // Returns a string representation
   public String toString() {
      String output = "";
      if(head == null) throw new NoSuchElementException();
      Node tmp = head;
      while(tmp != null) {
        output += tmp + " -> ";
        tmp = tmp.next;
      }
      output += "[NULL]";
      return output;
   }

   //finds the middle element of the linked list
   public Node getMiddle(Node node) {
	  	Node fast = node;
	  	Node slow = node;
	  	
	  	if (node == null) { //if linked list is empty
	  		return node;
	  	}
	  	
	  	while (fast.next != null && fast.next.next != null) {
	  		fast = fast.next.next;
	  		slow = slow.next;
	  	}
	  	
	  	return slow;
   }

   // MergeSort starting point
   public void mergeSort() {
     if(head == null) throw new RuntimeException("Cannot sort empty list.");
     head = sort(head);
   }

   // recursively sorts the linked list
   public Node sort(Node node) {

	   if ((node == null) || (node.next == null)) { //throw new exception when returning null
		   return node;
	   }
	   
	   Node mid = getMiddle(node); 
	   Node midPlusOne = mid.next; //starting point of the right side linked list
	   mid.next = null; // cut off into 2 separate linked lists
	   
	   Node left = sort(node); //sort left side
	   Node right = sort(midPlusOne); //sort right
	   
	   Node sorted = merge(left,right); 
	   return sorted;
    }

   // merge merges subarrays back together, comparing elements from each of the 2 subarrays
   public Node merge(Node left, Node right) {
	   
	   if (left == null) { //base case: if a side is empty
		   return right;
	   }
	   if (right == null) { 
		   return left;
	   } 
	   Node temp = null;
	   
	   if (left.data <= right.data) { //means that left node is in correct place with respect to right node
		   temp = left; //append node from left to the larger linked list
		   temp.next = merge(left.next, right); // increment left array to next element to compare w right array
	   } else  { //if (left.data >= right.data)
		   temp = right; 
		   temp.next = merge(left, right.next);
	   }   
	   
	   return temp;
   }

   
   public static void main(String[] args) {
      MyLinkedList list = new MyLinkedList();
      list.addLast(3);
      list.addLast(2);
      list.addLast(8);
      list.addLast(10);
      list.addLast(5);
      System.out.println("Before list.mergeSort()...");
      System.out.println(list);
      list.mergeSort();
      System.out.println("\nAfter list.mergeSort()...");
      System.out.println(list);
   }

} 
