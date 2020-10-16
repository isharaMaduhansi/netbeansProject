
package intf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import cords.DBconnect;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class mainframe extends javax.swing.JFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    public mainframe() {
        
        initComponents();
         conn=DBconnect.connect();
        tableload();
    }

    public void tableload(){
    
        try{
        
        String a="SELECT sid AS ID,sname AS Name,sage AS Age,sgrade AS Grade FROM student1";
        pst=conn.prepareStatement(a);
        rs=pst.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
        
        
        }
        
    }
      
    public void tabledata(){
     
        int r=table.getSelectedRow();
        
        String id=table.getValueAt(r,0).toString();
        String name= table.getValueAt(r, 1).toString();
        String age=table.getValueAt(r, 2).toString();
        String grade=table.getValueAt(r, 3).toString();
        
        idbox.setText(id);
        stnametxt.setText(name);
        agetxt.setText(age);
        gradecmb.setSelectedItem(grade);
        
    }
    
    public void search(){
    
     String srch=searchtxt.getText();
    
     try{
     
     String s="SELECT * FROM student1 WHERE sname LIKE '"+srch+"%'";
     pst=conn.prepareStatement(s);
     rs=pst.executeQuery();
     table.setModel(DbUtils.resultSetToTableModel(rs));
     
     }catch(Exception e){
     JOptionPane.showMessageDialog(null, e);
     
     
     }
    
    
    }
    
    public void clear(){
    
        searchtxt.setText("");
        idbox.setText("");
        stnametxt.setText("");
        agetxt.setText("");
        gradecmb.setSelectedIndex(0);
        tableload();
    
    
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        searchtxt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        stnametxt = new javax.swing.JTextField();
        agetxt = new javax.swing.JTextField();
        gradecmb = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        idbox = new javax.swing.JLabel();
        insertbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchtxtKeyReleased(evt);
            }
        });
        jPanel3.add(searchtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 270, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 290, 60));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student Name");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Age");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Grade");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        stnametxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(stnametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 160, 30));

        agetxt.setToolTipText("Enter age");
        agetxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        agetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agetxtActionPerformed(evt);
            }
        });
        jPanel4.add(agetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 160, 30));

        gradecmb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gradecmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));
        gradecmb.setToolTipText("Select grade");
        gradecmb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(gradecmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 150, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Student Id");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 30));

        idbox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 50, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 290, 220));

        insertbtn.setBackground(new java.awt.Color(153, 153, 153));
        insertbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertbtn.setText("Insert");
        insertbtn.setToolTipText("Enter name");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        jPanel2.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 80, 30));

        deletebtn.setBackground(new java.awt.Color(153, 153, 153));
        deletebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel2.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 80, 30));

        updatebtn.setBackground(new java.awt.Color(153, 153, 153));
        updatebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel2.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 80, 30));

        clearbtn.setBackground(new java.awt.Color(153, 153, 153));
        clearbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        jPanel2.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 80, 30));

        exitbtn.setBackground(new java.awt.Color(153, 153, 153));
        exitbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exitbtn.setText("Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        jPanel2.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 80, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 540));

        table.setBackground(new java.awt.Color(204, 204, 204));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Student Name", "Age", "Grade"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, 470));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Delete Table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 540));

        setSize(new java.awt.Dimension(822, 574));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
       clear();        
        
    }//GEN-LAST:event_clearbtnActionPerformed

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
       
        String name;
        int age,grade;
        
        name=stnametxt.getText();
        age=Integer.parseInt(agetxt.getText());
       grade=Integer.parseInt(gradecmb.getSelectedItem().toString());
        //grade=(int)gradecmb.getSelectedItem();
        
        try{
           String sql="INSERT INTO student1(sname,sage,sgrade) VALUES ('"+name+"','"+age+"','"+grade+"')";
           pst=conn.prepareStatement(sql); 
           pst.execute();
             
        
        }catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
        }
          
         tableload();
         clear();
        
        
    }//GEN-LAST:event_insertbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
     
        int id=Integer.parseInt(idbox.getText());
        String name;
        int age,grade;
        
        name=stnametxt.getText();
        age=Integer.parseInt(agetxt.getText());
       grade=Integer.parseInt(gradecmb.getSelectedItem().toString());
        
        try{
        
            String a="UPDATE student1 SET sname='"+name+"',sage='"+age+"',sgrade='"+grade+"' WHERE sid='"+id+"'";
            pst=conn.prepareStatement(a);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            
            
        }catch(Exception e){
        
             JOptionPane.showMessageDialog(null, "Can't Updated");
        
        }
        tableload();
        
    }//GEN-LAST:event_updatebtnActionPerformed

    private void agetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agetxtActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        
        tabledata();
    }//GEN-LAST:event_tableMouseClicked

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
       
        tabledata();
    }//GEN-LAST:event_tableKeyReleased

    private void searchtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchtxtKeyReleased
      search();
    }//GEN-LAST:event_searchtxtKeyReleased

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
       
        int chk =JOptionPane.showConfirmDialog(null,"Do you want to delete ??");
        
        if(chk==0){
           
            String id=idbox.getText();
            
            try{
            String a="DELETE FROM student1 WHERE sid='"+id+"'";
            pst=conn.prepareStatement(a);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Succesfully");
            
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(null,"Can not delete.Try again");
        }
            tableload();
            
        }
        clear();
        
    }//GEN-LAST:event_deletebtnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int chk=JOptionPane.showConfirmDialog(null,"Do you want to delete table ??");
        
        if(chk==0){
        try{
        
            String a="DELETE FROM student1";
            pst=conn.prepareStatement(a);
            pst.execute();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Can not deleted");
        
        }
        tableload();
        clear();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agetxt;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JComboBox gradecmb;
    private javax.swing.JLabel idbox;
    private javax.swing.JButton insertbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchtxt;
    private javax.swing.JTextField stnametxt;
    private javax.swing.JTable table;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
