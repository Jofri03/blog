package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DataService;

/**
 * Servlet implementation class DeleteBlogServlet
 */
@WebServlet("/DeleteBlogServlet")
public class DeleteBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get and delete blog. (Matthew 3/19)
		int id = Integer.parseInt(request.getParameter("id"));
		DataService ds = new DataService();
		try {
			ds.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Return to the blog list (Matthew 3/19)
		RequestDispatcher rd = request.getRequestDispatcher("BlogListServlet.java");
		rd.forward(request, response);
	}

}
