package com.grupo2ma.ui;

import com.grupo2ma.model.Docente;
import com.grupo2ma.model.Licencia;
import com.grupo2ma.service.GestorDatos;
import java.awt.HeadlessException;

import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class VentanaGestionLicencias extends JFrame {
    private JComboBox<Docente> comboDocente;
    private JSpinner spinnerInicio, spinnerFin;
    private JComboBox<String> comboTipo;
    private JButton btnRegistrar;
    private GestorDatos gestor;
    private VentanaConsultaPublica consultaPublica; // opcional para refrescar
    private JLabel lblDocente;
    private JLabel lblInicio;
    private JLabel lblFin;
    private JLabel jLabel4;
    private JLabel lblTipo;

    public VentanaGestionLicencias(GestorDatos gestor, VentanaConsultaPublica consultaPublica) {
        this.gestor = gestor;
        this.consultaPublica = consultaPublica;
        initComponents();
        cargarDocentes();
    }

    VentanaGestionLicencias() {
    }

    public VentanaGestionLicencias(GestorDatos gestor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    

    private void cargarDocentes() {
        comboDocente.removeAllItems();
        gestor.obtenerDocentes().forEach(comboDocente::addItem);
    }

    private void registrarLicencia() {
        try {
            Docente d = (Docente) comboDocente.getSelectedItem();
            if (d == null) {
                JOptionPane.showMessageDialog(this, "No hay docentes registrados.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Date di = (Date) spinnerInicio.getValue();
            Date df = (Date) spinnerFin.getValue();
            LocalDate inicio = di.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fin = df.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String tipo = (String) comboTipo.getSelectedItem();

            Licencia l = new Licencia(d, inicio, fin, tipo);
            gestor.registrarLicencia(l);
            JOptionPane.showMessageDialog(this, "Licencia registrada.", "OK", JOptionPane.INFORMATION_MESSAGE);

            // si se pasó una ventana de consulta pública, refreszarla:
            if (consultaPublica != null) {
                consultaPublica.refrescarTabla();
            }
        }  catch (HeadlessException ex) {
        }
       
    }      
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Inicio = new javax.swing.JSpinner();
        Fin = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        btnRegistrar2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboTipo2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Docente");

        Inicio.setModel(new javax.swing.SpinnerDateModel());

        Fin.setModel(new javax.swing.SpinnerDateModel());

        jLabel3.setText("Fecha inicio");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Docente 1", "Docente 2", "Docente 3", "Docente 4" }));

        btnRegistrar2.setText("Registrar");

        jLabel5.setText("Fecha fin");

        comboTipo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Médica", "Personal ", "Otro" }));

        jLabel2.setText("Tipo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(129, 129, 129)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(Fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(52, 52, 52))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRegistrar2)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(comboTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(comboTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnRegistrar2)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


/**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
  
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaGestionLicencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner Fin;
    private javax.swing.JSpinner Inicio;
    private javax.swing.JButton btnRegistrar2;
    private javax.swing.JComboBox<String> comboTipo2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}