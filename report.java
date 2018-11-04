import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
public class report extends JFrame implements ActionListener{
	JLabel heading;	
	JTable jt1;
	int i,j;
	DefaultTableModel tm=new DefaultTableModel(1,4);
	String head[ ]={"icode","iname","rate","qoh"};
	JButton b4;
	String url="jdbc:odbc:inventorydsn";
	String driver="sun.jdbc.odbc.JdbcOdbcDriver";
	Connection connection;
	Statement statement;
	ResultSet rs;
	public report(){
		setLayout(new FlowLayout());
		heading=new JLabel("stock Details");
		heading.setFont(new Font("Arial Black",Font.PLAIN,24));
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		jt1=new JTable();
		jt1.setRowHeight(30);
		jt1.setFont(new Font("Arial",Font.PLAIN,12));
		jt1.setModel(tm);

		for(j=0;j<4;j++){
			tm.setValueAt(head[j],0,j);
			jt1.getColumnModel().getColumn(j).setPreferredWidth(80);
			jt1.getColumnModel().getColumn(j).setCellRenderer(rightRenderer);
		}
		
		b4=new JButton("Exit");
		b4.addActionListener(this);
		add(heading);
		add(jt1);
		add(jt1,BorderLayout.CENTER);
		add(b4);
		
	}
	public void getFields(){ 
  	   try{
			Class.forName(driver);
  	        connection=DriverManager.getConnection(url);
  	        statement=connection.createStatement();
  	        String query="select * from tblstock";
  	        rs=statement.executeQuery(query);
			while(rs.next()){
				String [] r={String.valueOf(rs.getInt(1)),rs.getString(2),String.valueOf(rs.getInt(3)),String.valueOf(rs.getInt(4))};
				tm.addRow(r);
			}
			connection.close();
  	    }
  	    catch(ClassNotFoundException c){  	          	 
			System.err.println(c);
  	    }
  	    catch(SQLException sql){
  	       	System.err.println(sql);
  	    }
  	}
	public void actionPerformed(ActionEvent ae){
		System.exit(0);
	}
	public static void main(String args[]){

		report r =new report();
		r.setBounds(10,10,510,410);
		r.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		r.setVisible(true);
		r.setTitle("reports");
	}
}