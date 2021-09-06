package oop_sud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class system_database_connecter {
	Connection con;
	Statement st;
	int ans;
	private ResultSet rows;

//CONNECTING THE DATABASE 
	public system_database_connecter() {
		try {
			//Class.forName("con.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library_system","root","#SUdi66030");
			if(con!=null) {
				System.out.println("Database is connected");
			st =con.createStatement();
			}		
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	

//INSERTING QUERY 
	public int insert(String query) {	
		try {
			ans = st.executeUpdate(query);
			}catch (SQLException throwables) {
				throwables.printStackTrace();
				}
		return ans;
		}	
	
	
//SELECTING QUERY 
	public ResultSet select(String query) {
		try {
			rows = st.executeQuery(query);
		}
		catch(SQLException throwables) {
			throwables.printStackTrace();
		}
		return rows;	
	}


	public static void main(String[] args) {
		new system_database_connecter();
		}
}
