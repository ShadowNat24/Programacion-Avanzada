package com.grupo2ma.service;

import com.grupo2ma.model.Docente;
import com.grupo2ma.model.Licencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    private final List<Docente> docentes = new ArrayList<>();
    private final List<Licencia> licencias = new ArrayList<>();

    public synchronized void agregarDocente(Docente d) {
        for (Docente ex : docentes) {
            if (ex.getNombre().equalsIgnoreCase(d.getNombre())) {
                throw new IllegalArgumentException("Docente ya registrado: " + d.getNombre());
            }
        }
        docentes.add(d);
    }

    public synchronized List<Docente> obtenerDocentes() {
        return new ArrayList<>(docentes);
    }

    private boolean overlap(LocalDate aStart, LocalDate aEnd, LocalDate bStart, LocalDate bEnd) {
        return !(aEnd.isBefore(bStart) || aStart.isAfter(bEnd));
    }

    public synchronized void registrarLicencia(Licencia l) {
        licencias.stream().filter((ex) -> (ex.getDocente().getNombre().equalsIgnoreCase(l.getDocente().getNombre())
                && overlap(ex.getFechaInicio(), ex.getFechaFin(), l.getFechaInicio(), l.getFechaFin()))).forEachOrdered((_item) -> {
                    throw new IllegalArgumentException("Ya existe una licencia del docente en ese período.");
        });
        licencias.add(l);
    }

    public synchronized List<Licencia> obtenerLicencias() {
        return new ArrayList<>(licencias);
    }

    public synchronized void eliminarLicencia(Licencia l) {
        licencias.remove(l);
    }
}
