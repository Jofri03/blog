package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserService {

	private Connection conn;

	public UserService() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.conn = DriverManager.getConnection("jdbc:mysql://45.77.144.61:3306/blogdb?useSSL=false", "cun",
					"123456");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// Fetch one user by email and pwd.
	public User login(String email, String pwd) throws SQLException {

		String SQL = "SELECT * FROM user WHERE email = ? AND pwd = ?";
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, email);
		pstmt.setString(2, pwd);
		System.out.println(pstmt);
		ResultSet rset = pstmt.executeQuery();

		// Empty result
		if (!rset.isBeforeFirst()) {
			return null;
		}

		rset.next();
		int userId = rset.getInt("id");
		User user = new User();
		user.setId(userId);
		user.setEmail(email);
		return user;
	}
}
