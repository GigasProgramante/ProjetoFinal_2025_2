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



    public Medico getMedico () {
        return this.medico;
    }
    public Paciente getPaciente () {
        return this.paciente;
    }
    public LocalDate getDataConsulta () {
        return this.dataConsulta;
    }
    public LocalTime getHoraConsulta () {
        return this.horaConsulta;
    }
    public ArrayList<String> getSintomas () {
        return this.sintomas;
    }
     public int getIdconsulta () {
        return Idconsulta;
    }
    public void setMedico (Medico medico){
        this.medico = medico;
    }

    public String exibirDetalhes () {
        return "Consulta" +
                " | Idconsulta= " + this.Idconsulta +
                " | medico= " + this.medico +
                " | paciente= " + this.paciente +
                " | dataConsulta= " + this.dataConsulta +
                " | horaConsulta= " + this.horaConsulta +
                " | statusConsulta da consulta= " + this.statusConsulta;
    }

    public String getNomeMedicoDigitado () {
        return nomeMedicoDigitado;
    }

    public StatusConsulta getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(StatusConsulta statusConsulta){
        this.statusConsulta = statusConsulta;
    }

    public String exibirInfo () {
        return "Consulta de " + paciente.getNome() +
                " em " + dataConsulta + " às " + horaConsulta +
                " | Médico: " + (medico != null ? medico.getNome() : nomeMedicoDigitado) +
                " | Status: " + statusConsulta;
    }
}