/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Date;

/**
 *
 * @author Group 20
 */
public class Lend_Return {

    public Lend_Return(String memberType, String memberId, String bookId, Date lendDate, Date shouldReturnDate, Date returnDate) {
        this.memberType = memberType;
        this.memberId = memberId;
        this.bookId = bookId;
        this.lendDate = lendDate;
        this.shouldReturnDate = shouldReturnDate;
        this.returnDate = returnDate;
    }
    public String memberType;
    public String memberId;
    public String bookId;
    public Date lendDate;
    public Date returnDate;
    public Date shouldReturnDate;
}
