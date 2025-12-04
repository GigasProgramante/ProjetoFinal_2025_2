// Consulta.java
package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Consulta {

    private Paciente paciente;
    private Medico medico;
    private LocalDate data;
    private LocalTime hora;
    private ArrayList<String> sintomas;
    private String nomeMedicoDigitado;
    private StatusConsulta status;

    public Consulta(Paciente paciente,
                    LocalDate data,
                    LocalTime hora,
                    ArrayList<String> sintomas,
                    String nomeMedicoDigitado) {
        this.paciente = paciente;
        this.data = data;
        this.hora = hora;
        this.sintomas = sintomas;
        this.nomeMedicoDigitado = nomeMedicoDigitado;
        this.status = StatusConsulta.AGENDADA;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public ArrayList<String> getSintomas() {
        return sintomas;
    }

    public String getNomeMedicoDigitado() {
        return nomeMedicoDigitado;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public String exibirInfo() {
        return "Consulta de " + paciente.getNome() +
                " em " + data + " às " + hora +
                " | Médico: " + (medico != null ? medico.getNome() : nomeMedicoDigitado) +
                " | Status: " + status;
    }
}
