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
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
    private ArrayList<String> sintomas;
    private String nomeMedicoDigitado;
    private StatusConsulta statusConsulta;

    public Consulta(Paciente paciente, LocalDate dataConsulta, LocalTime horaConsulta, ArrayList<String> sintomas) {
        Random rd = new Random();
        this.Idconsulta = rd.nextInt(100000);
        this.statusConsulta = StatusConsulta.AGENDADA;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}