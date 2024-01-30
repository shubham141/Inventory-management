import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class splashscreen extends  JFrame{
	JLabel l,l1,l2;
	public splashscreen(){
		setLayout(null);
		l = new JLabel("Inventory Control System");
		Font f = new Font("Times New Roman",Font.BOLD | Font.ITALIC,40);
		l.setForeground(Color.green);
		l.setBounds(200,0,1000,100);
		l.setFont(f);
		l1 = new JLabel("Submitted by:");
		Font f1 = new Font("Times New Roman",Font.BOLD | Font.ITALIC,20);
		l1.setForeground(Color.black);
		l1.setFont(f1);
		l1.setBounds(00,200,200,100);
		l2 = new JLabel("Shubha Gupta");
		Font f2 = new Font("Brush Script MT",Font.PLAIN,25);
		l2.setFont(f2);
		l2.setBounds(130,200,300,100);
		add(l);
		add(l1);
		add(l2);
	}
	public static void main(String args[]){
		splashscreen s = new splashscreen();
		s.setSize(900,500);
		s.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		s.setVisible(true);
		s.setTitle("splash screen");
		try{
			Thread.sleep(3000);
		}
		catch(Exception e){
			
		}
		loginscr l = new loginscr();
		l.setSize(700,700);
		l.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		l.setVisible(true);
		l.setTitle("login screen");
	}
}
