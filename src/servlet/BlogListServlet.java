package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import model.User;
import service.DataService;

/**
 * Servlet implementation class BlogListServlet
 */
@WebServlet("/BlogListServlet")
public class BlogListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BlogListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataService ds = new DataService();
		List<Blog> blogs = null;
		try {
			blogs = ds.getAll();
			Collections.sort(blogs, new Comparator<Blog>() {
				@Override
				public int compare(Blog o1, Blog o2) {
					return o2.getId() - o1.getId();
				}
			});
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Send blogs to the blog list page. (Matthew 3/19)
		request.setAttribute("blogData", blogs);
		
		User user = null;
		if (request.getSession().getAttribute("user") == null) {
			user = (User)request.getSession().getAttribute("user");
		}
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("BlogList.jsp");
		rd.forward(request, response);

	}

}
