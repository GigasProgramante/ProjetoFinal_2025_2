// Receita.java
package main;

import java.time.LocalDate;
import java.util.ArrayList;

public class Receita {

    private int idReceita;
    private ArrayList<String> medicamentos;
    private LocalDate dataEmissao;
    private Medico medico;

    public Receita(int idReceita, ArrayList<String> medicamentos, LocalDate dataEmissao, Medico medico) {
        this.idReceita = idReceita;
        this.medicamentos = medicamentos;
        this.dataEmissao = dataEmissao;
        this.medico = medico;
    }

    // ERA: public void exibirInfo() { ... }
    public String exibirInfo() {
        return "Receita #" + idReceita +
                " | Data: " + dataEmissao +
                " | Médico: " + medico.getNome() +
                " | Medicamentos: " + medicamentos;
    }
}
