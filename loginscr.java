import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class loginscr extends JFrame implements ActionListener{
	JTextField t1;
	JPasswordField p1;
	JLabel l1,l2,title;
	JButton b1,b2,b3;
	public loginscr(){
		setLayout(null);
		/*title= new JLabel("LOGIN SCREEN");
		Font f = new Font("Times New Roman",Font.BOLD,40);
		//title.setForeground(Color.green);
		title.setBounds(100,0,100,500);
		title.setFont(f);*/
		l1= new JLabel("Username");
		l2= new JLabel("Password");
		t1= new JTextField(50);
		p1= new JPasswordField(20);
		b1= new JButton("Create user");
		b1.addActionListener(this);
		b2= new JButton("Login");
		b2.addActionListener(this);
		b3= new JButton("Exit");
		b3.addActionListener(this);
		l1.setBounds(50,50,60,50);
		t1.setBounds(130,50,120,50);
		l2.setBounds(50,120,60,50);
		p1.setBounds(130,120,120,50);
		b1.setBounds(50,210,150,50);
		b2.setBounds(210,210,150,50);
		b3.setBounds(370,210,150,50);
		//add(title);
		add(l1);
		add(t1);
		add(l2);
		add(p1);
		add(b1);
		add(b2);
		add(b3);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b1){
		createuser c = new createuser();
		c.setSize(700,700);
		c.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);
		c.setTitle("login screen");	
		dispose();
		}
		if(ae.getSource()== b2){
			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection("jdbc:odbc:inventorydsn");
				Statement stmt = con.createStatement();
				String query = "select * from tbllogin where username='" + t1.getText() + "' and password='" + p1.getText() + "'";
				ResultSet rs = stmt.executeQuery(query);
				int ctr= 0;
				while(rs.next()){
					ctr= ctr+1;
				}
				if(ctr == 0){
					JOptionPane.showMessageDialog(null,"user does not exist");
				}
				else{
					JOptionPane.showMessageDialog(null,"Login successful");
				}
				con.close();
				tblstock s = new tblstock();
				s.setSize(700,700);
				s.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
				s.setVisible(true);
				s.setTitle("stock table");
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"Exception caught: " + e);
			}
		}
		if(ae.getSource()== b3){
			System.exit(0);
		}
	}
	public static void main(String args[]){
		loginscr l = new loginscr();
		l.setSize(700,700);
		l.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		l.setVisible(true);
		l.setTitle("login screen");
	}
}