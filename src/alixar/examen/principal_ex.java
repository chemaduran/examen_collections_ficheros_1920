package alixar.examen;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class principal_ex {
  public static void main(String[] args) {
    //
    Medico m1 = new Medico("Tomás", "Toledano", 12345, "Macarena");
    Medico m2 = new Medico("Álvaro", "Arcelado", 98546, "Juan Ramón Jiménez");
    Medico m3 = new Medico("Carmen", "Zamora", 788456, "Virgen del Rocío");

    Paciente p1 = new Paciente("Jorge", 56, 67, true, m1, Cepa.L);
    Paciente p2 = new Paciente("Alberto", 57, 45, true, m1, Cepa.M);
    Paciente p3 = new Paciente("Andrés", 59, 66, true, m2, Cepa.N);
    Paciente p4 = new Paciente("Desirée", 54, 37, false, m2, Cepa.L);
    Paciente p5 = new Paciente("María", 23, 98, true, m2, Cepa.M);
    Paciente p6 = new Paciente("Teresa", 12, 89, false, m3, Cepa.N);
    Paciente p7 = new Paciente("Alejandro", 89, 76, true, m3, Cepa.L);
    Paciente p8 = new Paciente("David", 99, 55, true, m1, Cepa.M);
    Paciente p9 = new Paciente("Natalia", 11, 56, true, m1, Cepa.N);
    Paciente p10 = new Paciente("Celestino", 24, 102, true, m1, Cepa.L);

    Coronavirus covid19 = new Coronavirus("COVID-19", "Wuhan", new HashMap<Cepa, Set<Paciente>>());
    covid19.addPaciente(Cepa.L, p1);
    covid19.addPaciente(Cepa.M, p2);
    covid19.addPaciente(Cepa.N, p3);
    covid19.addPaciente(Cepa.L, p4);
    covid19.addPaciente(Cepa.M, p5);
    covid19.addPaciente(Cepa.N, p6);
    covid19.addPaciente(Cepa.L, p7);
    covid19.addPaciente(Cepa.M, p8);
    covid19.addPaciente(Cepa.N, p9);
    covid19.addPaciente(Cepa.L, p10);

    covid19.pacientesporEdad(Cepa.L);
    covid19.pacientesPorPeso(Cepa.M);

    covid19.pacientesDeUnDoctor(98546);
    covid19.darDeAltaPaciente(p3);
    covid19.guardarPacientes();
  }
}
