package alixar.examen;

import java.io.Serializable;

public class Medico implements Serializable {
  private String nombre;
  private String apellidos;
  private int num_colegiado;
  private String hospital;

  public int getNum_colegiado() {
    return num_colegiado;
  }

  public Medico(String nombre, String apellidos, int num_colegiado, String hospital) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.num_colegiado = num_colegiado;
    this.hospital = hospital;
  }

  @Override
  public boolean equals(Object obj) {
    return ((Medico) obj).num_colegiado == this.num_colegiado;
  }

  @Override
  public String toString() {
    return "Nombre: "
        + nombre
        + " Apellidos: "
        + apellidos
        + " Num colegiado: "
        + num_colegiado
        + " Hospital: "
        + hospital;
  }
}
