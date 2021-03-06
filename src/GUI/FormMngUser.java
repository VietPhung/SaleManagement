/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BusinessLogic.AppPublic;
import BusinessLogic.IManageableForm;
import BusinessLogic.MoneyFormatter;
import BusinessLogic.PrimalObject;
import BusinessLogic.User;
import BusinessLogic.UserManagement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
//import javafx.scene.input.KeyEvent;
import java.text.SimpleDateFormat; 
import java.util.Date;
import javax.swing.JOptionPane;


import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Duc Tai
 */
public class FormMngUser extends javax.swing.JFrame implements IManageableForm{

    /**
     * Creates new form FormMngUser
     */
    private List<User> listUser = new ArrayList<User> ();
    private Vector colName = new Vector (), Data = new Vector ();
    
    public List<User> getListUser() {
        return listUser;
    }

    public void setListUser(List<User> listUser) {
        listUser = listUser;
    }
    
    public FormMngUser() {
        
        // Make table's conlumns
        colName.addElement("Mã nhân viên");
        colName.addElement("Password");
        colName.addElement("Tên nhân viên");
        colName.addElement("CMND");
        colName.addElement("Ngày sinh");
        colName.addElement("Số điện thoại");
        colName.addElement("Địa chỉ");
        colName.addElement("Ngày vào làm");
        colName.addElement("Tình trạng");
        colName.addElement("Doanh thu");
        colName.addElement("Chức vụ");
        colName.addElement("Ảnh đại diện");
      //  tbUser.setModel(new DefaultTableModel(Data, colName));
        
       // TableColumnModel model = tbUser.getColumnModel();
      //  model.getColumn(0).setPreferredWidth(10);
      //  ShowAllObjectsToTable();
        
        initComponents();
        setLocationRelativeTo(null);
    }        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnAddRow = new javax.swing.JButton();
        btnDelRow = new javax.swing.JButton();
        btnEditRow = new javax.swing.JButton();
        cbbUserRoles = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUser = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        txtUserPass = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUserCMND = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPhoneNum = new javax.swing.JTextField();
        txtUserAddress = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnSaveUser = new javax.swing.JButton();
        btnCancle = new javax.swing.JButton();
        btnViewPass = new javax.swing.JButton();
        txtDOB = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÍ NHÂN VIÊN");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnAddRow.setBackground(new java.awt.Color(51, 255, 0));
        btnAddRow.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddRow.setText("Thêm");
        btnAddRow.setToolTipText("");
        btnAddRow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRowActionPerformed(evt);
            }
        });

        btnDelRow.setBackground(new java.awt.Color(255, 51, 0));
        btnDelRow.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDelRow.setText("Xóa");
        btnDelRow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelRow.setEnabled(false);
        btnDelRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelRowActionPerformed(evt);
            }
        });

        btnEditRow.setBackground(new java.awt.Color(255, 255, 0));
        btnEditRow.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnEditRow.setText("Sửa");
        btnEditRow.setEnabled(false);
        btnEditRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditRowActionPerformed(evt);
            }
        });

        cbbUserRoles.setModel(new javax.swing.DefaultComboBoxModel(BusinessLogic.AppPublic.userRoles.values()));
        cbbUserRoles.setName("123"); // NOI18N
        cbbUserRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbUserRolesActionPerformed(evt);
            }
        });

        tbUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbUser.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUser);
        tbUser.getAccessibleContext().setAccessibleName("");
        tbUser.getAccessibleContext().setAccessibleDescription("");

        jLabel4.setText("Mã NV:");

        jLabel5.setText("Password:");

        jLabel7.setText("Tên NV:");

        txtUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserIDActionPerformed(evt);
            }
        });

        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });

        txtUserPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserPassActionPerformed(evt);
            }
        });

        jLabel3.setText("CMND:");

        txtUserCMND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserCMNDActionPerformed(evt);
            }
        });
        txtUserCMND.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserCMNDKeyTyped(evt);
            }
        });

        jLabel8.setText("Ngày Sinh:");

        jLabel10.setText("Địa Chỉ:");

        jLabel11.setText("Chức vụ:");

        txtPhoneNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumActionPerformed(evt);
            }
        });
        txtPhoneNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneNumKeyTyped(evt);
            }
        });

        txtUserAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserAddressActionPerformed(evt);
            }
        });

        jLabel12.setText("Số ĐT:");

        btnSaveUser.setBackground(new java.awt.Color(102, 255, 0));
        btnSaveUser.setText("Lưu");
        btnSaveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveUserActionPerformed(evt);
            }
        });

        btnCancle.setBackground(new java.awt.Color(255, 51, 0));
        btnCancle.setText("Hủy");
        btnCancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancleActionPerformed(evt);
            }
        });

        btnViewPass.setBackground(new java.awt.Color(255, 0, 255));
        btnViewPass.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnViewPass.setText("Xem MK");
        btnViewPass.setEnabled(false);
        btnViewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(970, 970, 970)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAddRow, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnDelRow, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnEditRow, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnViewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUserPass, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addComponent(txtUserCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(96, 96, 96))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(79, 79, 79)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(cbbUserRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtUserAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSaveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66))))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUserPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUserAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel11))))))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSaveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUserCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbbUserRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddRow, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(btnDelRow, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditRow, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void txtUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserIDActionPerformed

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void txtUserPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserPassActionPerformed

    private void txtUserCMNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserCMNDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserCMNDActionPerformed

    private void txtPhoneNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneNumActionPerformed

    private void txtUserAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserAddressActionPerformed

    private void btnAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRowActionPerformed
        this.btnCancle.setEnabled(true);
        this.btnSaveUser.setEnabled(true);
        this.txtDOB.setEnabled(true);
        this.txtPhoneNum.setEnabled(true);
        this.txtUserAddress.setEnabled(true);
        this.txtUserCMND.setEnabled(true);
    //    this.txtUserID.setEnabled(true);
        int nextID = this.listUser.size() + 1;
        this.txtUserID.setText(nextID < 10 ? "NV0"+nextID : "NV"+nextID);
        
        this.txtUserName.setEnabled(true);
        this.txtUserPass.setEnabled(true);
        this.cbbUserRoles.setEnabled(true);
        this.btnEditRow.setEnabled(false);
        this.btnDelRow.setEnabled(false);
    }//GEN-LAST:event_btnAddRowActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.btnCancle.setEnabled(false);
        this.btnSaveUser.setEnabled(false);
        this.txtDOB.setEnabled(false);
        this.txtPhoneNum.setEnabled(false);
        this.txtUserAddress.setEnabled(false);
        this.txtUserCMND.setEnabled(false);
        this.txtUserID.setEnabled(false);
        this.txtUserName.setEnabled(false);
        this.txtUserPass.setEnabled(false);
        this.cbbUserRoles.setSelectedIndex(2); // role mac dinh la seller
        this.cbbUserRoles.setEnabled(false);
        
    }//GEN-LAST:event_formWindowOpened

    private void btnCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancleActionPerformed
         //clear textfield
        this.txtDOB.setDate(null);
        this.txtPhoneNum.setText("");
        this.txtUserAddress.setText("");
        this.txtUserCMND.setText("");
        this.txtUserID.setText("");
        this.txtUserName.setText("");
        this.txtUserPass.setText("");
        this.cbbUserRoles.setSelectedIndex(2); // khi hủy đưa usrRole ve mac dinh
        
        //disable button khi nhan HUY
        this.btnCancle.setEnabled(false);
        this.btnSaveUser.setEnabled(false);
        this.txtDOB.setEnabled(false);
        this.txtPhoneNum.setEnabled(false);
        this.txtUserAddress.setEnabled(false);
        this.txtUserCMND.setEnabled(false);
        this.txtUserID.setEnabled(false);
        this.txtUserName.setEnabled(false);
        this.txtUserPass.setEnabled(false);
        this.cbbUserRoles.setEnabled(false);
        this.btnEditRow.setEnabled(false);
        this.btnDelRow.setEnabled(false);
        this.btnAddRow.setEnabled(true);
        this.btnViewPass.setEnabled(false);
        tbUser.removeRowSelectionInterval(0, tbUser.getRowCount() - 1);
    }//GEN-LAST:event_btnCancleActionPerformed

    private void cbbUserRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbUserRolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbUserRolesActionPerformed

    private void btnEditRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditRowActionPerformed
        this.btnCancle.setEnabled(true);
        this.btnSaveUser.setEnabled(true);
        this.txtDOB.setEnabled(true);
        this.txtPhoneNum.setEnabled(true);
        this.txtUserAddress.setEnabled(true);
        this.txtUserCMND.setEnabled(true);
   //     this.txtUserID.setEnabled(true);
        this.txtUserName.setEnabled(true);
        this.txtUserPass.setEnabled(true);
        this.cbbUserRoles.setEnabled(true);
        this.btnAddRow.setEnabled(false);
        this.btnDelRow.setEnabled(false);
    }//GEN-LAST:event_btnEditRowActionPerformed

    private void txtPhoneNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNumKeyTyped
        // TODO add your handling code here:
        if(!BusinessLogic.InputChecker.getInstance().checkIsNumber(evt)) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Chỉ được nhập số","Lỗi",1); 
      }

    }//GEN-LAST:event_txtPhoneNumKeyTyped

    private void txtUserCMNDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserCMNDKeyTyped
        // TODO add your handling code here:
        if(!BusinessLogic.InputChecker.getInstance().checkIsNumber(evt)) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Chỉ được nhập số","Lỗi",1);          
             
      }
    }//GEN-LAST:event_txtUserCMNDKeyTyped

    private void btnSaveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveUserActionPerformed
        if (txtUserID.getText().isEmpty()   || 
            txtUserPass.getText().isEmpty() ||
            txtUserName.getText().isEmpty() ||
            txtUserCMND.getText().isEmpty() ||
            txtPhoneNum.getText().isEmpty() )
            
            
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống", "Lỗi", JOptionPane.ERROR);
        // Kiểm tra thêm 1 số field ở đây, ko cho field nào trống hết
        else{
            UserManagement.getInstance().addUser(txtUserID.getText(), txtUserPass.getText(), txtUserName.getText(), txtDOB.getDate(), txtUserCMND.getText(), txtPhoneNum.getText(), txtUserAddress.getText(),  AppPublic.userRoles.Seller);
            btnCancle.doClick();
            
            
            
          //  try {
//                User usr = new User (txtUserID.getText());
//                usr.setPassword(txtUserPass.getText());
//                usr.setName(txtUserName.getText());
//                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//           //     Date dob = formatter.parse(txtDOB.getText());
//           //     usr.setdBirth(dob);
//           //     Date d = txtDOB.getDate();
//
//                System.out.println(txtDOB.getDate().toString());
//                usr.setcID(txtUserCMND.getText());
//                usr.setPhoneNo(txtPhoneNum.getText());
//                usr.setAddress(txtUserAddress.getText());
//                usr.setRole(AppPublic.userRoles.valueOf(cbbUserRoles.getSelectedItem().toString()));
//                this.AddDataToDB(usr);
         //   } catch (ParseException ex) {
        //        JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ", ex.getLocalizedMessage(), JOptionPane.ERROR);
         //       ex.printStackTrace();
        //    }
        }
    }//GEN-LAST:event_btnSaveUserActionPerformed

    private void tbUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUserMouseClicked
        // TODO add your handling code here:
        int selectedRow = tbUser.getSelectedRow();
        if (selectedRow != -1) {
            txtUserID.setText(tbUser.getValueAt(selectedRow, 0).toString());
            txtUserPass.setText(tbUser.getValueAt(selectedRow, 1).toString());
            txtUserName.setText(tbUser.getValueAt(selectedRow, 2).toString());
            txtUserCMND.setText(tbUser.getValueAt(selectedRow, 3).toString());
       //     txtDOB.setText(tbUser.getValueAt(selectedRow, 4).toString());
            txtPhoneNum.setText(tbUser.getValueAt(selectedRow, 5).toString());
            txtUserAddress.setText(tbUser.getValueAt(selectedRow, 6).toString());
            cbbUserRoles.setSelectedItem(AppPublic.userRoles.valueOf(tbUser.getValueAt(selectedRow, 10).toString()));
            
            btnAddRow.setEnabled(false);
            btnDelRow.setEnabled(true);
            btnEditRow.setEnabled(true);
            btnCancle.setEnabled(true);
            btnViewPass.setEnabled(true);
            System.out.println("list has: " + listUser.size());
        }
    }//GEN-LAST:event_tbUserMouseClicked

    private void btnViewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPassActionPerformed
        // TODO add your handling code here:
       if(JOptionPane.showInputDialog(this, "Vui lòng nhập mật khẩu của bạn để xem mật khẩu của nhân viên: ").equals(AppPublic.frmLogin.getUser().getPassword())) {
           String userPass = UserManagement.getInstance().findUser(txtUserID.getText()).getPassword();
           txtUserPass.setText(userPass);
       } else
           JOptionPane.showMessageDialog(this, "Không phải Manager mà đòi xem pass à?", "ĐKMM", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnViewPassActionPerformed

    private void btnDelRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelRowActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên này?", "Xác nhận xóa nhân viên", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            this.DeleteDataFromDB();
       
    }//GEN-LAST:event_btnDelRowActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMngUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMngUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMngUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMngUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMngUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRow;
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnDelRow;
    private javax.swing.JButton btnEditRow;
    private javax.swing.JButton btnSaveUser;
    private javax.swing.JButton btnViewPass;
    private javax.swing.JComboBox<String> cbbUserRoles;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUser;
    private com.toedter.calendar.JDateChooser txtDOB;
    private javax.swing.JTextField txtPhoneNum;
    private javax.swing.JTextField txtUserAddress;
    private javax.swing.JTextField txtUserCMND;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtUserPass;
    // End of variables declaration//GEN-END:variables

    @Override
    public void ShowAnObjectToTable(PrimalObject obj) {
        User usr = (User) obj;
        
        Vector usrData = new Vector ();
        usrData.addElement(obj.getID());
        // encode the password
        usrData.addElement("********");
        
        usrData.addElement(usr.getName());
        usrData.addElement(usr.getcID());
        usrData.addElement(usr.getdBirth());
        usrData.addElement(usr.getPhoneNo());
        usrData.addElement(usr.getAddress());
        usrData.addElement(usr.getJoinDate());
        usrData.addElement(usr.getStatus());
        // Set revenue by currency
        usrData.addElement(MoneyFormatter.getInstance().Format(usr.getRevenue()));
        
        usrData.addElement(usr.getRole());
//            usrData.addElement(usr.GetImage());
        Data.add(usrData);
    }

    @Override
    public void ShowAllObjectsToTable() {
        System.out.println("ShowAllObjectsToTable");
        ClearTable();
        for (User usr : listUser) {
            ShowAnObjectToTable(usr);
            System.out.println(usr.getID());
        }
        tbUser.setModel(new DefaultTableModel(Data, colName));
    }

    @Override
    public void AddDataToDB(PrimalObject obj) {
       User usr = (User) obj;
    //   UserManagement.getInstance().addUser(usr);
       listUser.add(usr);
       ClearTable();
       //ShowAnObjectToTable(usr);
       ShowAllObjectsToTable();
       
       btnCancle.doClick();
    }

    @Override
    public void LoadDataFromDB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateDataToDB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteDataFromDB() {
        DefaultTableModel model = (DefaultTableModel) tbUser.getModel();
        int selectedRow = tbUser.getSelectedRow();
        UserManagement.getInstance().deleteUser(tbUser.getValueAt(selectedRow, 0).toString());
        model.removeRow(selectedRow);
        System.out.println("before delete: " + listUser.size());
        listUser.remove(selectedRow);
        System.out.println("After delete: " + listUser.size());
        this.btnCancle.doClick();
    }

    @Override
    public void Search(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ClearTable() {
        DefaultTableModel model = (DefaultTableModel) tbUser.getModel();
//        model.getDataVector().removeAllElements();
//        tbUser.repaint();
        tbUser.selectAll();
        int []row = tbUser.getSelectedRows();
        for(int i=0;i<row.length;i++){
          model.removeRow(row[i] - i);
        }
    }
}
