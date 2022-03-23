package kiemtra;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bai3
 */
@MultipartConfig
@WebServlet("/bai3")
public class bai3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bai3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			LoginUser user = new LoginUser();
			BeanUtils.populate(user, request.getParameterMap());
			if(user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("username", user.getUsername());
				request.setAttribute("message", "Login Successfully");
				if(user.isCheckbox()) {
					CookieUtils.add("username", user.getUsername(), 2,response);
				}
				else {
					CookieUtils.add("username", user.getUsername(), 0, response);
				}
			}
			else {
				request.setAttribute("message", "Inalid username or password");
			}
		} catch (Exception e) {
			
		}
		RequestDispatcher rd=request.getRequestDispatcher("/view/formLogin/index.jsp");
		rd.forward(request, response);

}

}
