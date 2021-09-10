package oop_sud;

//IMPORT REQUIRED PACKAGES
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login {
     JFrame f;
     JLabel lbl_title, lbl_username, lbl_password;
     JTextField txt_username;
     JPasswordField txt_password;
     JButton btn_login, btn_register;

     //LOGIN FRAME
     public login() {
          f = new JFrame("Login");
          f.setResizable(false);
          f.setBounds(500,250,581,491 );

          lbl_title=new JLabel("LOGIN PAGE");
          lbl_title.setFont(new Font("Arial", Font.BOLD, 20));
          lbl_title.setForeground(Color.YELLOW);
          lbl_title.setBounds(130, 0, 630, 60);
          f.getContentPane().add(lbl_title);
   
          lbl_username = new JLabel("Username");
          lbl_username.setBounds(60, 70, 60, 20);
          lbl_username.setForeground(Color.WHITE);
          f.getContentPane().add(lbl_username);

          txt_username = new JTextField();
          txt_username.setBounds(130, 70, 200, 20);
          txt_username.setColumns(10);
          f.getContentPane().add(txt_username);
   
          lbl_password = new JLabel("Password");
          lbl_password.setBounds(60, 120, 60, 20);
          lbl_password.setForeground(Color.WHITE);
          f.getContentPane().add(lbl_password);

          txt_password = new JPasswordField();
          txt_password.setBounds(130, 120, 200, 20);
          txt_password.setColumns(10);
          f.getContentPane().add(txt_password);

          //LOGIN BUTTON
          btn_login=new JButton("LOGIN");
          btn_login.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                if (txt_username.getText().equals("") && txt_password.getText().equals("") ) {
                    JOptionPane.showMessageDialog( btn_login, "Please Enter Username and Password");
                }
                else if(e.getSource()== btn_login) {
                    String username = txt_username.getText();
                    String password = txt_password.getText();
                    String query = "Select username, password from register where username= '"+ username+"' and password= '"+password+"' ";
                    system_database_connecter dc = new system_database_connecter();

                    ResultSet rows = dc.select(query);
                    try {
                         if (rows.next()) {
                            JOptionPane.showMessageDialog(btn_login, "You have successfully logged in");
                                  system sy= new system();
                                  sy.setVisible(true);
                                  f.dispose();                 
                          }
                          else {
                              JOptionPane.showMessageDialog(btn_login, "Wrong Username & Password");
                          }
                     } catch (SQLException throwable) {
                         // TODO Auto-generated catch block
                         throwable.printStackTrace();
                     } 
                }
              }
       });
          
       btn_login.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
       btn_login.setForeground(new Color(30, 144, 255));
       btn_login.setBounds(90, 170, 80, 30);
       f.getContentPane().add(btn_login);
       
       //REGISTER BUTTON
       btn_register=new JButton("REGISTER");
       btn_register.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
           register rg= new register();
           rg.setVisible(true);
           dispose_f();
       }

       private void dispose_f() {
          f.dispose();
       }
   });
   
   btn_register.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
   btn_register.setForeground(new Color(30, 144, 255));
   btn_register.setBounds(190, 170, 110, 30);
   f.getContentPane().add(btn_register);
   
     //BACKGROUND PICTURE
     JLayeredPane layeredPane = new JLayeredPane();
     layeredPane.setBounds(32, 183, 172, -65);
     f.getContentPane().add(layeredPane);

       JLabel lblpicture = new JLabel("");
       lblpicture.setIcon(new ImageIcon("D:\\Sudi's folder\\School Management System\\pictures\\bg.jpg"));
       lblpicture.setBounds(0,0,400,243);
       f.getContentPane().add(lblpicture);
       
     f.setSize(400, 280);
     f.getContentPane().setLayout(null);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f.setVisible(true);
}

 

 public static void main(String[] args) {
    new login();
   }
}
