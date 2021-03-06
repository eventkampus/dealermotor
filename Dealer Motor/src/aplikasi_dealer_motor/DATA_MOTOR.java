/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_dealer_motor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dewa Supera
 */
public class DATA_MOTOR extends javax.swing.JFrame {
    
    Connection conn;
    Statement stm;
    ResultSet rs;

    /**
     * Creates new form DATA_MOTOR
     */
    public DATA_MOTOR() {
        initComponents();
        tambahkan(false);
        tombolfungsi();
        tabel_motor();
    }
    
    public Connection setKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/db_dealer_motor","root","");
            stm=conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal :" +e);
        }
       return conn; 
    }
    
    private void tambahkan(boolean a){
        txkodemotor.setEnabled(a);
        txnamamotor.setEnabled(a);
        txjumlahmotor.setEnabled(a);
        txtglmasuk.setEnabled(a);
        txbataspenjualan.setEnabled(a);
    }
    
    private void tombolfungsi(){
        bttambah.setEnabled(true);
        btsimpan.setEnabled(false);
        btedit.setEnabled(false);
        bthapus.setEnabled(false);
    }
    
    private void bersih(){
        txkodemotor.setText("");
        txnamamotor.setText("");
        txjumlahmotor.setText("");
        txtglmasuk.setText("");
        txbataspenjualan.setText("");
    }
    
    private void kodemotor(){
        try {
            setKoneksi();
            String sql="select right (kodemotor,2)+1 from tb_motor ";
            ResultSet rs=stm.executeQuery(sql);
            if(rs.next()){
                rs.last();
                String no=rs.getString(1);
                while (no.length()<3){
                    no="0"+no;
                    txkodemotor.setText("DM"+no);}
                }
            else
            {
                txkodemotor.setText("DM001"); 
        }
        } catch (Exception e) 
        {
        }
 }
    
    private void simpan(){
        try{
            setKoneksi();
            String sql="insert into tb_motor values('"+txkodemotor.getText()
                    +"','"+txnamamotor.getText()
                    +"','"+txjumlahmotor.getText()
                    +"','"+txtglmasuk.getText()
                    +"','"+txbataspenjualan.getText() +"')";
            stm.executeUpdate(sql); 
            JOptionPane.showMessageDialog(null,"Simpan Data Berhasil");
            }
            catch (Exception e) {
        }
        tabel_motor();
    }
    
    private void edit(){
        try{
            setKoneksi();
            String sql="update tb_motor set namamotor='"+txnamamotor.getText()
                    +"',jumlahmotor='"+txjumlahmotor.getText()
                    +"',tglmasuk='"+txtglmasuk.getText()
                    +"',bataspenjualan='"+txbataspenjualan.getText()
                    +"' where kodemotor='"+txkodemotor.getText()+"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Edit Data Berhasil","",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch(Exception e){
        }
        tabel_motor();
        
    }
    
    private void hapus(){
        try{
            String sql="delete from tb_motor where kodemotor='"+ txkodemotor.getText() +"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil ");
            }
            catch (Exception e) {
            }
        tabel_motor();
    }

    public void tabel_motor(){
        Object header[]={"Kode Motor","Nama Motor","Jumlah Motor","Tgl Masuk","Batas Penjualan"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tabel_motor.setModel(data);
        setKoneksi();
        String sql="select*from tb_motor";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5};
                data.addRow(kolom);
            }
        } catch (Exception e) {
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txkodemotor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txnamamotor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txjumlahmotor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtglmasuk = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txbataspenjualan = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        bttambah = new javax.swing.JButton();
        btsimpan = new javax.swing.JButton();
        btedit = new javax.swing.JButton();
        bthapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_motor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setText("Kode Motor");

        jLabel2.setText("Nama Motor");

        jLabel3.setText("Jumlah Motor");

        jLabel4.setText("Tgl Masuk");

        jLabel5.setText("Batas Penjualan");

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        bttambah.setText("Tambah");
        bttambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttambahActionPerformed(evt);
            }
        });

        btsimpan.setText("Simpan");
        btsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsimpanActionPerformed(evt);
            }
        });

        btedit.setText("Edit");
        btedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteditActionPerformed(evt);
            }
        });

        bthapus.setText("Hapus");
        bthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(bttambah, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(btsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(btedit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bthapus)
                .addGap(72, 72, 72))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btedit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bthapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txkodemotor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txnamamotor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txjumlahmotor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtglmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txbataspenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(txkodemotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txnamamotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txjumlahmotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtglmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txbataspenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        tabel_motor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tabel_motor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_motorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_motor);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttambahActionPerformed
        // TODO add your handling code here:
        if(bttambah.getText().equalsIgnoreCase("Tambah")){
            bttambah.setText("Kembali");
            bersih();
            tambahkan(true);
            kodemotor();

            txkodemotor.setEnabled(true);
            bttambah.setEnabled(true);
            btsimpan.setEnabled(true);
            bthapus.setEnabled(false);
            btedit.setEnabled(false);
        } else{
            bttambah.setText("Tambah");
            bersih();
            tambahkan(false);
            tombolfungsi();
            tabel_motor();
        }
    }//GEN-LAST:event_bttambahActionPerformed

    private void btsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsimpanActionPerformed
        // TODO add your handling code here:
        if(txkodemotor.getText().isEmpty()
            ||txnamamotor.getText().isEmpty()
            ||txjumlahmotor.getText().isEmpty()
            ||txtglmasuk.getText().isEmpty()
            ||txbataspenjualan.getText().isEmpty()){

            JOptionPane.showMessageDialog(null, "Mohon Lengkapi Inputan Data!!!","",JOptionPane.INFORMATION_MESSAGE);
        } else{

            if(bttambah.getText().equalsIgnoreCase("REFRESH")){
                if(bttambah.getText().equalsIgnoreCase("REFRESH")){
                    simpan();
                } else{
                    JOptionPane.showMessageDialog(null, "SIMPAN DATA GAGAL, PERIKSA KEMBALI :( ","",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if(btedit.getText().equalsIgnoreCase("Batal")){
                if(btedit.getText().equalsIgnoreCase("Batal")){
                    edit();
                } else{
                    JOptionPane.showMessageDialog(null, "EDIT DATA GAGAL, PERIKSA KEMBALI :( ","",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            bersih();
            tambahkan(false);
            bttambah.setText("Tambah");
            btedit.setText("Edit");
            tombolfungsi();
        }
    }//GEN-LAST:event_btsimpanActionPerformed

    private void bteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteditActionPerformed
        // TODO add your handling code here:
        if(btedit.getText().equalsIgnoreCase("Edit")){
            btedit.setText("Batal");
            tambahkan(true);
            txkodemotor.setEnabled(false);
            bttambah.setEnabled(false);
            btsimpan.setEnabled(true);
            bthapus.setEnabled(false);
            btedit.setEnabled(true);
        } else{
            btedit.setText("Edit");
            bersih();
            tambahkan(false);
            tombolfungsi();

        }
    }//GEN-LAST:event_bteditActionPerformed

    private void bthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthapusActionPerformed
        // TODO add your handling code here:
        int pesan=JOptionPane.showConfirmDialog(null, "YAKIN DATA AKAN DIHAPUS ?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(pesan==JOptionPane.YES_OPTION){
            if(pesan==JOptionPane.YES_OPTION){
                hapus();
                bersih();
                tambahkan(false);
                tombolfungsi();
            } else{
                JOptionPane.showMessageDialog(null, "HAPUS DATA GAGAL :(");
            }

        }
    }//GEN-LAST:event_bthapusActionPerformed

    private void tabel_motorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_motorMouseClicked
        // TODO add your handling code here:
        int baris = tabel_motor.getSelectedRow();
        txkodemotor.setText(tabel_motor.getModel().getValueAt(baris, 0).toString());
        txnamamotor.setText(tabel_motor.getModel().getValueAt(baris, 1).toString());
        txjumlahmotor.setText(tabel_motor.getModel().getValueAt(baris, 2).toString());
        txtglmasuk.setText(tabel_motor.getModel().getValueAt(baris, 3).toString());
        txbataspenjualan.setText(tabel_motor.getModel().getValueAt(baris, 4).toString());
        bthapus.setEnabled(true);
        btedit.setEnabled(true);
    }//GEN-LAST:event_tabel_motorMouseClicked

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
            java.util.logging.Logger.getLogger(DATA_MOTOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DATA_MOTOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DATA_MOTOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DATA_MOTOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DATA_MOTOR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btedit;
    private javax.swing.JButton bthapus;
    private javax.swing.JButton btsimpan;
    private javax.swing.JButton bttambah;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_motor;
    private javax.swing.JTextField txbataspenjualan;
    private javax.swing.JTextField txjumlahmotor;
    private javax.swing.JTextField txkodemotor;
    private javax.swing.JTextField txnamamotor;
    private javax.swing.JTextField txtglmasuk;
    // End of variables declaration//GEN-END:variables

}