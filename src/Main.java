import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public LinkedList ll;
	private JTextField txt_insert;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		ll = new LinkedList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 229);
		setTitle("Single Link List");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_addFirst = new JButton("Add First");
		btn_addFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int n = Integer.parseInt(textField.getText().trim());
				ll.addFirst(n);
				repaint();
			}
		});
		btn_addFirst.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_addFirst.setBounds(307, 112, 129, 28);
		contentPane.add(btn_addFirst);
		
		JButton btn_addLast = new JButton("Add Last");
		btn_addLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt(textField.getText().trim());
				ll.addLast(n);
				repaint();
			}
		});
		btn_addLast.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_addLast.setBounds(446, 112, 129, 28);
		contentPane.add(btn_addLast);
		
		JButton btn_remove = new JButton("Remove At");
		btn_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt(textField.getText().trim());
				ll.removeAt(n);
				repaint();
			}
		});
		btn_remove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_remove.setBounds(307, 150, 129, 28);
		contentPane.add(btn_remove);
		
		JButton btn_search = new JButton("Search");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt(textField.getText().trim());
				int s = ll.search(n);
				
				if(s>=0) {
					JOptionPane.showMessageDialog(Main.this, "Found at index: "+s);
				}
				else {
					JOptionPane.showMessageDialog(Main.this, "Not Found");
				}
			}
		});
		btn_search.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_search.setBounds(446, 150, 129, 28);
		contentPane.add(btn_search);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(24, 112, 219, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btn_insertAt = new JButton("Insert At");
		btn_insertAt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = Integer.parseInt(textField.getText());
				int k = Integer.parseInt(txt_insert.getText());
				ll.insertAt(value, k);
				repaint();
			}
			
		});
		btn_insertAt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_insertAt.setBounds(601, 112, 129, 28);
		contentPane.add(btn_insertAt);
		
		txt_insert = new JTextField();
		txt_insert.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_insert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_insert.setColumns(10);
		txt_insert.setBounds(601, 150, 129, 28);
		contentPane.add(txt_insert);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		ll.draw(g);
	}
}
