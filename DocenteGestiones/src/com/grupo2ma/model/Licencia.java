package com.grupo2ma.model;

import java.time.LocalDate;

public class Licencia {
    private Docente docente;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String tipo;

    public Licencia(Docente docente, LocalDate fechaInicio, LocalDate fechaFin, String tipo) {
        if (fechaFin.isBefore(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio.");
        }
        this.docente = docente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipo = tipo;
    }

    public Docente getDocente() { return docente; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return docente.getNombre() + " | " + fechaInicio + " -> " + fechaFin + " | " + tipo;
    }
}
