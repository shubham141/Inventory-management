import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class tblstock extends JFrame implements ActionListener{
	JLabel icode,iname,rate,qoh;
	JTextField txticode,txtiname,txtrate,txtqoh;
	JButton b1,b2,b3;
	JMenuBar mbar;
	JMenu m1,m2,m3,m4;
	JMenuItem i1,i2,i3,i4,i5,i6,i7,i8;
	public tblstock(){
		setLayout(new FlowLayout());
		mbar = new JMenuBar();
		setJMenuBar(mbar);
		m1= new JMenu("Stock");
		mbar.add(m1);
		i1 = new JMenuItem("Add item");
		i1.addActionListener(this);
		i2 = new JMenuItem("Update item");
		i2.addActionListener(this);
		m1.add(i1);
		m1.add(i2);
		m2= new JMenu("Transaction");
		mbar.add(m2);
		i3 = new JMenuItem("Issue");
		i3.addActionListener(this);
		i4 = new JMenuItem("Receipt");
		i4.addActionListener(this);
		m2.add(i3);
		m2.add(i4);
		m3 = new JMenu("Reports");
		mbar.add(m3);
		i5 = new JMenuItem("All Item");
		i5.addActionListener(this);
		i6 = new JMenuItem("All Issue");
		i6.addActionListener(this);
		i7 = new JMenuItem("All Receipt");
		i7.addActionListener(this);
		m3.add(i5);
		m3.add(i6);
		m3.add(i7);
		m4 = new JMenu("Quit");
		mbar.add(m4);
		i8 = new JMenuItem("Exit app");
		i8.addActionListener(this);
		m4.add(i8);
		setLayout(null);
		icode= new JLabel("item code");
		
		txticode= new JTextField(50);
		iname= new JLabel("item name");
		txtiname= new JTextField(50);
		rate= new JLabel("rate");
		txtrate= new JTextField(50);
		qoh= new JLabel("Qoh");
		txtqoh= new JTextField(50);
		b1= new JButton("Insert");
		b1.addActionListener(this);
		b2= new JButton("Clear");
		b2.addActionListener(this);
		b3= new JButton("Exit");
		b3.addActionListener(this);
		icode.setBounds(50,50,60,50);
		txticode.setBounds(130,50,120,50);
		iname.setBounds(50,120,60,50);
		txtiname.setBounds(130,120,120,50);
		rate.setBounds(50,190,60,50);
		txtrate.setBounds(130,190,120,50);
		qoh.setBounds(50,260,60,50);
		txtqoh.setBounds(130,260,120,50);
		b1.setBounds(50,330,150,50);
		b2.setBounds(210,330,150,50);
		b3.setBounds(370,330,150,50);
		add(icode);
		add(txticode);
		add(iname);
		add(txtiname);
		add(rate);
		add(txtrate);
		add(qoh);
		add(txtqoh);
		add(b1);
		add(b2);
		add(b3);
		geticode();
		txticode.setEnabled(false);
	}
	void geticode(){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:inventorydsn");
			Statement stmt = con.createStatement();
			String query = "select icode from tblstock";
			ResultSet rs = stmt.executeQuery(query);
			int ic = 0;
			while(rs.next()){
				ic = rs.getInt("icode");
			}
			if(ic== 0){
				txticode.setText("1001");
			}
			else{
				ic= ic + 1;
				txticode.setText("" + ic);
			}
			con.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Exception caught: " + e);
		}
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()== i1){
			tblstock s = new tblstock();
			s.setSize(700,700);
			s.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			s.setVisible(true);
			s.setTitle("stock table");
		}
		else if(ae.getSource()== i2){
			stockupdatescr s = new stockupdatescr();
			s.setSize(700,700);
			s.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			s.setVisible(true);
			s.setTitle("stock modify screen");
		}
		else if(ae.getSource()== i3){
			issuescr i = new issuescr();
			i.setSize(700,700);
			i.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			i.setVisible(true);
			i.setTitle("issue table");
		}
		else if(ae.getSource()== i4){
			recieptscr r = new recieptscr();
			r.setSize(700,700);
			r.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			r.setVisible(true);
			r.setTitle("receipt");
		}
		else if(ae.getSource()== i5){
			report r =new report();
			r.setBounds(10,10,510,410);
			r.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			r.setVisible(true);
			r.setTitle("reports");
		}
		else if(ae.getSource()== i8){
			System.exit(0);
		}
		if(ae.getSource()== b1){
			try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:inventorydsn");
			Statement stmt = con.createStatement();
			String query = "insert into tblstock(icode,iname,rate,qoh) values(" + txticode.getText() + ",'" + txtiname.getText() + "'," + txtrate.getText() + "," + txtqoh.getText() + ")";
			int x = stmt.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"inserted successfully");
			con.close();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"Exception caught: " + e);
			}
		}
		if(ae.getSource()== b2){
			txtiname.setText("");
			txtrate.setText("");
			txtqoh.setText("");
		}
		if(ae.getSource()== b3){
			System.exit(0);
		}
		
	}
	public static void main(String args[]){
		tblstock s = new tblstock();
		s.setSize(700,700);
		s.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		s.setVisible(true);
		s.setTitle("stock table");
	}
}