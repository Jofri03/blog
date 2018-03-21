package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserService;
import com.google.gson.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.html").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.sendRedirect("http://www.google.com");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean isRemember = Boolean.parseBoolean(request.getParameter("remember"));
		System.out.println("isRemember" + isRemember);

		User u = null;
		UserService us = new UserService();
		Map<String, Boolean> map = new HashMap<>();
		map.put("result", false);
		Gson gson = new Gson();


		try {
			u = us.login(email, password);

			if (u != null) {
//				request.getServletContext().setAttribute("user", u);
				request.getSession().setAttribute("user", u);

				if (isRemember) {
					Cookie cookie = new Cookie("user",String.valueOf(u.getId()));
					cookie.setMaxAge(60*60*24*30); // one month
					response.addCookie(cookie);
				}
			}
			map.put("result", u != null);
			System.out.println(gson.toJson(map));
			response.getWriter().write(gson.toJson(map));
			response.getWriter().flush();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(gson.toJson(map));
			response.getWriter().write(gson.toJson(map));
			response.getWriter().flush();
		}

	}

}
