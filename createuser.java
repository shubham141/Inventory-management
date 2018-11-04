import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class createuser extends JFrame implements ActionListener{
	JTextField t1;
	JPasswordField p1;
	JLabel l1,l2;
	JButton b1,b2,b3;
	public createuser(){
		l1= new JLabel("username");
		l2= new JLabel("password");
		t1= new JTextField(50);
		p1= new JPasswordField(20);
		b1= new JButton("Create");
		b1.addActionListener(this);
		b2= new JButton("clear");
		b2.addActionListener(this);
		b3= new JButton("back");
		b3.addActionListener(this);
		setLayout(null);
		l1.setBounds(50,50,60,50);
		t1.setBounds(130,50,120,50);
		l2.setBounds(50,120,60,50);
		p1.setBounds(130,120,120,50);
		b1.setBounds(50,210,150,50);
		b2.setBounds(210,210,150,50);
		b3.setBounds(370,210,150,50);
		add(l1);
		add(t1);
		add(l2);
		add(p1);
		add(b1);
		add(b2);
		add(b3);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()== b1){
			try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:inventorydsn");
			Statement stmt = con.createStatement();
			String query = "insert into tbllogin(username,password) values('" + t1.getText() + "','" + p1.getText() + "')";
			int x = stmt.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"usercreated");
			con.close();
			}
			catch(Exception e){
			JOptionPane.showMessageDialog(null,"Exception caught: " + e);
			}
		}
		if(ae.getSource()== b2){
			t1.setText("");
			p1.setText("");
		}
		if(ae.getSource()== b3){
			loginscr l = new loginscr();
			l.setSize(700,700);
			l.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			l.setVisible(true);
			l.setTitle("login screen");
		}
	}
	public static void main(String args[]){
		createuser c = new createuser();
		c.setSize(700,700);
		c.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);
		c.setTitle("login screen");
	}
}