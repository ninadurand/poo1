package Clinica;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nome;
    private String cpf;
    private List<Consulta> consultas;

    public Paciente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.consultas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void listarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta encontrada para " + nome);
        } else {
            for (Consulta consulta : consultas) {
                System.out.println("Consulta com Dr. " + consulta.getMedico().getNome() +
                                   " em " + consulta.getDataHora());
            }
        }
    }
}

