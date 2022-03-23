package kiemtra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class bai1
 */
@MultipartConfig
@WebServlet("/bai1")
public class bai1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bai1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		RequestDispatcher rd=request.getRequestDispatcher("/view/bai1.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
//			String date =
		//lay file upload theo ten file 
		Part part =request.getPart("photo");
		// duowng dan thuc
		String realPath = request.getServletContext().getRealPath("images/");
	// //lay ten file upload
		String filename=Path.of(part.getSubmittedFileName()).getFileName().toString();
		//neu file theo duong dan ko ton tai thif tao 1 file theo thu muc realpart;
		if(!Files.exists(Path.of(realPath))){
			Files.createDirectory(Path.of(realPath));
		}
		// luu file upload vao duong dan 
		part.write(realPath+"/"+filename);
		response.getWriter().println("<img src='images/"+filename+"' width='100' height='100'>");
		String [] hobbies = request.getParameterValues("sothich");
		response.getWriter().println("<h4>So thich:</h4> ");
		for(String item: hobbies) {
			response.getWriter().println(item );
		}
		String [] date = request.getParameterValues("date");
		response.getWriter().println("<h4>date:</h4>");
		for(String item: date) {
			response.getWriter().println(item );
		}
	}
	catch(Exception e) {
	
	}
	}
}
