/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BookSearch.java
 *
 * Created on Jan 5, 2013, 11:05:40 AM
 */
package gui;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static Db.DB.*;

/**
 *
 * @author Group 20
 */
public class BookSearch extends javax.swing.JPanel {

    /** Creates new form BookSearch */
    DefaultTableModel resultTable;
    String[] searchString;
    Classes.Book book;

    public BookSearch() {
        initComponents();
        searchString = new String[10];
        for (int i = 0; i < searchString.length; i++) {
            searchString[i] = "";
        }
        resultTable = (DefaultTableModel) tblResult.getModel();
        book = new Classes.Book();
        btnUpdate.setVisible(false);
        btnDelete.setVisible(false);
    }

    void enableChangeData() {
        btnUpdate.setVisible(true);
        btnDelete.setVisible(true);
    }

    private void search(String[] keyword) {
        try {
            resultTable.setRowCount(0);
            ResultSet rset2;
            Statement stmt1 = getConnection().createStatement();
            Statement stmt2 = getConnection().createStatement();
            ResultSet rset1 = stmt1.executeQuery("SELECT book_id, isbn, title, author1, quantity FROM book WHERE "
                    + "book_id LIKE '%" + keyword[0] + "%' AND "
                    + "isbn LIKE '" + keyword[1] + "%' AND "
                    + "title LIKE '%" + keyword[2] + "%' AND "
                    + "series LIKE '%" + keyword[3] + "%' AND "
                    + "category LIKE '%" + keyword[4] + "%' AND "
                    + "language LIKE '" + keyword[5] + "%' AND "
                    + "author1 LIKE '%" + keyword[6] + "%' AND "
                    + "author2 LIKE '%" + keyword[7] + "%' AND "
                    + "publisher LIKE '%" + keyword[8] + "%'");

            while (rset1.next()) {
                ArrayList ast = new ArrayList();
                ast.add(rset1.getString(1));
                ast.add(rset1.getString(2));
                ast.add(rset1.getString(3));
                ast.add(rset1.getString(4));
                rset2 = stmt2.executeQuery("SELECT COUNT(*) FROM lend_return "
                        + "WHERE book_id='" + rset1.getString(1) + "' AND lend_date>return_date");
                if (rset2.next()) {
                    ast.add(rset1.getInt(5) - rset2.getInt(1));
                } else {
                    ast.add(rset1.getInt(5));
                }
                resultTable.addRow(ast.toArray());
                rset2.close();
            }
            rset1.close();
            stmt1.close();
            stmt2.close();

        } catch (Exception ex) {
            Logger.getLogger(BookSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSearchBook = new javax.swing.JPanel();
        txtSearchBookId = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtSearchIsbnNo = new javax.swing.JTextField();
        txtSearchTitle = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtSearchSeries = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtSearchEdition = new javax.swing.JTextField();
        txtSearchVolume = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtSearchAuthor1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtSearchAuthor2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtSearchPublisher = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtSearchLanguage = new javax.swing.JTextField();
        dtSearchAddDate = new datechooser.beans.DateChooserCombo();
        dtSearchPublishDate = new datechooser.beans.DateChooserCombo();
        jLabel43 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        txtSearchCategory = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSearchSummary = new javax.swing.JTextArea();
        jLabel40 = new javax.swing.JLabel();
        txtSearchPrice1 = new javax.swing.JTextField();
        txtSearchQuantity = new components.IntegerTextField();
        txtSearchPrice = new components.DoubleTextField();

        pnlSearchBook.setBackground(new java.awt.Color(204, 204, 204));

        txtSearchBookId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBookIdKeyReleased(evt);
            }
        });

        jLabel19.setText("Book Id :");

        jLabel20.setText("ISBN No :");

        txtSearchIsbnNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchIsbnNoKeyReleased(evt);
            }
        });

        txtSearchTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchTitleKeyReleased(evt);
            }
        });

        jLabel21.setText("Title :");

        jLabel22.setText("Series :");

        txtSearchSeries.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchSeriesKeyReleased(evt);
            }
        });

        jLabel23.setText("Category :");

        jLabel24.setText("Edition :");

        jLabel25.setText("Voloume :");

        jLabel26.setText("Language :");

        txtSearchAuthor1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchAuthor1KeyReleased(evt);
            }
        });

        jLabel27.setText("Author :");

        jLabel28.setText("Additional Author :");

        txtSearchAuthor2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchAuthor2KeyReleased(evt);
            }
        });

        jLabel30.setText("Add Date :");

        txtSearchPublisher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchPublisherKeyReleased(evt);
            }
        });

        jLabel31.setText("Publisher :");

        jLabel32.setText("Published Date :");

        jLabel36.setFont(new java.awt.Font("Cambria Math", 1, 14));
        jLabel36.setText("Results :");

        txtSearchLanguage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchLanguageKeyReleased(evt);
            }
        });

        jLabel43.setText("Quantity :");

        jLabel39.setText("Price :");

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnClear)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "ISBN", "Name", "Author", "Availble Books"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblResult);

        txtSearchCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchCategoryKeyReleased(evt);
            }
        });

        jLabel1.setText("Summary :");

        txtSearchSummary.setColumns(20);
        txtSearchSummary.setRows(5);
        jScrollPane1.setViewportView(txtSearchSummary);

        jLabel40.setText("Book Rack : ");

        javax.swing.GroupLayout pnlSearchBookLayout = new javax.swing.GroupLayout(pnlSearchBook);
        pnlSearchBook.setLayout(pnlSearchBookLayout);
        pnlSearchBookLayout.setHorizontalGroup(
            pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchBookLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel43)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearchPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchPrice1)
                    .addComponent(dtSearchPublishDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchPublisher)
                    .addComponent(dtSearchAddDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchLanguage)
                    .addComponent(txtSearchAuthor2)
                    .addComponent(txtSearchTitle)
                    .addComponent(txtSearchSeries)
                    .addComponent(txtSearchIsbnNo)
                    .addComponent(txtSearchBookId)
                    .addComponent(txtSearchVolume)
                    .addComponent(txtSearchEdition)
                    .addComponent(txtSearchAuthor1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(txtSearchCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSearchBookLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlSearchBookLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchBookLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel36)
                        .addGap(38, 38, 38))))
        );
        pnlSearchBookLayout.setVerticalGroup(
            pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchBookLayout.createSequentialGroup()
                .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSearchBookLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchBookId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSearchBookLayout.createSequentialGroup()
                                .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSearchIsbnNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSearchTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSearchSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(txtSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchBookLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlSearchBookLayout.createSequentialGroup()
                        .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtSearchLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchAuthor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchAuthor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(dtSearchAddDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(dtSearchPublishDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel43)
                                .addComponent(txtSearchQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlSearchBookLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39)
                                    .addComponent(txtSearchPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txtSearchPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, 0, 0, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSearchBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchBookIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBookIdKeyReleased
        searchString[0] = txtSearchBookId.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearchBookIdKeyReleased

    private void txtSearchIsbnNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchIsbnNoKeyReleased
        searchString[1] = txtSearchIsbnNo.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearchIsbnNoKeyReleased

    private void txtSearchTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchTitleKeyReleased
        searchString[2] = txtSearchTitle.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearchTitleKeyReleased

    private void txtSearchSeriesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchSeriesKeyReleased
        searchString[3] = txtSearchSeries.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearchSeriesKeyReleased

    private void txtSearchCategoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchCategoryKeyReleased
        searchString[4] = txtSearchCategory.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearchCategoryKeyReleased

    private void txtSearchLanguageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchLanguageKeyReleased
        searchString[5] = txtSearchLanguage.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearchLanguageKeyReleased

    private void txtSearchAuthor1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchAuthor1KeyReleased
        searchString[6] = txtSearchAuthor1.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearchAuthor1KeyReleased

    private void txtSearchAuthor2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchAuthor2KeyReleased
        searchString[7] = txtSearchAuthor2.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearchAuthor2KeyReleased

    private void txtSearchPublisherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchPublisherKeyReleased
        searchString[8] = txtSearchPublisher.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearchPublisherKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Book details of the given book id will change to \n current data.\nProceed?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {

            book.bookId = txtSearchBookId.getText();
            book.isbn = txtSearchIsbnNo.getText();
            book.title = txtSearchTitle.getText();
            book.series = txtSearchSeries.getText();
            book.category = txtSearchCategory.getText();
            book.edition = txtSearchEdition.getText();
            book.volume = txtSearchVolume.getText();
            book.language = txtSearchLanguage.getText();
            book.author1 = txtSearchAuthor1.getText();
            book.author2 = txtSearchAuthor2.getText();
            book.addDate = dtSearchAddDate.getSelectedDate().getTime();
            book.publisher = txtSearchPublisher.getText();
            book.publishDate = dtSearchPublishDate.getSelectedDate().getTime();
            try {
                book.quantity = Integer.parseInt(txtSearchQuantity.getText());
                book.price = Double.parseDouble(txtSearchPrice.getText());
                book.summary = txtSearchSummary.getText();
                if (book.bookId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Book ID cannot be empty...");
                } else {
                    updateData(book);
                    JOptionPane.showMessageDialog(null, "Update success");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "You have entered invalid values for Quantity Or Unit price.");
                Logger.getLogger(BookNew.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error occured while updating book..");
                Logger.getLogger(BookSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultMouseClicked
        if (evt.getClickCount() == 2 && tblResult.getSelectedRowCount() > 0) {
            try {
                Statement stmt = getConnection().createStatement();
                ResultSet rset = stmt.executeQuery("SELECT * FROM book WHERE book_id='" + tblResult.getValueAt(tblResult.getSelectedRow(), 0).toString() + "'");
                if (rset.next()) {
                    txtSearchBookId.setText(rset.getString(1));
                    txtSearchIsbnNo.setText(rset.getString(2));
                    txtSearchTitle.setText(rset.getString(3));
                    txtSearchSeries.setText(rset.getString(4));
                    txtSearchCategory.setText(rset.getString(5));
                    txtSearchEdition.setText(rset.getString(6));
                    txtSearchVolume.setText(rset.getString(7));
                    txtSearchLanguage.setText(rset.getString(8));
                    txtSearchAuthor1.setText(rset.getString(9));
                    txtSearchAuthor2.setText(rset.getString(10));
                    Calendar c = Calendar.getInstance();
                    c.setTime(rset.getDate(11));
                    dtSearchAddDate.setSelectedDate(c);
                    txtSearchPublisher.setText(rset.getString(12));
                    c.setTime(rset.getDate(13));
                    dtSearchPublishDate.setSelectedDate(c);
                    txtSearchQuantity.setText(rset.getString(14));
                    txtSearchPrice.setText(rset.getString(15));
                    txtSearchSummary.setText(rset.getString(16));
                }
                rset.close();
                stmt.close();
            } catch (Exception ex) {
                Logger.getLogger(BookSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblResultMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Are you sure to delete this book..", "Confirm", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            try {
                deleteData(new Classes.Book(txtSearchBookId.getText()));
                JOptionPane.showMessageDialog(null, "Book details deleted");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error occured while deleting book..");
                Logger.getLogger(BookSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtSearchAuthor1.setText("");
        txtSearchAuthor2.setText("");
        txtSearchBookId.setText("");
        txtSearchCategory.setText("");
        txtSearchEdition.setText("");
        txtSearchIsbnNo.setText("");
        txtSearchLanguage.setText("");
        txtSearchPublisher.setText("");
        txtSearchQuantity.setText("");
        txtSearchSeries.setText("");
        txtSearchSummary.setText("");
        txtSearchTitle.setText("");
        txtSearchPrice.setText("");
        txtSearchVolume.setText("");
        book.reset();
    }//GEN-LAST:event_btnClearActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private datechooser.beans.DateChooserCombo dtSearchAddDate;
    private datechooser.beans.DateChooserCombo dtSearchPublishDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel pnlSearchBook;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextField txtSearchAuthor1;
    private javax.swing.JTextField txtSearchAuthor2;
    private javax.swing.JTextField txtSearchBookId;
    private javax.swing.JTextField txtSearchCategory;
    private javax.swing.JTextField txtSearchEdition;
    private javax.swing.JTextField txtSearchIsbnNo;
    private javax.swing.JTextField txtSearchLanguage;
    private components.DoubleTextField txtSearchPrice;
    private javax.swing.JTextField txtSearchPrice1;
    private javax.swing.JTextField txtSearchPublisher;
    private components.IntegerTextField txtSearchQuantity;
    private javax.swing.JTextField txtSearchSeries;
    private javax.swing.JTextArea txtSearchSummary;
    private javax.swing.JTextField txtSearchTitle;
    private javax.swing.JTextField txtSearchVolume;
    // End of variables declaration//GEN-END:variables
}