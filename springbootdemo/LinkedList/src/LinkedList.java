
public class LinkedList {

	
	public static void main(String[] args) {
		
		LinkedList list=new LinkedList();
		
		for(int i=1;i<=6;i++) {
			Node node=new Node(i);
			list.addToEndOfLinkedList(node);
		}
		
		Node temp=list.head;
		
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		
		System.out.println();
		
		list.reverseLinkedList();
		
		temp=list.head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
		list.findMiddleElement();
		
		list.findNthElementFromEnd(2);
	}
	
	private Node head;
	
	public  void addToEndOfLinkedList(Node node) {
		
		if(head==null) {
			head=node;
		}
		else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=node;
		}
	}
	
	
	public void reverseLinkedList() {
		
		Node previous=null;
		Node currentNode=head;
		Node nextNode=null;
		while(currentNode!=null) {
			nextNode=currentNode.next;
			currentNode.next=previous;
			previous=currentNode;
			currentNode=nextNode;
		}
		
		head=previous;
		
		
	}
	
	
	public void findMiddleElement() {
		
		Node fastPointer=head;
		Node slowPointer=head;
		
		while(fastPointer!=null) {
			fastPointer=fastPointer.next;
			if(fastPointer!=null) {
				fastPointer=fastPointer.next;
				slowPointer=slowPointer.next;
			}
		}
		
		System.out.println(slowPointer.data);
	}
	
	public void findNthElementFromEnd(int n) {
		
		Node first,second;
		first=second=head;
		for(int i=1;i<n;i++) {
			first=first.next;
		}
		
		while(first.next!=null) {
			first=first.next;
			second=second.next;
		}
		System.out.println(second.data);
	}
}



class Node{
	
	public int data;
	//private Node previous;
	public Node next;
	
	public Node(int data) {
		this.data=data;
	}
	
	
	
	
}