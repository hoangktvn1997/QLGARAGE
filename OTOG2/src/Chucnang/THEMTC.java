/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chucnang;
import MenuConnect.Connect;
    import java.awt.Dimension;
    import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
    import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class THEMTC extends javax.swing.JFrame {
    DefaultTableModel Y = new DefaultTableModel();

    /**
     * Creates new form THEMTC
     */
    public THEMTC() {
        initComponents();
        Load();
    }
public void Load(){
        try{
            Connect C = new Connect();
            Connection conn = C.getConnection();
            int number;
            Vector row, column = null;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from TIENCONG");
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
                jTabletc.setModel(Y);
            }
        }catch(Exception ex) {
            System.out.println(ex.toString());
        }
    jTabletc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(jTabletc.getSelectedRow()>=0){
                    //ten truong
                    jTextFieldtentc.setText(jTabletc.getValueAt(jTabletc.getSelectedRow(),1) + "");
                    jTextFieldtc.setText(jTabletc.getValueAt(jTabletc.getSelectedRow(),2) + "");
                }
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = jPanel1 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("src/IconImage/money.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel4 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabletc = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldtentc = new javax.swing.JTextField();
        jTextFieldtc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabeltt = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();

        setTitle("THÊM LOẠI TIỀN CÔNG");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(45, 61, 78, 78));
        setFocusable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel4.setBackground(new java.awt.Color(45, 61, 78));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(29, 187, 156));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("THÊM TIỀN CÔNG");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(395, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(345, 345, 345))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 60));

        jPanel3.setBackground(new java.awt.Color(61, 79, 105));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabletc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTabletc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTabletc.setRowHeight(20);
        jTabletc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabletcMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabletc);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 470, 490));

        jPanel8.setBackground(new java.awt.Color(54, 71, 93));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("BẢNG TIỀN CÔNG ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel6)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 50));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, 580));

        jPanel2.setBackground(new java.awt.Color(61, 79, 105));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldtentc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextFieldtentc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldtentcMouseClicked(evt);
            }
        });
        jTextFieldtentc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldtentcActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldtentc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 350, 40));

        jTextFieldtc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel2.add(jTextFieldtc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 350, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8_US_Dollar_40px.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8_US_Dollar_40px.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jPanel5.setBackground(new java.awt.Color(61, 79, 105));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TIỀN CÔNG");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 147, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOẠI TIỀN CÔNG");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 37, -1, -1));

        jPanel9.setBackground(new java.awt.Color(54, 71, 93));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 200, 40));

        jPanel11.setBackground(new java.awt.Color(54, 71, 93));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 250, 40));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 400, 250));

        jPanel6.setBackground(new java.awt.Color(54, 71, 93));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("THÔNG TIN");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel3)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 50));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Thông báo:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, 20));

        jLabeltt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabeltt.setForeground(new java.awt.Color(255, 0, 0));
        jLabeltt.setText(" ");
        jPanel2.add(jLabeltt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 120, 20));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 360));

        jPanel10.setBackground(new java.awt.Color(61, 79, 105));

        jPanel7.setBackground(new java.awt.Color(54, 71, 93));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/Delete.png"))); // NOI18N
        jButton3.setText("XÓA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/Apply.png"))); // NOI18N
        jButton1.setText("THÊM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/Exit.png"))); // NOI18N
        jButton4.setText("THOÁT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/Modify.png"))); // NOI18N
        jButton2.setText("SỬA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 440, 210));

        jPanel14.setBackground(new java.awt.Color(29, 187, 156));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1440, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 820, 1440, 40));

        jPanel12.setBackground(new java.awt.Color(29, 187, 156));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 710, 990, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldtentcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldtentcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldtentcActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here: THOÁT KHỎI THÊM TIỀN CÔNG
        if(JOptionPane.showConfirmDialog(this,"Xác Nhận Thoát ?","Đồng Ý",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
        this.setVisible(false);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here: XÓA TIỀN CÔNG
        try {
            Connect c = new Connect();
            Connection conn = c.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete dbo.TIENCONG where MATC=?");
            ps.setString(1,jTabletc.getValueAt(jTabletc.getSelectedRow(),0).toString());
            if(JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa không ?","Ðồng Ý",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                jLabeltt.setText("Xóa Thành Công");
            //    JOptionPane.showMessageDialog(this, "Đã xóa thành công !");
        {
            ps.executeUpdate();
            Y.setRowCount(0);
            Load();
        }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(this, "Xóa thất bại !");
            jLabeltt.setText("");
        }
        jTextFieldtentc.setText("");
        jTextFieldtc.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here: THEM TIỀN CÔNG
        try{
            Connect C = new Connect();
            Connection conn = C.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into dbo.TIENCONG values(0,?,?)");
            ps.setString(1, jTextFieldtentc.getText());
            ps.setString(2, jTextFieldtc.getText());
            int chk = ps.executeUpdate();
            if (chk  >0){
                jLabeltt.setText("Thêm Thành Công");
        //        JOptionPane.showMessageDialog(this, "Đã thêm thành công !");
            }
            Y.setRowCount(0);
            Load();
        }catch(Exception ex){
            ex.getMessage();
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(this, "Thêm thất bại ! Bạn hãy nhập chính xác thông phụ tùng");
            jLabeltt.setText("Thêm thất bại");
        }
        jTextFieldtentc.setText("");
        jTextFieldtc.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here: SỬA TIỀN CÔNG
        try{
            Connect c = new Connect();
            Connection conn = c.getConnection();
            int index =jTabletc.getSelectedRow();
            String value = jTabletc.getModel().getValueAt(index,0).toString();
            PreparedStatement ps = conn.prepareStatement("Update TIENCONG set TENTC=?, TC=? where MATC='"+value+"'");
            ps.setString(1, jTextFieldtentc.getText());
            ps.setString(2, jTextFieldtc.getText());
            int chk = ps.executeUpdate();
            if (chk  >0){
                jLabeltt.setText("Sửa Thành Công");                
        //        JOptionPane.showMessageDialog(this, "Đã sửa thành công !");
            }

            Y.setRowCount(0);
            Load();
        }catch(Exception ex){
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(this, "Sửa thất bại ! Hãy chỉnh sửa lại thông tin");
            jLabeltt.setText("Sửa thất bại");
            
        }
        jTextFieldtentc.setText("");
        jTextFieldtc.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTabletcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabletcMouseClicked
        // TODO add your handling code here:
        jLabeltt.setText("");
    }//GEN-LAST:event_jTabletcMouseClicked

    private void jTextFieldtentcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldtentcMouseClicked
        // TODO add your handling code here:
        jLabeltt.setText("");
    }//GEN-LAST:event_jTextFieldtentcMouseClicked

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
            java.util.logging.Logger.getLogger(THEMTC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(THEMTC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(THEMTC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(THEMTC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new THEMTC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabeltt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabletc;
    private javax.swing.JTextField jTextFieldtc;
    private javax.swing.JTextField jTextFieldtentc;
    // End of variables declaration//GEN-END:variables
}