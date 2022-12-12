package Control;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LogOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//loggs out the user and removes all session.attribute 
		HttpSession ses = request.getSession();
		if(ses.getAttribute("goodLogIn") != null) {
			ses.setMaxInactiveInterval(-1);
			ses.removeAttribute("usrName");
			ses.removeAttribute("messege");
			ses.removeAttribute("goodLogIn");
			ses.removeAttribute("usrMessege");
			response.sendRedirect("index.jsp?err=logOut");
		}else {
			response.sendRedirect("index.jsp?err=noLogOut");	
		}
		
		
	}

}
