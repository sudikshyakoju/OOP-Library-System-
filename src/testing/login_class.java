package testing;

public class login_class {

	String username ="sudikshya123";
	String password= "koju";
	
	public boolean userLogin(String username, String password) {
		boolean result = false;
		
		if(username == username && password == password) {
			result = true;			
		}
		
		
		return result;
	}

	public static void main(String[] args) {

	}
}
