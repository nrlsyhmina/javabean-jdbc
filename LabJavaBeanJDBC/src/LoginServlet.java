import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginS")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, java.io.IOException { 
		try { 
			UserBean user = new UserBean();
			user.setUsername(request.getParameter("un"));
			user.setPassword(request.getParameter("pw"));
			user = UserDAO.login(user);
			if (user.isValid()) { // logged-in page
				HttpSession session = request.getSession(true);
				session.setAttribute("firstName", user.getFirstName());
				session.setAttribute("userid", user.getUserid());
				request.setAttribute("userList", UserDAO.getAll());
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			} else response.sendRedirect("invalidlogin.jsp"); // error page 
		}
		catch(Throwable theException)
		{
			System.out.println(theException);
		}
	}
}
