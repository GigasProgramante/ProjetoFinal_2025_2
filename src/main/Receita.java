package main;

import java.time.LocalDate;
import java.util.ArrayList;

public class Receita {
    private int idReceita;
    private ArrayList<String> medicamentos;
    private LocalDate dataEmissao;
    Medico medico;

    public Receita(int idReceita, ArrayList<String> medicamentos, LocalDate dataEmissao, Medico medico) {
        this.idReceita = idReceita;
        this.medicamentos = medicamentos;
        this.dataEmissao = dataEmissao;
        this.medico = medico;
    }
    public void adicionarMedicamento(String medicamento){
        this.medicamentos.add(medicamento);
    }
    public void removerMedicamento(String medicamento){
        this.medicamentos.remove(medicamento);
    }
    public void exibirDetalhes() {
        System.out.println();
    }
}
