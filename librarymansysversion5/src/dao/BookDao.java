package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Book;

/**
 *
 * @author elvin
 */
public class BookDao {
    // jdbc variables
    private String url = "jdbc:mysql://localhost:3306/library1_db";
    private String user = "root";   // default XAMPP MySQL user
    private String password = "";   // default XAMPP password is empty

    // CRUD
    // CREATE ~ INSERT
    public Integer createBook(Book bookObj){
        // step0: surround with try and catch
        try{
            // Load MySQL JDBC Driver
            // step1: create/ establish connection
            Connection con = DriverManager.getConnection(url, user, password);
            // step 2: prepare the statement
            String sql = "INSERT INTO book (bookCode, bookName, authorName, price) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, bookObj.getBookCode());
            pst.setString(2, bookObj.getBookName());
            pst.setString(3, bookObj.getAuthorName());
            pst.setDouble(4, bookObj.getPrice());
            // step 3: execute prepared statement
            int rowsAffected = pst.executeUpdate();
            // step 4: close connection
            return rowsAffected;
        }catch(Exception ex){
            ex.printStackTrace();
            return 0;
        }
    }

    // UPDATE
    public Integer updateBook(Book bookObj) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "UPDATE book SET bookName = ?, authorName = ?, price = ? WHERE bookCode = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, bookObj.getBookName());
            pst.setString(2, bookObj.getAuthorName());
            pst.setDouble(3, bookObj.getPrice());
            pst.setString(4, bookObj.getBookCode());
            int rowsAffected = pst.executeUpdate();
            return rowsAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    // DELETE
    public Integer deleteBook(String bookCode) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "DELETE FROM book WHERE bookCode = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, bookCode);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    // SEARCH
    public Book searchBookByCode(String bookCode) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM book WHERE bookCode = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, bookCode);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Book book = new Book();
                book.setBookCode(rs.getString("bookCode"));
                book.setBookName(rs.getString("bookName"));
                book.setAuthorName(rs.getString("authorName"));
                book.setPrice(rs.getDouble("price"));
                return book;
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // RETRIEVE
    public List<Book> retrieveAllBooks() {
        List<Book> books = new ArrayList<>();
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM book";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBookCode(rs.getString("bookCode"));
                book.setBookName(rs.getString("bookName"));
                book.setAuthorName(rs.getString("authorName"));
                book.setPrice(rs.getDouble("price"));
                books.add(book);
            }
            return books;
        } catch (Exception ex) {
            ex.printStackTrace();
            return books;
        }
    }
}
