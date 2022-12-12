package model;

  public class Users {
	 
	  
	  //for adding new User:
	  //
	  //first String			user Name that client puts in
	  //second String			password that client puts in
	  //third String 			will be displayed on userDisplay.jsp
	  //
	  //
	  //add new user to the returnAllUsers[]
	  
	  
	  static  User usr1 = new User("potato", "chip", "<h3>NOM NOM NOM</h3>");
	  static  User usr2 = new User("darude", "sandstrom", "<a href=\"https://www.youtube.com/watch?v=y6120QOlsfU\">Da best music</a>");
	  static  User usr3 = new User("rick", "roll", "<a href=\"https://www.youtube.com/watch?v=dQw4w9WgXcQ\">Ya yeeeet</a>");
	  static  User usr4 = new User("doggo", "doggo", "<h4>Standard messege</h4>");
	  static  User usr5 = new User("catto", "catto", "<h4>Standard messege</h4>");
	  static  User usr6 = new User("usr6", "password6", "<h4>Standard messege</h4>");
	  static  User usr7 = new User("usr7", "password7", "<h4>Standard messege</h4>");
	  static  User usr8 = new User("usr8", "password8", "<h4>Standard messege</h4>");
	  static  User usr9 = new User("usr9", "password9", "<h4>Standard messege</h4>");
	  static  User usr10 = new User("usr10", "password10", "<h4>Standard messege</h4>");
	
	  
	  static User[] allUsers = {
				usr1,
				usr2,
				usr3,
				usr4,
				usr5,
				usr6,
				usr7,
				usr8,
				usr9,
				usr10
				};
	
	  public static User[] returnAllUsers(){
		
		  
		
		  return allUsers;
	}
}
