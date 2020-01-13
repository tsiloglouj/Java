import java.sql.*;

public class RSMD_ex3 extends javax.swing.JFrame {

    public RSMD_ex3() {
        initComponents();
        myconnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        BExecute = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SQL EDITOR");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        BExecute.setText("Execute");
        BExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExecuteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BExecute)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BExecute)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExecuteActionPerformed
        String selectString = jTextArea1.getText();
        try {
            rs = statement.executeQuery(selectString);
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            for (int i = 1; i<= numberOfColumns; i++){
                String columnName = rsmd.getColumnLabel(i);
		System.out.print(columnName+ " "); 
            }
            System.out.println("");
            String columnvalue;
            while (rs.next()) {
                for (int i = 1; i<= numberOfColumns; i++) {
                    columnvalue = rs.getString(i);
                    System.out.print(columnvalue + " ");
                }
                System.out.println("");
            }
        } catch(SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex != null) {
		System.out.println("Message: " + ex.getMessage());
		ex = ex.getNextException();
            }
        } 
    }//GEN-LAST:event_BExecuteActionPerformed

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
            java.util.logging.Logger.getLogger(RSMD_ex1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RSMD_ex1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RSMD_ex1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RSMD_ex1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RSMD_ex3().setVisible(true);
            }
        });
    }
    
    void myconnection () {
        try { 
             Class.forName (driverClassName);
        } catch (ClassNotFoundException ex) { }
        try {    
            dbConnection = DriverManager.getConnection (url, username, passwd);
            statement    = dbConnection.createStatement();
        } catch(SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex != null) {
		System.out.println("Message: " + ex.getMessage());
		ex = ex.getNextException();
            }
        }
    }
   
    static String     driverClassName = "oracle.jdbc.OracleDriver" ;
    static String     url = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs" ;
    static Connection dbConnection = null;
    static String     username = "jordan";
    static String     passwd = "12345";
    static Statement  statement  = null;
    static ResultSet rs	= null;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BExecute;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
