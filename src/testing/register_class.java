package testing;

public class register_class {
	
	private String fullname,username,dob,gender,password;
		
		public register_class() {
			
		}
		
		public register_class(String fullname,String username,String dob,String gender,String password) {
			this.fullname = fullname;
			this.username = username;
			this.dob = dob;
			this.gender = gender;
			this.password = password;
			
		}
		
		public void setfullname (String fullname) {
			 this.fullname = fullname;
		}
		public String fullname () {
			return this.fullname;
			
		}
		public void setusername (String username) {
			this.username = username;
		}
		public String getusername () {
			return this.username;
		}
		
		public void setdob (String dob) {
			this.dob = dob;
		}
		public String getdob() {
			return this.dob;
		}
		public void setgender (String gender) {
			 this.gender = gender;
		}
		public String gender() {
			return this.gender;
			
		}
		public void setpassword (String password) {
			 this.password = password;
		}
		public String getpassword () {
			return this.password;

}

}
