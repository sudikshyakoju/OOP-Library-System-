package oop_sud;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class system {
    JFrame f;
    JLabel lbl_title, lbl_bookID, lbl_bookname, lbl_author, lbl_genre, lbl_price;
    JTextField txt_bookID, txt_bookname, txt_author, txt_genre, txt_price;
    JButton btn_addbook, btn_viewbooks, btn_updatebook, btn_deletebook;
    private JTable table;

    public system() {
        f = new JFrame("Library Management System");
        f.setResizable(false);
        f.setBounds(500,100,581,491 );

        lbl_title=new JLabel("LIBRARY MANAGEMENT SYSTEM");
        lbl_title.setFont(new Font("Arial", Font.BOLD, 20));
        lbl_title.setForeground(Color.YELLOW);
        lbl_title.setBounds(125, 0, 352, 60);
        f.getContentPane().add(lbl_title);
   
        lbl_bookID = new JLabel("Book ID");
        lbl_bookID.setBounds(50, 60, 130, 20);
        lbl_bookID.setForeground(Color.WHITE);
        f.getContentPane().add(lbl_bookID);

        txt_bookID = new JTextField();
        txt_bookID.setBounds(130, 60, 190, 20);
        txt_bookID.setColumns(10);
        f.getContentPane().add(txt_bookID);

        lbl_bookname = new JLabel("Book Name");
        lbl_bookname.setBounds(50, 100, 130, 20);
        lbl_bookname.setForeground(Color.WHITE);
        f.getContentPane().add(lbl_bookname);

        txt_bookname = new JTextField();
        txt_bookname.setBounds(130, 100, 190, 20);
        txt_bookname.setColumns(10);
        f.getContentPane().add(txt_bookname);

        lbl_author = new JLabel("Author");
        lbl_author.setBounds(50, 140, 130, 20);
        lbl_author.setForeground(Color.WHITE);
        f.getContentPane().add(lbl_author);

        txt_author = new JTextField();
        txt_author.setBounds(130, 140, 190, 20);
        txt_author.setColumns(10);
        f.getContentPane().add(txt_author);

        lbl_genre = new JLabel("Genre");
        lbl_genre.setBounds(50, 180, 130, 20);
        lbl_genre.setForeground(Color.WHITE);
        f.getContentPane().add(lbl_genre);

        txt_genre = new JTextField();
        txt_genre.setBounds(130, 180, 190, 20);
        txt_genre.setColumns(10);
        f.getContentPane().add(txt_genre);

        lbl_price = new JLabel("Price (Rs)");
        lbl_price.setBounds(50, 220, 130, 20);
        lbl_price.setForeground(Color.WHITE);
        f.getContentPane().add(lbl_price);

        txt_price = new JTextField();
        txt_price.setBounds(130, 220, 190, 20);
        txt_price.setColumns(10);
        f.getContentPane().add(txt_price);

btn_addbook=new JButton("ADD BOOK");
btn_addbook.setIcon(new ImageIcon("D:\\sudi's folder\\add.png"));
btn_addbook.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	   String book_id = txt_bookID.getText();
	   String book_name = txt_bookname.getText();
	   String author = txt_author.getText();
	   String genre = txt_genre.getText();
	   String price = txt_price.getText();
		
		if (e.getSource() == btn_addbook) {
			system_database_connecter sdc= new system_database_connecter();
			String query = "insert into book"
					+ "(book_id,book_name,author,genne,price) "
					+ "values('" +book_id + "','" + book_name + "','" + author + "','" + genre+ "','" +price+ "')";
			int val= sdc.insert(query);
			if (val>0) {
				JOptionPane.showMessageDialog(f,"Data Save Successflly");	
			}
			else {
				JOptionPane.showMessageDialog(f, "Failed to save the data");
			}
		}
	}
});
btn_addbook.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
btn_addbook.setForeground(new Color(30, 144, 255));
btn_addbook.setBounds(400, 49, 159, 35);
f.getContentPane().add(btn_addbook);
   
btn_viewbooks=new JButton("VIEW BOOKS");
btn_viewbooks.setIcon(new ImageIcon("D:\\sudi's folder\\display.png"));
btn_viewbooks.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try { 
		Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library_system","root","#SUdi66030");
		Statement st = myConn.createStatement();
		String sql = "select * from book";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			String book_id = String.valueOf(rs.getInt("book_id"));
			String book_name = rs.getString("book_name");
			String author = rs.getString("author");
			String genne = rs.getString("genne");
			String price = String.valueOf(rs.getInt("price"));
			String tbData [] = {book_id,book_name,author, genne, price};
			
			DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
			
			tblModel.addRow(tbData);
		}
	
	myConn.close();
		
	}catch(Exception ex) {
		System.out.println(ex.getMessage());
		}
	}
});
btn_viewbooks.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
btn_viewbooks.setForeground(new Color(30, 144, 255));
btn_viewbooks.setBounds(400, 93, 159, 35);
f.getContentPane().add(btn_viewbooks);

btn_updatebook=new JButton("UPDATE BOOK");
btn_updatebook.setIcon(new ImageIcon("D:\\sudi's folder\\update.png"));
btn_updatebook.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String book_id = txt_bookID.getText();
		String book_name = txt_bookname.getText();
		String author = txt_author.getText();
		String genre = txt_genre.getText();
		String price = txt_price.getText();
	
		
		if (e.getSource() == btn_updatebook) {
			system_database_connecter sdc= new system_database_connecter();
			String query = "update book set book_name = '"+book_name+"', author='"+author+"',genre='"+genre+"',price='"+price+"' where book_id ='"+book_id+"' ";
			int val= sdc.insert(query);
			if (val>0) {
				JOptionPane.showMessageDialog(f,"Data Updated Successflly");
				((DefaultTableModel)table.getModel()).setNumRows(0); 
			}
			else {
				JOptionPane.showMessageDialog(f, "Failed to Update data");
			}
		}
		
	}
});
btn_updatebook.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
btn_updatebook.setForeground(new Color(30, 144, 255));
btn_updatebook.setBounds(400, 133, 159, 35);
f.getContentPane().add(btn_updatebook);

btn_deletebook=new JButton("DELETE BOOK");
btn_deletebook.setIcon(new ImageIcon("D:\\sudi's folder\\delete.png"));
btn_deletebook.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String book_id = txt_bookID.getText();
		
		if (e.getSource() == btn_deletebook) {
			system_database_connecter sdc= new system_database_connecter();
			String query = "delete from book where book_id = '"+book_id+"' ";
			int val= sdc.insert(query);
			if (val>0) {
				JOptionPane.showMessageDialog(f,"Data Deleted Successflly");	
				((DefaultTableModel)table.getModel()).setNumRows(0); 
			}
			else {
				JOptionPane.showMessageDialog(f, "Failed to Delete the data");
			}
		}
		
	}
});
btn_deletebook.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
btn_deletebook.setForeground(new Color(30, 144, 255));
btn_deletebook.setBounds(400, 178, 159, 35);
f.getContentPane().add(btn_deletebook);

  JLayeredPane layeredPane = new JLayeredPane();
     layeredPane.setBounds(32, 183, 172, -65);
     f.getContentPane().add(layeredPane);
       
     f.setSize(605,538);
     f.getContentPane().setLayout(null);
     
     JScrollPane scrollPane = new JScrollPane();
     scrollPane.setBounds(459, 70, 2, 2);
     f.getContentPane().add(scrollPane);
     
     JScrollPane scrollPane_1 = new JScrollPane();
     scrollPane_1.setBounds(10, 263, 526, 217);
     f.getContentPane().add(scrollPane_1);
     
     table = new JTable();
     table.addMouseListener(new MouseAdapter() {
     	@Override
     	public void mouseClicked(MouseEvent e) {
     		DefaultTableModel RecordTable = (DefaultTableModel)table.getModel();
			                  int SelectedRows =table.getSelectedRow();
			                  txt_bookID.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
			                  txt_bookname.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
			                  txt_author.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
			                  txt_genre.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
			                  txt_price.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
     	}
     });
     table.setModel(new DefaultTableModel(
     	new Object[][] {
     	},
     	new String[] {
     		"Book ID", "Book Name", "Author", "Genre", "Price"
     	}
     ));
     scrollPane_1.setViewportView(table);
     
     JButton btn_clear = new JButton("CLEAR ");
     btn_clear.setFont(new Font("Arial", Font.BOLD, 12));
     btn_clear.setIcon(new ImageIcon("D:\\sudi's folder\\clear1.png"));
     btn_clear.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
     		txt_bookID.setText("");
			txt_bookname.setText("");
			txt_author.setText("");
			txt_genre.setText("");
			txt_price.setText("");
			((DefaultTableModel)table.getModel()).setNumRows(0); 
     	}
     });
     btn_clear.setForeground(new Color(30, 144, 255));
     btn_clear.setBounds(400, 220, 159, 35);
     f.getContentPane().add(btn_clear);
     
            JLabel lblpicture = new JLabel("");
            lblpicture.setIcon(new ImageIcon("D:\\Sudi's folder\\School Management System\\pictures\\bg.jpg"));
            lblpicture.setBounds(0,0,585,495);
            f.getContentPane().add(lblpicture);
            
     f.setSize(585,495);    
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f.setVisible(true);
}

public static void main(String[] args) {
new system();
}

public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}
}
