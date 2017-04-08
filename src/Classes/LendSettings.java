/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Group 20
 */
public class LendSettings {
    
    public String memberType;
    public int lendDays;
    public double fineForDay;
    public int maxBook;

    public LendSettings(String memberType, int lendDays, double fineForDay, int maxBook) {
        this.memberType = memberType;
        this.lendDays = lendDays;
        this.fineForDay = fineForDay;
        this.maxBook = maxBook;
    }

}
