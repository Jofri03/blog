package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import service.DataService;

/**
 * Servlet implementation class ViewBlogServlet
 */
@WebServlet("/ViewBlogServlet")
public class ViewBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String blogIdStr = request.getParameter("blogid");
		if (!blogIdStr.matches("\\d+")) {
			response.getWriter().append("Error blog id: ").append(request.getContextPath());
			return;
		}
		
		int blogId = Integer.parseInt(blogIdStr);
		DataService ds = new DataService();
		try {
			Blog blog = ds.getOne(blogId);
			if (blog == null) {
				response.getWriter().append("Can't find the blog by the gaven id: ").append(request.getContextPath());
				return;
			}
			request.setAttribute("blog", blog);
			request.getRequestDispatcher("ViewBlog.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
