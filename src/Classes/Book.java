/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author Group 20
 */
public class Book {

    public String bookId,
            isbn,
            title,
            series,
            category,
            edition,
            volume,
            language,
            author1,
            author2;
    public Date addDate;
    public String publisher;
    public Date publishDate;
    public int quantity;
    public double price;
    public String summary;

    public Book() {
    }

    public Book(String bookId) {
        this.bookId = bookId;
    }
    
    public void reset() {
        bookId = "";
        isbn = "";
        title = "";
        series = "";
        category = "";
        edition = "";
        volume = "";
        language = "";
        author1 = "";
        author2 = "";
        addDate = null;
        publisher = "";
        publishDate = null;
        quantity = 0;
        price = 0;
        summary = "";
    }
}
