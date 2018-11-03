package entiy;

public class Book {
    private int bookid;
    private String bookname;
    private String author;
    private String publish;
    private double price;
    private String description_;

    public Book() {
    }

    public Book(int bookid, String bookname, String author, String publish, double price, String description_) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
        this.publish = publish;
        this.price = price;
        this.description_ = description_;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                ", price=" + price +
                ", description_='" + description_ + '\'' +
                '}';
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription_() {
        return description_;
    }

    public void setDescription_(String description_) {
        this.description_ = description_;
    }
}
