package com.grupo2ma.model;

public class Docente {
    private String nombre;
    private String turno;
    private String grupo;

    public Docente(String nombre, String turno, String grupo) {
        this.nombre = nombre;
        this.turno = turno;
        this.grupo = grupo;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public String getGrupo() { return grupo; }
    public void setGrupo(String grupo) { this.grupo = grupo; }

    @Override
    public String toString() {
        return nombre + " (" + turno + " - " + grupo + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Docente)) return false;
        Docente d = (Docente) o;
        return nombre != null && nombre.equalsIgnoreCase(d.nombre);
    }

    @Override
    public int hashCode() {
        return nombre == null ? 0 : nombre.toLowerCase().hashCode();
    }
}
