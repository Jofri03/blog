package service;

// The Service for Blog
public class DataService {

    private Connection conn;
    public DataService() {
      try {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://45.77.144.61:3306/blogdb?userSSL=false", "root", "123456");
      } catch (Exception ex) {
        System.out.println(ex);
      }
    }

    // Fetch all the blogs at once.
    public List<Blog> getAll() {
      List<Blog> blogs = new ArrayList<>();
      Statement stmt = conn.createStatement();
      String strSelect = "select * from blog";
      ResultSet rset = stmt.executeQuery(strSelect);
      while (rset.next()) {
        Blog temp = new Blog();
        temp.title = rset.getString("title");
        temp.content = rset.getString("content");
        System.out.println(title + ", " + content);
        blogs.append(temp);
      }
      return blogs;
    }

    // Fetch one blog by id.
    public Blog getOne(int id) {
      Blog blog = new Blog();
      Statement stmt = conn.createStatement();
      String strSelect = "select * from blog where id = " + id;
      ResultSet rset = stmt.executeQuery(strSelect);
      rset.next();
      blog.title = rset.getString("title");
      blog.content = rset.getString("content");
      return blog;
    }

    // Add a new blog.
    public boolean add(Blog blog) {
      Statement stmt = conn.createStatement();
      String strSelect = String.format("insert into blog(title, content, user_id) " +
                         "values({0}, {1}, {2})", blog.title, blog.content, blog.user_id);

      stmt.executeUpdate(strSelect, Statement.RETURN_GENERATED_KEYS);
      ResultSet rs = stmt.getGeneratedKeys();
      rs.next();
      int pk = rs.getInt(1);
      return pk > 0;
    }

    // Delete a blog by id.
    public boolean delete(init id) {
      String SQL = "DELETE FROM blog WHERE id = ? ";
      PreparedStatement pstmt = conn.prepareStatement(SQL);
      pstmt.setString(1, id);
      pstmt.executeUpdate();
      return true;
    }

    // Modify a blog.
    public boolean modify(Blog b) {
      String SQL = "UPDATE blog SET title = ?, set content = ? where id = ?";
      PreparedStatement pstmt = conn.prepareStatement(SQL);
      pstmt.setString(1, blog.title);
      pstmt.setString(2, blog.content);
      pstmt.setString(3, blog.id);
      pstmt.executeUpdate();
      return true;
    }
}
