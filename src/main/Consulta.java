package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Consulta {
    private final int Idconsulta;
    private StatusConsulta statusConsulta;
    private Medico medico;
    private Paciente paciente;
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
    private ArrayList<String> sintomas;


    public Consulta(int idconsulta, StatusConsulta statusConsulta, Medico medico, Paciente paciente, LocalDate dataConsulta, LocalTime horaConsulta, ArrayList<String> sintomas) {
        this.Idconsulta = idconsulta;
        this.statusConsulta = statusConsulta;
        this.medico = medico;
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
        return medico;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public LocalDate getDataConsulta() {
        return dataConsulta;
    }
    public LocalTime getHoraConsulta() {
        return horaConsulta;
    }
    public ArrayList<String> getSintomas() {
        return sintomas;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "Idconsulta=" + this.Idconsulta +
                ", medico=" + this.medico +
                ", paciente=" + this.paciente +
                ", dataConsulta=" + this.dataConsulta +
                ", horaConsulta=" + this.horaConsulta +
                ", status da consulta=" + this.statusConsulta;
    }
}

