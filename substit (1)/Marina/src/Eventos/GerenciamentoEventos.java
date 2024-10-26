package Eventos;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoEventos {
    private List<Evento> eventos;
    private List<Local> locais;
    private List<Participante> participantes;

    public GerenciamentoEventos() {
        this.eventos = new ArrayList<>();
        this.locais = new ArrayList<>();
        this.participantes = new ArrayList<>();
    }

    public void cadastrarLocal(String nome, String endereco, int capacidadeMaxima) {
        Local local = new Local(nome, endereco, capacidadeMaxima);
        locais.add(local);
        System.out.println("Local cadastrado: " + nome);
    }

    public void cadastrarEvento(String nomeEvento, String dataHora, String nomeLocal) {
        Local local = buscarLocalPorNome(nomeLocal);
        if (local != null) {
            Evento evento = new Evento(nomeEvento, dataHora, local);
            eventos.add(evento);
            System.out.println("Evento cadastrado: " + nomeEvento);
        } else {
            System.out.println("Local não encontrado.");
        }
    }

    public void cadastrarParticipante(String nome, String cpf) {
        Participante participante = new Participante(nome, cpf);
        participantes.add(participante);
        System.out.println("Participante cadastrado: " + nome);
    }

    public void registrarParticipanteNoEvento(String cpfParticipante, String nomeEvento) {
        Participante participante = buscarParticipantePorCPF(cpfParticipante);
        Evento evento = buscarEventoPorNome(nomeEvento);

        if (participante != null && evento != null) {
            evento.registrarParticipante(participante);
        } else {
            System.out.println("Evento ou participante não encontrado.");
        }
    }

    public void gerarRelatorioEventos() {
        System.out.println("Relatório de Eventos:");
        for (Evento evento : eventos) {
            System.out.println("Evento: " + evento.getNome() + " - Data: " + evento.getDataHora());
            evento.listarParticipantes();
        }
    }

    private Local buscarLocalPorNome(String nome) {
        for (Local local : locais) {
            if (local.getNome().equalsIgnoreCase(nome)) {
                return local;
            }
        }
        return null;
    }

    private Participante buscarParticipantePorCPF(String cpf) {
        for (Participante participante : participantes) {
            if (participante.getCpf().equals(cpf)) {
                return participante;
            }
        }
        return null;
    }

    private Evento buscarEventoPorNome(String nome) {
        for (Evento evento : eventos) {
            if (evento.getNome().equalsIgnoreCase(nome)) {
                return evento;
            }
        }
        return null;
    }
}

