package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Blog;

// The Service for Blog
public class DataService {

    private Connection conn;
    public DataService() {
      try {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://108.61.89.50:3306/blogdb?useSSL=false", "cun", "123456");
      } catch (Exception ex) {
        System.out.println(ex);
      }
    }

    // Fetch all the blogs at once.
    public List<Blog> getAll() throws SQLException {
      List<Blog> blogs = new ArrayList<>();
      Statement stmt = conn.createStatement();
      String strSelect = "select * from blog";
      ResultSet rset = stmt.executeQuery(strSelect);
      while (rset.next()) {
        Blog temp = new Blog();
        int blogId = rset.getInt("id");
        String title = rset.getString("title");
        String content = rset.getString("content");
        temp.setId(blogId);
        temp.setTitle(title);
        temp.setContent(content);
        blogs.add(temp);
      }
      return blogs;
    }

    // Fetch one blog by id.
    public Blog getOne(int id) throws SQLException {
      Blog blog = new Blog();
      Statement stmt = conn.createStatement();
      String strSelect = "select * from blog where id = " + id;
      ResultSet rset = stmt.executeQuery(strSelect);
      rset.next();
      int blogId = rset.getInt("id");
      String title = rset.getString("title");
      String content = rset.getString("content");
      blog.setId(blogId);
      blog.setTitle(title);
      blog.setContent(content);
      return blog;
    }

    // Add a new blog.
    public boolean add(Blog blog) throws SQLException {
      String SQL = "INSERT INTO blog(title, content, user_id) VALUES(?, ?, ?)";
      PreparedStatement pstmt = conn.prepareStatement(SQL);
      pstmt.setString(1, blog.getTitle());
      pstmt.setString(2, blog.getContent());
      pstmt.setInt(3, blog.getUserId());
      int count = pstmt.executeUpdate();
      return count > 0;
    }

    // Delete a blog by id.
    public boolean delete(int id) throws SQLException {
      String SQL = "DELETE FROM blog WHERE id = ? ";
      PreparedStatement pstmt = conn.prepareStatement(SQL);
      pstmt.setInt(1, id);
      System.out.println(pstmt);
      pstmt.executeUpdate();
      return true;
    }

    // Modify a blog.
    public boolean modify(Blog blog) throws SQLException {
      String SQL = "UPDATE blog SET title = ?, content = ? where id = ?";
      PreparedStatement pstmt = conn.prepareStatement(SQL);
      pstmt.setString(1, blog.getTitle());
      pstmt.setString(2, blog.getContent());
      pstmt.setInt(3, blog.getId());
      System.out.println(pstmt);
      pstmt.executeUpdate();
      return true;
    }
}
