package Eventos;

import java.util.ArrayList;
import java.util.List;

public class Participante {
    private String nome;
    private String cpf;
    private List<Evento> eventos;

    public Participante(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.eventos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento encontrado para " + nome);
        } else {
            for (Evento evento : eventos) {
                System.out.println("Evento: " + evento.getNome() + " em " + evento.getDataHora());
            }
        }
    }
}

