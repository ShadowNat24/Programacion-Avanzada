package com.grupo2ma;

import com.grupo2ma.model.Docente;
import com.grupo2ma.service.GestorDatos;
import com.grupo2ma.ui.VentanaConsultaPublica;
import com.grupo2ma.ui.VentanaGestionLicencias;
import com.grupo2ma.ui.VentanaRegistroDocente;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        GestorDatos gestor = new GestorDatos();

        try {
            gestor.agregarDocente(new Docente("Natasha Ramos", "Mañana", "1A"));
            gestor.agregarDocente(new Docente("Mateo Cedrés", "Tarde", "2B"));
            gestor.agregarDocente(new Docente("Marcelo Marlon", "Noche", "3C"));
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaConsultaPublica v3 = new VentanaConsultaPublica(gestor);
                v3.setVisible(true);
                
                VentanaGestionLicencias v2 = new VentanaGestionLicencias(gestor); // le pasamos v3 para refrescar
                v2.setVisible(true);
                
                VentanaRegistroDocente v1 = new VentanaRegistroDocente(gestor);
                v1.setVisible(true);
            }
        });
    }
}

