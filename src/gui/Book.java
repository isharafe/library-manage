/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Book.java
 *
 * Created on Jan 5, 2013, 11:04:09 AM
 */
package gui;

import java.awt.Component;
import javax.swing.Icon;

/**
 *
 * @author Group 20
 */
public class Book extends javax.swing.JPanel {

    /** Creates new form Book */
    public Book() {
        initComponents();
    }
    
    public void addTab(String title, Icon icon, Component c) {
        pnlBookMain.addTab(title, icon, c);
    }

    public void addTab(String title, Component c) {
        pnlBookMain.addTab(title, c);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBookMain = new javax.swing.JTabbedPane();

        pnlBookMain.setFont(new java.awt.Font("Tahoma", 1, 11));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBookMain, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBookMain, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane pnlBookMain;
    // End of variables declaration//GEN-END:variables
}
