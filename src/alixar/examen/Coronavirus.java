package alixar.examen;

import java.io.*;
import java.util.*;

public class Coronavirus {
  private Map<Cepa, Set<Paciente>> infectados;
  private String nombre_virus;
  private String origen;

  public Coronavirus(String nombre_virus, String origen, Map<Cepa, Set<Paciente>> infectados) {
    this.infectados = infectados;
    this.nombre_virus = nombre_virus;
    this.origen = origen;
  }

  public void addPaciente(Cepa c, Paciente p) {
    if (infectados.containsKey(c)) {
      Set<Paciente> conjunto_pacientes = infectados.get(c);
      conjunto_pacientes.add(p);
      infectados.put(c, conjunto_pacientes);
    } else {
      Set<Paciente> conjunto_pacientes = new HashSet<Paciente>();
      conjunto_pacientes.add(p);
      infectados.put(c, conjunto_pacientes);
    }
  }

  public void darDeAltaPaciente(Paciente p) {
    for (Cepa c : infectados.keySet()) {
      Set<Paciente> conjunto_infectados = infectados.get(c);
      conjunto_infectados.remove(p);
    }
  }

  public void pacientesDeUnDoctor(int num_colegiado) {
    boolean encontrado = false;
    for (Cepa c : infectados.keySet()) {
      Set<Paciente> conjunto_infectados = infectados.get(c);
      for (Paciente p : conjunto_infectados) {
        if (p.getMedico().getNum_colegiado() == num_colegiado) {
          System.out.print(p);
          encontrado = true;
        }
      }
    }

    if (!encontrado) {
      System.out.println("Este médico/a no lleva ningún paciente");
    }
  }

  public void pacientesPorPeso(Cepa c) {
    Set<Paciente> conjunto_infectados =
        new TreeSet<Paciente>(
            new Comparator<Paciente>() {
              @Override
              public int compare(Paciente p1, Paciente p2) {
                return p1.getEdad() - p2.getEdad();
              }
            });
    conjunto_infectados.addAll(infectados.get(c));
    System.out.println(conjunto_infectados);
  }

  public void pacientesporEdad(Cepa c) {
    Set<Paciente> conjunto_infectados =
        new TreeSet<Paciente>(
            new Comparator<Paciente>() {
              @Override
              public int compare(Paciente p1, Paciente p2) {
                return p1.getPeso() - p2.getPeso();
              }
            });
    conjunto_infectados.addAll(infectados.get(c));
    System.out.println(conjunto_infectados);
  }

  public void cargarPacientes() {
    try (ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("pacientes.dat"))) {
      infectados = (Map<Cepa, Set<Paciente>>) fichero.readObject();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void guardarPacientes() {
    try (ObjectOutputStream fichero =
        new ObjectOutputStream(new FileOutputStream("pacientes.dat"))) {
      fichero.writeObject(infectados);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
