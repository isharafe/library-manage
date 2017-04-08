/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author Group 20
 */
public class Permission {
    public ArrayList<Integer> guiId;
    public String memberType;

    public Permission(ArrayList<Integer> guiId, String memberType) {
        this.guiId = guiId;
        this.memberType = memberType;
    }
    
    public void reset(){
        memberType="";
        guiId.clear();
    }
}
