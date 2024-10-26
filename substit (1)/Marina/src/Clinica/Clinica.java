package Clinica;

import java.util.ArrayList;
import java.util.List;

public class Clinica {
    private String nome;
    private String endereco;
    private List<Paciente> pacientes;
    private List<Medico> medicos;

    public Clinica(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void adicionarMedico(Medico medico) {
        medicos.add(medico);
    }

    public Paciente buscarPacientePorCPF(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    public Medico buscarMedicoPorCRM(String crm) {
        for (Medico medico : medicos) {
            if (medico.getCrm().equals(crm)) {
                return medico;
            }
        }
        return null;
    }

    public void agendarConsulta(String cpfPaciente, String crmMedico, String dataHora) {
        Paciente paciente = buscarPacientePorCPF(cpfPaciente);
        Medico medico = buscarMedicoPorCRM(crmMedico);

        if (paciente != null && medico != null && medico.isDisponivel(dataHora)) {
            Consulta consulta = new Consulta(paciente, medico, dataHora);
            paciente.adicionarConsulta(consulta);
            medico.adicionarConsulta(consulta);
            System.out.println("Consulta agendada para " + dataHora);
        } else {
            System.out.println("Não foi possível agendar a consulta. Verifique os dados.");
        }
    }

    public void gerarRelatorioConsultas() {
        System.out.println("Relatório de Consultas:");
        for (Paciente paciente : pacientes) {
            System.out.println("Paciente: " + paciente.getNome());
            paciente.listarConsultas();
        }
    }
}