/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MemberNew.java
 *
 * Created on Jan 5, 2013, 11:04:51 AM
 */
package gui;

import javax.swing.JOptionPane;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Db.DB.*;

/**
 *
 * @author Group 20
 */
public class MemberNew extends javax.swing.JPanel {

    /** Creates new form MemberNew */
    Classes.Member m;

    public MemberNew() {
        initComponents();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            }
        });
        m = new Classes.Member();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNewRegistration = new javax.swing.JPanel();
        pnlNewRegistration1 = new javax.swing.JPanel();
        lblMembershipId = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblMemberType = new javax.swing.JLabel();
        lblDob = new javax.swing.JLabel();
        lblFristName = new javax.swing.JLabel();
        lblTelephone = new javax.swing.JLabel();
        lblEMail = new javax.swing.JLabel();
        txtMemberId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        cmbGender = new javax.swing.JComboBox();
        txtTelephone = new javax.swing.JTextField();
        txtEMail = new javax.swing.JTextField();
        cmbMemberType = new javax.swing.JComboBox();
        pnlNewRegistrationButton = new javax.swing.JPanel();
        btnNewRegistrationAdd = new javax.swing.JButton();
        btnNewRegistrationClear = new javax.swing.JButton();
        dtDob = new datechooser.beans.DateChooserCombo();
        lblNewRegistrationFeedBacks = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtFeedBack = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        lblMembershipId1 = new javax.swing.JLabel();
        pswPassword = new javax.swing.JPasswordField();
        lblMembershipId2 = new javax.swing.JLabel();
        pswConfirmPassword = new javax.swing.JPasswordField();

        pnlNewRegistration.setBackground(new java.awt.Color(153, 153, 153));

        pnlNewRegistration1.setBackground(new java.awt.Color(204, 204, 204));

        lblMembershipId.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMembershipId.setText("Member ID :");

        lblAddress.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblAddress.setText("Address :");

        lblGender.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblGender.setText("Gender :");

        lblMemberType.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMemberType.setText("Member Type :");

        lblDob.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblDob.setText("D.O.B :");

        lblFristName.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblFristName.setText("Full Name :");

        lblTelephone.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblTelephone.setText("Telephone :");

        lblEMail.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblEMail.setText("E-Mail :");

        txtMemberId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMemberIdFocusLost(evt);
            }
        });

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Gender", "Male", "Female" }));

        cmbMemberType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[Select Type]" }));

        pnlNewRegistrationButton.setBackground(new java.awt.Color(102, 102, 102));
        pnlNewRegistrationButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnNewRegistrationAdd.setText("Save");
        btnNewRegistrationAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRegistrationAddActionPerformed(evt);
            }
        });

        btnNewRegistrationClear.setText("Clear");
        btnNewRegistrationClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRegistrationClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNewRegistrationButtonLayout = new javax.swing.GroupLayout(pnlNewRegistrationButton);
        pnlNewRegistrationButton.setLayout(pnlNewRegistrationButtonLayout);
        pnlNewRegistrationButtonLayout.setHorizontalGroup(
            pnlNewRegistrationButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewRegistrationButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNewRegistrationButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewRegistrationClear, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewRegistrationAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNewRegistrationButtonLayout.setVerticalGroup(
            pnlNewRegistrationButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewRegistrationButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNewRegistrationAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNewRegistrationClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNewRegistrationFeedBacks.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblNewRegistrationFeedBacks.setText("Feed Backs on this Member :");

        txtFeedBack.setColumns(20);
        txtFeedBack.setRows(5);
        jScrollPane1.setViewportView(txtFeedBack);

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane6.setViewportView(txtAddress);

        lblMembershipId1.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMembershipId1.setText("Password :");

        lblMembershipId2.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMembershipId2.setText("Confirm Password :");

        pswConfirmPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pswConfirmPasswordFocusLost(evt);
            }
        });

        javax.swing.GroupLayout pnlNewRegistration1Layout = new javax.swing.GroupLayout(pnlNewRegistration1);
        pnlNewRegistration1.setLayout(pnlNewRegistration1Layout);
        pnlNewRegistration1Layout.setHorizontalGroup(
            pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNewRegistration1Layout.createSequentialGroup()
                .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlNewRegistration1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMembershipId)
                            .addComponent(lblMemberType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMemberId)
                            .addComponent(cmbMemberType, 0, 148, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMembershipId2)
                            .addComponent(lblMembershipId1))
                        .addGap(18, 18, 18)
                        .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pswConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(pswPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                        .addGap(10, 10, 10))
                    .addGroup(pnlNewRegistration1Layout.createSequentialGroup()
                        .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlNewRegistration1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblFristName)
                                        .addGroup(pnlNewRegistration1Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblGender)
                                                .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblAddress)
                                                    .addComponent(lblDob)))))
                                    .addComponent(lblTelephone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNewRegistration1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEMail)
                                .addGap(12, 12, 12)))
                        .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dtDob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtEMail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTelephone, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlNewRegistration1Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(lblNewRegistrationFeedBacks, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNewRegistration1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNewRegistration1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlNewRegistrationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))))
                .addContainerGap())
        );
        pnlNewRegistration1Layout.setVerticalGroup(
            pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewRegistration1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMemberType)
                    .addComponent(cmbMemberType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMembershipId)
                    .addComponent(txtMemberId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pswPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMembershipId1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMembershipId2)
                    .addComponent(pswConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFristName)
                    .addComponent(txtName)
                    .addComponent(lblNewRegistrationFeedBacks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlNewRegistration1Layout.createSequentialGroup()
                        .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGender)
                            .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNewRegistration1Layout.createSequentialGroup()
                                .addComponent(lblDob)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAddress))
                            .addGroup(pnlNewRegistration1Layout.createSequentialGroup()
                                .addComponent(dtDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelephone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlNewRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEMail)))
                    .addGroup(pnlNewRegistration1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlNewRegistrationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout pnlNewRegistrationLayout = new javax.swing.GroupLayout(pnlNewRegistration);
        pnlNewRegistration.setLayout(pnlNewRegistrationLayout);
        pnlNewRegistrationLayout.setHorizontalGroup(
            pnlNewRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNewRegistrationLayout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(pnlNewRegistration1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        pnlNewRegistrationLayout.setVerticalGroup(
            pnlNewRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewRegistrationLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(pnlNewRegistration1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNewRegistration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNewRegistration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMemberIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMemberIdFocusLost
        //
}//GEN-LAST:event_txtMemberIdFocusLost

    private void btnNewRegistrationAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRegistrationAddActionPerformed
        m.address = txtAddress.getText();
        m.dob = new Date(dtDob.getSelectedDate().getTimeInMillis());
        m.email = txtEMail.getText();
        m.feedBack = txtFeedBack.getText();
        m.gender = cmbGender.getSelectedItem().toString().charAt(0);
        m.name = txtName.getText();
        m.tp = txtTelephone.getText();
        m.userName = txtMemberId.getText();
        m.userType = cmbMemberType.getSelectedItem().toString();
        if (!String.valueOf(pswPassword.getPassword()).equals(String.valueOf(pswConfirmPassword.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Password does not match.\nTry again.");
        } else {
            m.password = String.valueOf(pswConfirmPassword.getPassword());

            try {
                if (m.userName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Member ID cannot be empty...");
                } else if (cmbMemberType.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Select member type first.");
                } else {
                    saveData(m);
                    JOptionPane.showMessageDialog(null, "Save success");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "You have entered invalid values for Quantity Or Unit price.");
                Logger.getLogger(MemberNew.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Save failed");
                Logger.getLogger(MemberNew.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                m.reset();
            }
        }
}//GEN-LAST:event_btnNewRegistrationAddActionPerformed

    private void btnNewRegistrationClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRegistrationClearActionPerformed
        txtMemberId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtTelephone.setText("");
        txtEMail.setText("");
        txtFeedBack.setText("");
        pswConfirmPassword.setText("");
        pswPassword.setText("");
        m.reset();
}//GEN-LAST:event_btnNewRegistrationClearActionPerformed

    private void pswConfirmPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pswConfirmPasswordFocusLost
        if (!String.valueOf(pswPassword.getPassword()).equals(String.valueOf(pswConfirmPassword.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Password does not match.\nTry again.");
        }
    }//GEN-LAST:event_pswConfirmPasswordFocusLost
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewRegistrationAdd;
    private javax.swing.JButton btnNewRegistrationClear;
    private javax.swing.JComboBox cmbGender;
    public javax.swing.JComboBox cmbMemberType;
    private datechooser.beans.DateChooserCombo dtDob;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblEMail;
    private javax.swing.JLabel lblFristName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblMemberType;
    private javax.swing.JLabel lblMembershipId;
    private javax.swing.JLabel lblMembershipId1;
    private javax.swing.JLabel lblMembershipId2;
    private javax.swing.JLabel lblNewRegistrationFeedBacks;
    private javax.swing.JLabel lblTelephone;
    private javax.swing.JPanel pnlNewRegistration;
    private javax.swing.JPanel pnlNewRegistration1;
    private javax.swing.JPanel pnlNewRegistrationButton;
    private javax.swing.JPasswordField pswConfirmPassword;
    private javax.swing.JPasswordField pswPassword;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtEMail;
    private javax.swing.JTextArea txtFeedBack;
    private javax.swing.JTextField txtMemberId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables
}
