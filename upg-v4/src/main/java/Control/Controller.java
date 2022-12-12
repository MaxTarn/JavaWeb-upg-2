package Control;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.Users;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	//wtf even is dis??
	private static final long serialVersionUID = 1L;
    

	//array of all the user objects
	User[] allUsers = Users.returnAllUsers();
	
	
    
    public Controller() {
        super();     
    }
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//gets the current Session
		HttpSession ses = request.getSession();
		
		//used for forwarding to userDisplay.jsp if conditions are met
		RequestDispatcher reqDis = request.getRequestDispatcher("userDisplay.jsp");
		
		//variable in session to know if client has logged in 
		//used to know if client has tried to access /Controller when no usrName and password has been submitted
		String goodLogIn = "";
		
		
		//User Name and pasword
		String usrName ="";
		String password = "";	
		
		//usrMessege submitted on userDisplay.jsp
		//will be sent to the logged in User
		String usrMessege;
		
		
		//tries to initialize goodLogIn 
		try {
			 goodLogIn = ses.getAttribute("goodLogIn").toString();
		}catch(Exception ex) {}
		
		
		//tries to initialize  usrName and password
		try {
			usrName = (String)request.getParameter("usrName");
			password = (String)request.getParameter("password");
		}catch(Exception ex) {}
		
		
		//loopy boii that puts usrMessege from userDisplay.jsp into the logged in user
		try {
			usrMessege = request.getParameter("usrMessege");
			if(usrMessege != null) {
				for(int i = 0; i< allUsers.length; i++) {
					String usrNameTemp = ses.getAttribute("usrName").toString();
					if(allUsers[i].getUsrName() == usrNameTemp) {
						allUsers[i].setUsrMessege(usrMessege);
						ses.setAttribute("usrMessege", allUsers[i].getUsrMessege());
						continue;
						}
					}
				}
			}catch(Exception ex) {}
		
		
		
		//checks if there is a session already logged in
		//checks if there is a usrName & password submitted
		//if there is session, and usrName is null, then forwards client to userDsiplay.jsp
		if( goodLogIn.equals("true") && usrName == null && password == null ) {
			reqDis.forward(request, response);
			
			
			//if usrName & password is not submitted 
			//redirects if either is not submitted
		}else if(request.getParameter("usrName") == null || request.getParameter("password") == null) {
			response.sendRedirect(request.getContextPath()+ "/index.jsp?err=logIn");
			
			
			
		}else {
			
			
			//if usrName & password are valid for any User 
			//then this will be the copy of that User
			User loggingInUser = null;
			
			//bool for allUsers array loop
			Boolean goodCredentials = false;
			
			//loops through all Users in allUsers array
			//checks if usrName and password submitted is the same as any user
			//sets the accepted user as loggingInUser
			for(int i = 0; i< allUsers.length; i++) {
				goodCredentials = allUsers[i].tryLogIn(usrName, password);
				if(goodCredentials == true) {
					loggingInUser = allUsers[i];
				}
			}
			
			//if loggingInUser is null that means that usrName and password is not valid for a single User
			//if loggingInUser is not null that means usrName and password are valid for a User
			//loggingInUser is a copy of that User
			if(loggingInUser != null) {

				
				
				//ends up in Session
				String sessionUsrName = loggingInUser.getUsrName();
				String sessionMessege = loggingInUser.getMessege();
				String sessionUsrMessege = loggingInUser.getUsrMessege();
				
				
				//adds stuff to session
				ses.setAttribute("usrName", sessionUsrName);
				ses.setAttribute("messege", sessionMessege);
				ses.setAttribute("usrMessege", sessionUsrMessege);
				ses.setAttribute("goodLogIn", "true");
				
				//sets life of session at 180 seconds, 3 min
				ses.setMaxInactiveInterval(180);
				
				//forwards to userDisplay.jsp
				reqDis.forward(request, response);
				
				
				//redirects when usrName and password is not valid for login
			}else {
				response.sendRedirect(request.getContextPath()+ "/index.jsp?err=invalid");
			}
		}
		
		
	}

}
