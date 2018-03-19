package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import service.DataService;

/**
 * Servlet implementation class NewBlogServlet
 */
@WebServlet("/NewBlogServlet")
public class NewBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		DataService ds = new DataService();
		Blog blog = new Blog();
		blog.setUserId(1001);
		blog.setTitle(title);
		blog.setContent(content);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.flush();
		boolean success = false;
		try {
			success = ds.add(blog);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(String.format("{'success':'{0}'}", success));

		
	}

}
