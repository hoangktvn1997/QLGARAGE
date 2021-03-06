/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chucnang;

import MenuConnect.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class LAPHOADON extends javax.swing.JFrame {
    DefaultTableModel Y = new DefaultTableModel();

    /**
     * Creates new form LAPHOADON
     */
    public LAPHOADON() {
        initComponents();
        LoadCB();
        LoadData();
    }
    public void LoadCB(){
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("select MASC from PHIEUSUACHUA");
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                jComboBoxbsx.addItem(rs.getString("MASC"));
                String tien = "";
                String sql =  "{call VK4 (?,?)}" ;
                CallableStatement cstmt=conn.prepareCall(sql);
                cstmt.setString(1, jComboBoxbsx.getSelectedItem().toString());
                cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
                cstmt.execute();
                int s=cstmt.getInt(2);
                System.out.println(s);
                tien = String.valueOf(s);
                jTextFieldttien.setText(tien);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    public void LoadData(){
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    public static java.sql.Date converUtilDateToSqlDate(java.util.Date date){
        if (date != null){
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        }
        return null;
    }
    public static java.util.Date convertSqlDateToUtilDate(java.sql.Date date){
        if(date != null){
            java.util.Date sqlDate = new java.util.Date(date.getTime());
            return sqlDate;
        }
        return null;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldht = new javax.swing.JTextField();
        jDateChoosernt = new com.toedter.calendar.JDateChooser();
        jTextFielddt = new javax.swing.JTextField();
        jTextFieldttien = new javax.swing.JTextField();
        jComboBoxbsx = new javax.swing.JComboBox<String>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButtonstt = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButtonthutien = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setTitle("HÓA ĐƠN");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(45, 61, 78));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã Sửa");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, 29));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ngày Sửa");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, 40));

        jTextFieldht.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldht, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 250, 50));
        jPanel1.add(jDateChoosernt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 250, 50));

        jTextFielddt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(jTextFielddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 250, 50));

        jTextFieldttien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldttien, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 250, 50));

        jComboBoxbsx.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBoxbsx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxbsxMouseClicked(evt);
            }
        });
        jComboBoxbsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxbsxActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxbsx, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 250, 50));

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8_Barcode_Scanner_48px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8_Wheel_48px_3.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, 50));

        jPanel3.setBackground(new java.awt.Color(54, 71, 93));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Biển Số Xe");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 150, 50));

        jPanel4.setBackground(new java.awt.Color(54, 71, 93));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, 50));

        jPanel5.setBackground(new java.awt.Color(54, 71, 93));

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8_Date_To_40px_3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, 50));

        jPanel6.setBackground(new java.awt.Color(54, 71, 93));

        jLabel5.setBackground(new java.awt.Color(54, 71, 93));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ngày Thu");

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8_Today_48px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 150, -1));

        jPanel7.setBackground(new java.awt.Color(54, 71, 93));

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8_Money_Bag_40px.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tổng Tiền");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, -1, 50));

        jPanel8.setBackground(new java.awt.Color(29, 187, 156));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 630, 30));

        jPanel9.setBackground(new java.awt.Color(29, 187, 156));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("LẬP HÓA ĐƠN");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel8)
                .addContainerGap(214, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 70));

        jButtonstt.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButtonstt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/Print.png"))); // NOI18N
        jButtonstt.setText("IN HÓA ĐƠN");
        jButtonstt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsttActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonstt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 170, 67));

        jPanel10.setBackground(new java.awt.Color(54, 71, 93));

        jButtonthutien.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButtonthutien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/Apply.png"))); // NOI18N
        jButtonthutien.setText("THU TIỀN");
        jButtonthutien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonthutienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButtonthutien, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButtonthutien, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 420, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonthutienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonthutienActionPerformed
        // TODO add your handling code here: Hoàn thành hóa đơn
    try{
        Connect a = new Connect();
        Connection conn = a.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into HOADON values(0,?,?,?,?)");            
            ps.setString(1, jTextFieldht.getText()); 
            ps.setString(2, jComboBoxbsx.getSelectedItem().toString());
            ps.setDate(3, converUtilDateToSqlDate(jDateChoosernt.getDate()));
            ps.setString(4, jTextFieldttien.getText());
           int chk = ps.executeUpdate();           
            if(chk >0){
                JOptionPane.showMessageDialog(this, "Lập Hóa Đơn Thành Công");       
            }
            conn.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Lập hóa đơn Thất Bại! Xin Hãy Kiểm Tra Lại","Lỗi",1);
            System.out.println(ex.toString());
        }  
    }//GEN-LAST:event_jButtonthutienActionPerformed

    private void jComboBoxbsxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxbsxMouseClicked
        // TODO add your handling code here:
        jTextFieldht.setEditable(false);
        jTextFielddt.setEditable(false);
        jTextFieldttien.setEditable(false);
    }//GEN-LAST:event_jComboBoxbsxMouseClicked

    private void jComboBoxbsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxbsxActionPerformed
        // TODO add your handling code here: load lại ten kh va sdt
        try {
    Connect c = new Connect();
        Connection conn = c.getConnection();
        PreparedStatement p = conn.prepareStatement("select * from PHIEUSUACHUA");
        ResultSet rs = p.executeQuery();
        String Tien = "";
            String sql =  "{call Vk4 (?,?)}" ;
            CallableStatement cstmt=conn.prepareCall(sql);
            cstmt.setString(1, jComboBoxbsx.getSelectedItem().toString());
            cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
            cstmt.execute();
            int s=cstmt.getInt(2);
            System.out.println(s);
            Tien = String.valueOf(s);
            jTextFieldttien.setText(Tien);
 //           ps.setInt(4,Integer.parseInt(jTextFieldttien.getText()) );
        while(rs.next())
        {
            if(jComboBoxbsx.getSelectedItem().toString().equalsIgnoreCase(rs.getString("MASC"))){    
                jTextFieldht.setText(rs.getString("BSX"));
                jTextFielddt.setText(rs.getString("NGAYSUACHUA"));
            }}
            }catch (SQLException ex){
                Logger.getLogger(LAPHOADON.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jComboBoxbsxActionPerformed

    private void jButtonsttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsttActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Đã in hóa đơn !");
    }//GEN-LAST:event_jButtonsttActionPerformed

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
            java.util.logging.Logger.getLogger(LAPHOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LAPHOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LAPHOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LAPHOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LAPHOADON().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonstt;
    private javax.swing.JButton jButtonthutien;
    private javax.swing.JComboBox<String> jComboBoxbsx;
    private com.toedter.calendar.JDateChooser jDateChoosernt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextFielddt;
    private javax.swing.JTextField jTextFieldht;
    private javax.swing.JTextField jTextFieldttien;
    // End of variables declaration//GEN-END:variables
}
