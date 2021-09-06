package oop_sud;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class register {
    JFrame f;
    JLabel lbl_title, lbl_fullname, lbl_dob, lbl_gender, lbl_sector, lbl_username, lbl_password;
    JTextField txt_fullname, txt_dob, txt_gender, txt_sector, txt_username;
    JPasswordField txt_password;
    JButton btn_register;

    public register() {
        f = new JFrame("Register");
        f.setResizable(false);
        f.setBounds(550,210,581,491 );

        lbl_title=new JLabel("REGISTRATION PAGE");
        lbl_title.setFont(new Font("Arial", Font.BOLD, 20));
        lbl_title.setForeground(Color.YELLOW);
        lbl_title.setBounds(80, 0, 211, 60);
        f.getContentPane().add(lbl_title);
   
        lbl_fullname = new JLabel("Enter Full Name");
        lbl_fullname.setBounds(40, 60, 130, 20);
        lbl_fullname.setForeground(Color.WHITE);
        f.getContentPane().add(lbl_fullname);

        txt_fullname = new JTextField();
        txt_fullname.setBounds(160, 61, 190, 20);
        txt_fullname.setColumns(10);
        f.getContentPane().add(txt_fullname);

        lbl_dob = new JLabel("Date of Birth");
        lbl_dob.setBounds(40, 121, 130, 20);
        lbl_dob.setForeground(Color.WHITE);
        f.getContentPane().add(lbl_dob);

        txt_dob = new JTextField();
        txt_dob.setBounds(160, 122, 190, 20);
        txt_dob.setColumns(10);
        f.getContentPane().add(txt_dob);

        lbl_gender = new JLabel("Gender");
        lbl_gender.setBounds(40,151, 130, 20);
        lbl_gender.setForeground(Color.WHITE);
        f.getContentPane().add(lbl_gender);

        txt_gender = new JTextField();
        txt_gender.setBounds(160, 151, 190, 20);
        txt_gender.setColumns(10);
        f.getContentPane().add(txt_gender);

        lbl_sector = new JLabel("Sector");
        lbl_sector.setBounds(40, 181, 130, 20);
        lbl_sector.setForeground(Color.WHITE);
        f.getContentPane().add(lbl_sector);

        txt_sector = new JTextField("Admin");
        txt_sector.setBounds(160, 181, 190, 20);
        txt_sector.setColumns(10);
        f.getContentPane().add(txt_sector);

        lbl_username = new JLabel("Username");
        lbl_username.setBounds(40, 91, 130, 20);
        lbl_username.setForeground(Color.WHITE);
        f.getContentPane().add(lbl_username);

        txt_username = new JTextField();
        txt_username.setBounds(160, 91, 190, 20);
        txt_username.setColumns(10);
        f.getContentPane().add(txt_username);

        lbl_password = new JLabel("Create Password");
        lbl_password.setBounds(40, 211, 130, 20);
        lbl_password.setForeground(Color.WHITE);
        f.getContentPane().add(lbl_password);

        txt_password = new JPasswordField();
        txt_password.setBounds(160, 211, 190, 20);
        txt_password.setColumns(10);
        f.getContentPane().add(txt_password);

        btn_register=new JButton("REGISTER");
        btn_register.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent e) {
		       String full_name = txt_fullname.getText();
		       String username = txt_username.getText();
               String dob = txt_dob.getText();
               String gender = txt_gender.getText();
               String sector = txt_sector.getText();
               String password = txt_password.getText();
       

        // message show with username
        String msg = "" + username ;
        msg += " \n";
        
        if (txt_username.getText().equals("") && txt_password.getText().equals("") ) {        	
        	JOptionPane.showMessageDialog(btn_register, "Please Enter The Full details");
        }

        else if(e.getSource() == btn_register ) {
        	system_database_connecter dc= new system_database_connecter();
        	String query = "INSERT INTO register  values('" + full_name + "','" + username + "','" + dob + "','" + gender + "','" + sector + "','" + password + "')";
        	
        int val = dc.insert(query);
        
        if (val>0) {
                JOptionPane.showMessageDialog(btn_register,

                    "Welcome, " + msg + "Your account is sucessfully created");
                    system sy= new system();
                	sy.setVisible(true);
                	dispose_f();
            }	
            }
    }

	private void dispose_f() {
		// TODO Auto-generated method stub
		f.dispose();
	}
    });
    btn_register.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
    btn_register.setForeground(new Color(30, 144, 255));
    btn_register.setBounds(135, 258, 110, 30);
    f.getContentPane().add(btn_register);
   
     JLayeredPane layeredPane = new JLayeredPane();
     layeredPane.setBounds(32, 183, 172, -65);
     f.getContentPane().add(layeredPane);

       JLabel lblpicture = new JLabel("");
       lblpicture.setIcon(new ImageIcon("D:\\Sudi's folder\\School Management System\\pictures\\bg.jpg"));
       lblpicture.setBounds(0,0,400,400);
       f.getContentPane().add(lblpicture);
       
     f.setSize(400, 400);
     f.getContentPane().setLayout(null);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f.setVisible(true);
     }

    public static void main(String[] args) {
        new register();
    }

    public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	}
}