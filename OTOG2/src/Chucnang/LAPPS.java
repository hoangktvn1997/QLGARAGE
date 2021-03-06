/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chucnang;

import static Chucnang.TNXE.convertUtilDateToSqlDate;
import MenuConnect.Connect;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Administrator
 */
public class LAPPS extends javax.swing.JFrame {
    DefaultTableModel Y = new DefaultTableModel();
    

    /**
     * Creates new form LAPPS
     */
    public LAPPS() {
        initComponents();
        Load();
        LoadCB();
    }
public void Load(){
        try{
            Connect C = new Connect();
            Connection conn = C.getConnection();
            int number;
            Vector row, column = null;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from PHIEUSUACHUA");
            ResultSetMetaData metadata = rs.getMetaData();
            number = metadata.getColumnCount();
            for (int i = 1; i <= number;  i++){
                column.add(metadata.getColumnName(i));   
            }
            Y.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                for(int i=1;i<=number; i++){
                    row.addElement(rs.getString(i));
                }
                Y.addRow(row);
                jTablesc.setModel(Y);
            }
        }catch(Exception ex) {
            System.out.println(ex.toString());
        }
    jTablesc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(jTablesc.getSelectedRow()>=0){
                    jComboBoxbsx.setSelectedItem(jTablesc.getValueAt(jTablesc.getSelectedRow(),1)+ "");
                    int select = jTablesc.getSelectedRow();
                        java.util.Date datel = null;
                    try {
                      datel = new SimpleDateFormat("yyyy-MM-dd").parse((String) Y.getValueAt(select, 2));
                    } catch (ParseException ex) {
                        java.util.logging.Logger.getLogger(LAPPS.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        jDateChoosernl.setDate(datel);
                }
            }
        });
    }
public void LoadCB(){
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("select BSX from KHACHHANG");
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                jComboBoxbsx.addItem(rs.getString("BSX"));
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDateChoosernl = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxbsx = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablesc = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButtonthemm = new javax.swing.JButton();
        jButtonthoat = new javax.swing.JButton();
        jButtonxoa = new javax.swing.JButton();
        jButtonlapct = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setTitle("PHIẾU SỬA CHỬA");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(45, 60, 82));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jDateChoosernl, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 217, 50));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Ngày lập phiếu");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));

        jComboBoxbsx.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(jComboBoxbsx, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 230, 50));

        jTablesc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTablesc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablesc.setRowHeight(20);
        jScrollPane1.setViewportView(jTablesc);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 750, 230));

        jPanel3.setBackground(new java.awt.Color(25, 162, 141));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 910, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8_Calendar_48px.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));

        jPanel4.setBackground(new java.awt.Color(54, 71, 93));
        jPanel4.setToolTipText("");
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 220, 50));

        jPanel5.setBackground(new java.awt.Color(54, 71, 93));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Biển số xe");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8_Flat_Tire_48px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 170, 50));

        jPanel7.setBackground(new java.awt.Color(61, 79, 105));

        jPanel8.setBackground(new java.awt.Color(61, 79, 105));

        jButtonthemm.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButtonthemm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/Apply.png"))); // NOI18N
        jButtonthemm.setText("THÊM");
        jButtonthemm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonthemmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonthemm, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonthemm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jButtonthoat.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButtonthoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/Exit.png"))); // NOI18N
        jButtonthoat.setText("THOÁT");
        jButtonthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonthoatActionPerformed(evt);
            }
        });

        jButtonxoa.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButtonxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/Delete.png"))); // NOI18N
        jButtonxoa.setText("XÓA");
        jButtonxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonxoaActionPerformed(evt);
            }
        });

        jButtonlapct.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButtonlapct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/Application.png"))); // NOI18N
        jButtonlapct.setText("LẬP CT");
        jButtonlapct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonlapctActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButtonthoat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButtonlapct, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonxoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButtonlapct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonthoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 670, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 910, 550));

        jPanel2.setBackground(new java.awt.Color(29, 187, 156));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8_Car_Theft_48px.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LẬP PHIẾU SỬA CHỬA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(253, 253, 253)
                .addComponent(jLabel1)
                .addContainerGap(288, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonthemmActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonthemmActionPerformed
        // TODO add your handling code here: THEM PHIEU SUA
        try{
        Connect C = new Connect();
        Connection conn = C.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into dbo.PHIEUSUACHUA values(0,?,?)");
        ps.setString(1, jComboBoxbsx.getSelectedItem().toString());
        ps.setDate(2, convertUtilDateToSqlDate(jDateChoosernl.getDate()));
        int chk = ps.executeUpdate();
        if (chk  >0){
            JOptionPane.showMessageDialog(this, "Đã thêm thành công");
        }        
            Y.setRowCount(0);
            Load();
    }catch(Exception ex){
        ex.getMessage();
        System.out.println(ex.toString());
        JOptionPane.showMessageDialog(this, "Thêm thất bại ! Bạn hãy nhập kỹ thông tin");
        }
    }//GEN-LAST:event_jButtonthemmActionPerformed

    private void jButtonxoaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonxoaActionPerformed
        // TODO add your handling code here: XÓA PHIEU
        try {
            Connect c = new Connect();
            Connection conn = c.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete dbo.PHIEUSUACHUA where MASC=?");
            ps.setString(1,jTablesc.getValueAt(jTablesc.getSelectedRow(),0).toString());
            if(JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa không ?","Xác nhận",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
                ps.executeUpdate();
                Y.setRowCount(0);
                Load();
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(this, "Xóa thất bại !");
        }
    }//GEN-LAST:event_jButtonxoaActionPerformed

    private void jButtonthoatActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonthoatActionPerformed
        // TODO add your handling code here: THOÁT PHIẾU THOÁT
        if(JOptionPane.showConfirmDialog(this,"Xác Nhận Thoát ?","Đồng Ý",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ 
        this.setVisible(false);
        }
    }//GEN-LAST:event_jButtonthoatActionPerformed

    private void jButtonlapctActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonlapctActionPerformed
        // TODO add your handling code here: chuyển phiếu lập chi tiết
        LAPPHIEUSC n = new LAPPHIEUSC();
        n.setVisible(true);
    }//GEN-LAST:event_jButtonlapctActionPerformed

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
            java.util.logging.Logger.getLogger(LAPPS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LAPPS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LAPPS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LAPPS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LAPPS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonlapct;
    private javax.swing.JButton jButtonthemm;
    private javax.swing.JButton jButtonthoat;
    private javax.swing.JButton jButtonxoa;
    private javax.swing.JComboBox<String> jComboBoxbsx;
    private com.toedter.calendar.JDateChooser jDateChoosernl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablesc;
    // End of variables declaration//GEN-END:variables
}
