/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ordenamientodatos;

/**
 *
 * @author dhzea
 */
public class FrmDocumentos extends javax.swing.JFrame {

    /**
     * Creates new form FrmDocumentos
     */
    public FrmDocumentos() {
        initComponents();
        
        String nombreArchivo = System.getProperty("user.dir")
                +"/src/datos/Datos.csv";
        
        
        Documento.obtenerDatosDesdeArchivo(nombreArchivo);
        Documento.mostrarDatos(tblDocumentos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnOrdenarBurbuja = new javax.swing.JButton();
        btnOrdenarRapido = new javax.swing.JButton();
        btnOrdenarInsercion = new javax.swing.JButton();
        txtTiempo = new javax.swing.JTextField();
        cmbCriterio = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDocumentos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btnOrdenarBurbuja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Ordenar.png"))); // NOI18N
        btnOrdenarBurbuja.setToolTipText("Ordenar Burbuja");
        btnOrdenarBurbuja.setFocusable(false);
        btnOrdenarBurbuja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOrdenarBurbuja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOrdenarBurbuja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarBurbujaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOrdenarBurbuja);

        btnOrdenarRapido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/OrdenarRapido.png"))); // NOI18N
        btnOrdenarRapido.setToolTipText("Ordenar Rapido");
        btnOrdenarRapido.setFocusable(false);
        btnOrdenarRapido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOrdenarRapido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOrdenarRapido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarRapidoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOrdenarRapido);

        btnOrdenarInsercion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/OrdenarInsercion.png"))); // NOI18N
        btnOrdenarInsercion.setToolTipText("Ordenar Insercion");
        btnOrdenarInsercion.setFocusable(false);
        btnOrdenarInsercion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOrdenarInsercion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOrdenarInsercion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarInsercionActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOrdenarInsercion);
        jToolBar1.add(txtTiempo);

        cmbCriterio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre Completo, Tipo de Documento", "Tipo de Documento, Nombre Completo", " " }));
        jToolBar1.add(cmbCriterio);

        tblDocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDocumentos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdenarBurbujaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarBurbujaActionPerformed
          if(cmbCriterio.getSelectedIndex()>=0){
              Util.iniciarCronometro();
               Documento.ordenarBurbujaRecursivo(0, cmbCriterio.getSelectedIndex());
               txtTiempo.setText(Util.getTextoTiempoCronometro());
               Documento.mostrarDatos(tblDocumentos);
          }
       
    }//GEN-LAST:event_btnOrdenarBurbujaActionPerformed

    private void btnOrdenarRapidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarRapidoActionPerformed
        if(cmbCriterio.getSelectedIndex()>=0){
              Util.iniciarCronometro();
               Documento.ordenarRapido(0, Documento.documentos.size()-1, cmbCriterio.getSelectedIndex());
               txtTiempo.setText(Util.getTextoTiempoCronometro());
               Documento.mostrarDatos(tblDocumentos);
        }
    }//GEN-LAST:event_btnOrdenarRapidoActionPerformed

    private void btnOrdenarInsercionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarInsercionActionPerformed
         if(cmbCriterio.getSelectedIndex() >= 0) {
        Util.iniciarCronometro();
        Documento.ordenarInsercion(cmbCriterio.getSelectedIndex());
        txtTiempo.setText(Util.getTextoTiempoCronometro());
        Documento.mostrarDatos(tblDocumentos);
         }
    }//GEN-LAST:event_btnOrdenarInsercionActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDocumentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOrdenarBurbuja;
    private javax.swing.JButton btnOrdenarInsercion;
    private javax.swing.JButton btnOrdenarRapido;
    private javax.swing.JComboBox cmbCriterio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblDocumentos;
    private javax.swing.JTextField txtTiempo;
    // End of variables declaration//GEN-END:variables
}