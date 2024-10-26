package Clinica;

import java.util.ArrayList;
import java.util.List;

public class Medico {
    private String nome;
    private String crm;
    private List<Consulta> consultas;

    public Medico(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
        this.consultas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public boolean isDisponivel(String dataHora) {
        for (Consulta consulta : consultas) {
            if (consulta.getDataHora().equals(dataHora)) {
                return false; // Médico já tem consulta neste horário
            }
        }
        return true;
    }
}


