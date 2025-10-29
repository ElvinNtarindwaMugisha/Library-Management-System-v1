package model;

public class Book {
    // private variables
    private String bookCode;
    private String bookName;
    private String authorName;
    private Double price;

    public Book() {
    }

    public Book(String bookCode, String bookName, String authorName, Double price) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}

