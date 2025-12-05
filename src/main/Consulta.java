// Consulta.java
package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Consulta {

    private int Idconsulta;
    private Paciente paciente;
    private LocalDate data;
    private LocalTime hora;
    private Medico medico;
    private StatusConsulta statusConsulta;
    private ArrayList<String> sintomas= new ArrayList<>();

    public Consulta(Paciente paciente, LocalDate dataConsulta, LocalTime horaConsulta, ArrayList<String> sintomas) {
        Random rd = new Random();
        this.Idconsulta = rd.nextInt(100000);
        this.data = dataConsulta;
        this.hora = horaConsulta;
        this.statusConsulta = StatusConsulta.AGENDADA;
        this.sintomas = sintomas;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public int getIdconsulta() {
        return Idconsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void listarSintomas() {
        System.out.println("- Sintomas -");
        for(String s: this.sintomas) {
            System.out.println(s);
        }
    }
}