
public class Stack {
	
	LinkedList ll;
	
	public Stack() {
		ll = new LinkedList();
	}
	
	public void push(int x) {
		ll.addFirst(x);
	}
	
	public int pop() {
		int x = ll.get(0);
		ll.removeAt(0);
		return x;
	}
	
	public int top() {
		return ll.get(0);
	}
	
}
