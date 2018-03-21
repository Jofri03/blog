package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import com.google.gson.*;

// The Service for Blog
public class DataService {

//    private Connection conn;
    public DataService() {
    }
    
    	private Connection getConn() {
    		try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				return DriverManager.getConnection("jdbc:mysql://45.77.144.61:3306/blogdb?useSSL=false", "cun", "123456");
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e)  {
				e.printStackTrace();
			}
			return null;
    		
    }
    // Fetch all the blogs at once.
    public List<Blog> getAll() throws SQLException {
      List<Blog> blogs = new ArrayList<>();
      Connection conn = getConn();
      Statement stmt = conn.createStatement();
      String strSelect = "select * from blog";
      ResultSet rset = stmt.executeQuery(strSelect);
      while (rset.next()) {
        Blog temp = new Blog();
        int blogId = rset.getInt("id");
        String title = rset.getString("title");
        String content = rset.getString("content");
        Date createdDate = rset.getDate("create_time");
        temp.setId(blogId);
        temp.setTitle(title);
        temp.setContent(content);
        temp.setCreatedDate(createdDate);
        blogs.add(temp);
      }
      conn.close();
      return blogs;
    }
    public String getAllJson() throws SQLException {
    	return new Gson().toJson(this.getAll());
    }

    // Fetch one blog by id.
    public Blog getOne(int id) throws SQLException {
      Blog blog = new Blog();
      Connection conn = getConn();
      Statement stmt = conn.createStatement();
      String strSelect = "select * from blog where id = " + id;
      ResultSet rset = stmt.executeQuery(strSelect);
      rset.next();
      int blogId = rset.getInt("id");
      String title = rset.getString("title");
      String content = rset.getString("content");
      Date createdDate = rset.getDate("create_time");
      blog.setId(blogId);
      blog.setTitle(title);
      blog.setContent(content);
      blog.setCreatedDate(createdDate);
      conn.close();
      return blog;
    }
    
    public String getOneJson(int id) throws SQLException {
    	return new Gson().toJson(this.getOne(id));
    }

    // Add a new blog.
    public int add(Blog blog) throws SQLException {
      String SQL = "INSERT INTO blog(title, content, user_id) VALUES(?, ?, ?)";
      Connection conn = getConn();
      PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      pstmt.setString(1, blog.getTitle());
      pstmt.setString(2, blog.getContent());
      pstmt.setInt(3, blog.getUserId());
      System.out.println(pstmt);
      pstmt.executeUpdate();
      ResultSet keys = pstmt.getGeneratedKeys();    
      keys.next();  
      int blogId = keys.getInt(1);
      conn.close();
      return blogId;
    }

    // Delete a blog by id.
    public boolean delete(int id) throws SQLException {
      String SQL = "DELETE FROM blog WHERE id = ? ";
      Connection conn = getConn();
      PreparedStatement pstmt = conn.prepareStatement(SQL);
      pstmt.setInt(1, id);
      System.out.println(pstmt);
      pstmt.executeUpdate();
      conn.close();
      return true;
    }

    // Modify a blog.
    public boolean modify(Blog blog) throws SQLException {
      String SQL = "UPDATE blog SET title = ?, content = ? where id = ?";
      Connection conn = getConn();
      PreparedStatement pstmt = conn.prepareStatement(SQL);
      pstmt.setString(1, blog.getTitle());
      pstmt.setString(2, blog.getContent());
      pstmt.setInt(3, blog.getId());
      System.out.println(pstmt);
      pstmt.executeUpdate();
      conn.close();
      return true;
    }

	public List<Blog> search(String keyword) throws SQLException {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM blog WHERE title  LIKE ? OR content LIKE ?";
	    Connection conn = getConn();
	    PreparedStatement pstmt = conn.prepareStatement(SQL);
	    pstmt.setString(1, "%" + keyword + "%");
	    pstmt.setString(2, "%" + keyword + "%");
	    System.out.println(pstmt);
	    List<Blog> blogs = new ArrayList<>();
	    ResultSet rset = pstmt.executeQuery();
	    while (rset.next()) {
	    		Blog temp = new Blog();
	    		int blogId = rset.getInt("id");
	    		String title = rset.getString("title");
	    		String content = rset.getString("content");
	    		Date createdDate = rset.getDate("create_time");
	    		temp.setId(blogId);
	    		temp.setTitle(title);
	    		temp.setContent(content);
	    		temp.setCreatedDate(createdDate);
	    		blogs.add(temp);
	    }
	    conn.close();
	    System.out.println("search: " + blogs.size());
	    return blogs;  
	}
}
