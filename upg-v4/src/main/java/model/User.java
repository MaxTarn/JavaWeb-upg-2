package model;

public class User {
	private String usrName;
	private String password;
	private boolean loggedIn = false;
	private String messege;
	private String usrMessege;
	
	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) throws Exception {
		throw new Exception("Cant change user Username when already set");
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws Exception {
		throw new Exception("Cant change user password when already set");
	}
	
	public boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}
	
	public String getUsrMessege() {
		return usrMessege;
	}

	public void setUsrMessege(String usrMessege) {
		this.usrMessege = usrMessege;
	}
	
	
	
	
	

	

	

	public boolean tryLogIn(String usrName, String password) {
		if( usrName.equals(this.usrName) && password.equals(this.password)) {
			this.loggedIn = true;
			return true;
		}else {
			this.loggedIn = false;
			return false;
		}
	}
	
	public String isloggedIn() {
		if(this.loggedIn == true) {
			this.loggedIn = false;
			return this.usrName;
		}else {
			return "";
		}
		
	}
	
	
	
	public User(String usrName, String password, boolean loggedIn, String messege) {
		this.usrName = usrName;
		this.password = password;
		this.loggedIn = loggedIn;
		this.messege = messege;
	}
	
	public User(String usrName, String password, String messege) {
		this(usrName, password,false, messege);
		
	}
}
