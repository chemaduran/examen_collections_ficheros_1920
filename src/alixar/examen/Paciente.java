package alixar.examen;

import java.io.Serializable;

public class Paciente implements Serializable {
  private String nombre;
  private int edad;
  private int peso;
  boolean vacunas;
  private Medico medico;
  private Cepa cepa;

  public int getEdad() {
    return edad;
  }

  public int getPeso() {
    return peso;
  }

  public Medico getMedico() {
    return medico;
  }

  public Paciente(String nombre, int edad, int peso, boolean vacunas, Medico medico, Cepa cepa) {
    this.nombre = nombre;
    this.edad = edad;
    this.peso = peso;
    this.vacunas = vacunas;
    this.medico = medico;
    this.cepa = cepa;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public String toString() {
    return "\nNombre: "
        + nombre
        + " Edad: "
        + edad
        + " Peso: "
        + peso
        + " Vacunas: "
        + vacunas
        + " Cepa: "
        + cepa
        + " | Medico: "
        + medico;
  }
}
