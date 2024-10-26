package Eventos;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nome;
    private String dataHora;
    private Local local;
    private List<Participante> participantes;

    public Evento(String nome, String dataHora, Local local) {
        this.nome = nome;
        this.dataHora = dataHora;
        this.local = local;
        this.participantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getDataHora() {
        return dataHora;
    }

    public Local getLocal() {
        return local;
    }

    public boolean verificarLotacao() {
        return participantes.size() < local.getCapacidadeMaxima();
    }

    public void registrarParticipante(Participante participante) {
        if (verificarLotacao()) {
            participantes.add(participante);
            participante.adicionarEvento(this);
            System.out.println("Participante " + participante.getNome() + " registrado no evento " + nome);
        } else {
            System.out.println("O evento " + nome + " está lotado.");
        }
    }

    public void listarParticipantes() {
        if (participantes.isEmpty()) {
            System.out.println("Nenhum participante inscrito para o evento " + nome);
        } else {
            System.out.println("Lista de participantes do evento " + nome + ":");
            for (Participante participante : participantes) {
                System.out.println("Participante: " + participante.getNome());
            }
        }
    }
}

