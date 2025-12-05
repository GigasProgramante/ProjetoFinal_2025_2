// Consulta.java
package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Consulta {

    private int Idconsulta;
    private Paciente paciente;
    private Medico medico;
    private StatusConsulta statusConsulta;
    private ArrayList<String> sintomas= new ArrayList<>();

    public Consulta(Paciente paciente, LocalDate dataConsulta, LocalTime horaConsulta, ArrayList<String> sintomas) {
        Random rd = new Random();
        this.Idconsulta = rd.nextInt(100000);
        this.statusConsulta = StatusConsulta.AGENDADA;
        this.sintomas = sintomas;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public int getIdconsulta() {
        return Idconsulta;
    }

    public void listarSintomas() {
        System.out.println("- Sintomas -");
        for(String s: this.sintomas) {
            System.out.println(s);
        }
    }
}