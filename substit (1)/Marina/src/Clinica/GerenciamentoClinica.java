package Clinica;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoClinica {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Consulta> consultas;

    public GerenciamentoClinica() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println("Paciente adicionado: " + paciente.getNome());
    }

    public void adicionarMedico(Medico medico) {
        medicos.add(medico);
        System.out.println("Medico adicionado: " + medico.getNome());
    }

    public void agendarConsulta(String cpfPaciente, String crmMedico, String dataHora) {
        Paciente paciente = buscarPacientePorCpf(cpfPaciente);
        Medico medico = buscarMedicoPorCrm(crmMedico);

        if (paciente == null || medico == null) {
            System.out.println("Não foi possível agendar a consulta. Paciente ou médico não encontrado.");
            return;
        }

        if (!medico.isDisponivel(dataHora)) {
            System.out.println("Médico não disponível nesse horário.");
            return;
        }

        Consulta consulta = new Consulta(paciente, medico, dataHora);
        consultas.add(consulta);
        System.out.println("Consulta agendada: " + consulta);
        medico.adicionarConsulta(consulta); // Registrar a consulta no médico
    }
    public Paciente buscarPacientePorCpf(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        System.out.println("Paciente não encontrado.");
        return null; // Retorna null se o paciente não for encontrado
    }

    public Medico buscarMedicoPorCrm(String crm) {
        for (Medico medico : medicos) {
            if (medico.getCrm().equals(crm)) {
                return medico;
            }
        }
        System.out.println("Médico não encontrado.");
        return null; // Retorna null se o médico não for encontrado
    }

    public List<Paciente> buscarPacientes() {
        return pacientes;
    }

    public List<Consulta> relatorioConsultas() {
        return consultas;
    }
}

