import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class menu extends JFrame implements ActionListener{
	JMenuBar mbar;
	JMenu m1,m2,m3,m4;
	JMenuItem i1,i2,i3,i4,i5,i6,i7,i8;
	public menu(){
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
	}
	public static void main(String args[]){
		menu m = new menu();
		m.setSize(700,700);
		m.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
		m.setTitle("menu screen");
	}
}	