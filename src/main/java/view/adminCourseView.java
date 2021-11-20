/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.adminCourseModel;
import controller.adminCourseController;
import java.awt.event.ActionEvent;

/**
 *
 * @author binurathiranjaya
 */
public class adminCourseView extends javax.swing.JFrame {

    adminCourseModel objModel;
    adminCourseController objController;

    //private String Uname;
    /**
     * Creates new form teacherCourseRukshan
     */
    public adminCourseView() {
        initComponents();
        objController = new adminCourseController();
        Connect();
        Student_Load();
        Combo_Load();
        Course_Load();
        // Course_Load();

    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;

//    public adminCourseView(String Uname) {
//        this.Uname=Uname;
//        id.setText(Uname);
//        System.out.println("dddddd"+Uname);
//    }
    public void Connect() {
        try {
            //        Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentIssuesManager", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(addCourseView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Course_Load() {
        int c;
        try {
            String uname = txtid.getText();
            pst = con.prepareStatement("SELECT id,uname,course from tcourse where uname=?;");
            pst.setString(1, uname);

            rs = pst.executeQuery();

            ResultSetMetaData rsd = (ResultSetMetaData) rs.getMetaData();
            c = rsd.getColumnCount();

            d = (DefaultTableModel) tblcou.getModel();
            d.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("uname"));
                    v2.add(rs.getString("course"));

                }
                d.addRow(v2);

            }
        } catch (SQLException ex) {
            Logger.getLogger(addCourseView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Combo_Load() {
        try {
            //String nic=txtno.getText();

            pst = con.prepareStatement("select distinct course from  course;");

            rs = pst.executeQuery();
            cmbcourse.removeAllItems();
            cmbcourse1.removeAllItems();

            while (rs.next()) {
                //JOptionPane.showMessageDialog(this, "INVALID NIC");
                cmbcourse.addItem(rs.getString("course"));
                cmbcourse1.addItem(rs.getString("course"));

            }

        } catch (SQLException ex) {
            System.out.println("Sql Erro");
        }
    }

    public void Student_Load() {
        int c;

        try {
            String sql = "select uname ,name from user where utype LIKE '%Student%';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsd = (ResultSetMetaData) rs.getMetaData();
            c = rsd.getColumnCount();

            d = (DefaultTableModel) tblstu.getModel();
            d.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int i = 1; i <= c; i++) {
                    // v2.add(rs.getString("id"));
                    v2.add(rs.getString("uname"));
                    v2.add(rs.getString("name"));

                }
                d.addRow(v2);

            }
        } catch (SQLException ex) {
            Logger.getLogger(adminCourseView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblstu = new javax.swing.JTable();
        btnadd = new javax.swing.JButton();
        btncclear = new javax.swing.JButton();
        btndel = new javax.swing.JButton();
        lblid = new javax.swing.JLabel();
        cmbcourse = new javax.swing.JComboBox<>();
        cmbcourse1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblcou = new javax.swing.JTable();
        txtid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        btnfind = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        txtcid = new javax.swing.JTextField();
        txtcsel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnclear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Course");

        jPanel1.setBackground(new java.awt.Color(90, 90, 90));

        tblstu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NIC"
            }
        ));
        tblstu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblstuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblstu);

        btnadd.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btncclear.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        btncclear.setText("Clear");
        btncclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncclearActionPerformed(evt);
            }
        });

        btndel.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        btndel.setText("Delete");
        btndel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelActionPerformed(evt);
            }
        });

        lblid.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblid.setText("ID");

        cmbcourse.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        cmbcourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbcourse1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        cmbcourse1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblcou.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NIC", "Course"
            }
        ));
        tblcou.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblcouMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblcou);

        txtid.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setText("Name");

        txtname.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N

        btnfind.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        btnfind.setText("Search");
        btnfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });

        btnback.setBackground(new java.awt.Color(255, 51, 51));
        btnback.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        txtcid.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N

        txtcsel.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel4.setText("Selected Course");

        btnclear.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel5.setText("Add Course");

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel6.setText("Course ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btndel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbcourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbcourse1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnadd)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(29, 170, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnfind)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnclear))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblid)
                                        .addComponent(jLabel1))
                                    .addGap(129, 129, 129)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                        .addComponent(txtname))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btncclear)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtcid, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtcsel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(75, 75, 75)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnback)
                .addGap(576, 576, 576))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnfind)
                            .addComponent(btnclear))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbcourse1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnadd)
                            .addComponent(jLabel5)
                            .addComponent(cmbcourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(btndel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtcsel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btncclear))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnback)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        
         txtid.setEnabled(true);
                     txtname.setEnabled(true);

            
            txtid.setText("");
            txtname.setText("");
                 //      txtsubject.setSelectedIndex(0);
            //jLabel5.setText("");
            txtid.requestFocus();
            d = (DefaultTableModel)tblcou.getModel();
            d.setRowCount(0);
    }//GEN-LAST:event_btnclearActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndeleteActionPerformed

    private void tblstuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblstuMouseClicked
        // TODO add your handling code here:

        d = (DefaultTableModel) tblstu.getModel();
        int selectIndex = tblstu.getSelectedRow();

        txtid.setText(d.getValueAt(selectIndex, 0).toString());
        txtname.setText(d.getValueAt(selectIndex, 1).toString());

        txtid.setEnabled(false);
        txtname.setEnabled(false);

    }//GEN-LAST:event_tblstuMouseClicked

    private void btncclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncclearActionPerformed
        // TODO add your handling code here:
         btnadd.setEnabled(true);
            txtcid.setText("");
            txtcsel.setText("");
                         txtcid.setEnabled(true);            
             txtcsel.setEnabled(true);            

            txtid.requestFocus();
            
    }//GEN-LAST:event_btncclearActionPerformed

    private void btndelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelActionPerformed
        // TODO add your handling code here:

        //String id =d.getValueAt(selectIndex, 0).toString();
        String uname = txtcid.getText();
        int id = Integer.parseInt(uname);

        boolean result = objController.deleteCourseToDB(id);
        
         if (result) {
                JOptionPane.showMessageDialog(rootPane, " Course has been removed from student", "Info", 1);
                txtcid.setText("");
                txtcsel.setText("");

                Course_Load();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error adding to db", "Error", 0);
                txtcid.setText("");
                txtcsel.setText("");

            }



    }//GEN-LAST:event_btndelActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        String course = cmbcourse.getSelectedItem().toString();
//        //For validation
        String course1 = cmbcourse1.getSelectedItem().toString();

        String uname = txtid.getText();
        System.out.println(course);

        System.out.println(course1);

        System.out.println(uname);
        if (course.equalsIgnoreCase(course1)) {
            objModel = objController.addCourse(uname, course);
            boolean result = objController.insertCourseToDB(objModel, uname);

            if (result) {
                JOptionPane.showMessageDialog(rootPane, " Course has been added to student Successfully", "Info", 1);
                cmbcourse.setSelectedIndex(0);
                cmbcourse1.setSelectedIndex(0);

                Course_Load();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error adding to db", "Error", 0);
                cmbcourse.setSelectedIndex(0);
                cmbcourse1.setSelectedIndex(0);

            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Incorrect Info, Please Check Again", "Error", 0);

        }

    }//GEN-LAST:event_btnaddActionPerformed

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
        // TODO add your handling code here:

        int c;
        String nic = txtid.getText();

        try {
            //String nic=txtno.getText();
            //String sql="select * from course where nic=?";
            pst = con.prepareStatement("select id,uname,course from tcourse where uname=? ");
            pst.setString(1, nic);
            //System.out.println("safsds"+nic);

            rs = pst.executeQuery();

            ResultSetMetaData rsd = (ResultSetMetaData) rs.getMetaData();
            c = rsd.getColumnCount();

            d = (DefaultTableModel) tblcou.getModel();
            d.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("id"));

                    // v2.add(rs.getString("nic"));
                    v2.add(rs.getString("uname"));
                    v2.add(rs.getString("course"));
                }
                d.addRow(v2);

            }
        } catch (SQLException ex) {
            Logger.getLogger(adminCourseView.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnfindActionPerformed

    private void tblcouMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcouMouseClicked
        // TODO add your handling code here:
        d = (DefaultTableModel) tblcou.getModel();
        int selectIndex = tblcou.getSelectedRow();

        txtcid.setText(d.getValueAt(selectIndex, 0).toString());
        txtcsel.setText(d.getValueAt(selectIndex, 2).toString());

        txtcid.setEnabled(false);
        txtcsel.setEnabled(false);
        btnadd.setEnabled(false);
    }//GEN-LAST:event_tblcouMouseClicked

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        adminMenuView AM=new adminMenuView();
        AM.setVisible(true);
        this.setVisible(false);
             
    }//GEN-LAST:event_btnbackActionPerformed
    //    }

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
            java.util.logging.Logger.getLogger(adminCourseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminCourseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminCourseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminCourseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminCourseView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btncclear;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndel;
    private javax.swing.JButton btnfind;
    private javax.swing.JComboBox<String> cmbcourse;
    private javax.swing.JComboBox<String> cmbcourse1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblid;
    private javax.swing.JTable tblcou;
    private javax.swing.JTable tblstu;
    private javax.swing.JTextField txtcid;
    private javax.swing.JTextField txtcsel;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
