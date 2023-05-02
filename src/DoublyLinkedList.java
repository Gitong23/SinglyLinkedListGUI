import java.security.InvalidParameterException;

public class DoublyLinkedList {
	public int size;
	public Node head;
	public Node tail;
	
	public DoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	public void addFirst(int x) {
		Node n = new Node(x);
		n.next = head.next;
		head.next = n;
		n.next.prev = n;
		n.prev = head;
		
		size++;
	}
	
	public void addLast(int x) {
		Node n = new Node(x);
		n.prev = tail.prev;
		tail.prev = n;
		n.prev.next = n;
		n.next = tail;
		size++;
	}
	
	public void removeAt(int index) {
		
		if(index < 0 || index >= size) {
			throw new InvalidParameterException("index out of range : "+index);
		}
		
		int i=0;
		Node p = head;
		while(p.next != tail && i < index) {
			p = p.next;
			i++;
		}
		p.next = p.next.next;
		p.next.prev = p;
	}
	
	public void insert(int x, int i) {
		int k=0;
		Node n;
		if(i > size)return;
		if(i > size/2) {
			n = tail;
			k=size;
			for(;k>i-1;k--) {
				n=n.prev;
			}
		}
		else {
			n=head;
			for(k=0; k<i; k++) {
				n=n.next;
			}
		}
		Node m = n.next;
		n.next = new Node();
		n.next.data = x;
		n.next.next = m;
		n.prev = n;
		m.prev = n.next;
	}
	
}
