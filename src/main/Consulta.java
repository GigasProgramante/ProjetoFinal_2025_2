package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Consulta {
    private final int Idconsulta;
    private StatusConsulta statusConsulta;
    private Medico medico;
    private Paciente paciente;
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
    private ArrayList<String> sintomas;


    public Consulta(Paciente paciente, LocalDate dataConsulta, LocalTime horaConsulta, ArrayList<String> sintomas) {
        Random rd = new Random(100000);
        this.Idconsulta = rd.nextInt();
        this.statusConsulta = StatusConsulta.AGENDADA;
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.sintomas = sintomas;
    }
    public void remarcarConsulta(LocalDate novaData, LocalTime novaHora){
        this.dataConsulta = novaData;
        this.horaConsulta = novaHora;
    }
    public void cancelarConsulta(int idConsulta){
        this.statusConsulta = StatusConsulta.CANCELADA;
    }

    public Medico getMedico() {
        return this.medico;
    }
    public Paciente getPaciente() {
        return this.paciente;
    }
    public LocalDate getDataConsulta() {
        return this.dataConsulta;
    }
    public LocalTime getHoraConsulta() {
        return this.horaConsulta;
    }
    public ArrayList<String> getSintomas() {
        return this.sintomas;
    }

    public int getIdconsulta() {
        return Idconsulta;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String exibirDetalhes() {
        return "Consulta" +
                " | Idconsulta= " + this.Idconsulta +
                " | medico= " + this.medico +
                " | paciente= " + this.paciente +
                " | dataConsulta= " + this.dataConsulta +
                " | horaConsulta= " + this.horaConsulta +
                " | status da consulta= " + this.statusConsulta;
    }
}

