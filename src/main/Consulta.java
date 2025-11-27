package main;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
    private int Idconsulta;
    private Medico medico;
    private Paciente paciente;
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;

    public Consulta(int idconsulta, Medico medico, Paciente paciente, LocalDate dataConsulta, LocalTime horaConsulta) {
        this.Idconsulta = idconsulta;
        this.medico = medico;
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
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

    @Override
    public String toString() {
        return "Consulta{" +
                "Idconsulta=" + Idconsulta +
                ", medico=" + medico +
                ", paciente=" + paciente +
                ", dataConsulta=" + dataConsulta +
                ", horaConsulta=" + horaConsulta +
                '}';
    }
}

