import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.security.InvalidParameterException;

public class LinkedList {
	Node head;
	public int size;
	public LinkedList() {
		head = new Node();
		size = 0;
	}
	
	public void addFirst(int x) {
		Node n = new Node();
		n.data = x;
		n.next = head.next;
		head.next = n;
		size++;
	}
	
	public void addLast(int x) {
		Node n = head;//point at head when start
		while(n.next != null) {
			n = n.next;
		}//find the last node is before null
		n.next = new Node();
		n.next.data = x;
		size++;
	}
	
	public void insertAt(int x, int i) {
		int k = 0;
		Node n = head;
		while(n.next != null && k<i) {
			n = n.next;
			k++;
		}
		Node m =n.next;
		n.next = new Node();
		n.next.data = x;
		n.next.next = m;
	}
	
	public void removeAt(int i) {
		
		if(i < 0 || i >= size) {
			throw new InvalidParameterException("index out of range : "+i);
		}
		
		int k = 0;
		Node n = head;
		while(n != null && k<i) {
			n = n.next;
			k++;
		}
		if(n.next == null)return;
		n.next = n.next.next;
	}
	
	//return idx
	public int search(int n) {
		Node s = head;
		int count = 0;
		while(s.next != null) {
			s = s.next;
			if(s.data == n)return count;
			count++;
		}
		
		return -1;
	}
	
	public int get(int i) {
		
		if(i < 0 || i >=size) {
			throw new InvalidParameterException("index out of range : "+i); 
		}
		
		int k=0;
		Node p = head;
		while(p.next != null && k<=i) {
			p = p.next;
			i++;
		}
		return p.data;
	}
	
	public void draw(Graphics g) {
		int i = 0;
		Node n = head;
		Font fn = new Font ("Serif", Font.BOLD, 20);
		while(n != null) {
			//Draw Oval
			i++;
			g.setColor(Color.BLACK);
			g.fillOval(50+60*i, 50, 50+1, 50+1);
			g.setColor(Color.YELLOW);
			g.fillOval(50+60*i, 50, 50, 50);
		
			//Draw Data
			g.setColor(Color.BLACK);
			g.setFont(fn);
			g.drawString(""+n.data, 40+60*i+25, 80);
			
			//Draw straight line
			g.drawLine(40+60*i+50, 55, 40+60*i+50, 95);
		
			//Draw arrow line
			g.drawLine(40 + 60 *i + 50, 75, 50+60*(i+1), 75);
			g.drawLine(50 + 60 * (i+1), 75, 50+60 * (i+1) - 5, 65);
			g.drawLine(50 + 60 * (i + 1), 75, 50+60*(i+1)-5, 85);
			
			n=n.next;
		}
	}
}
