package Restaurante;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoRestaurante {
    private List<Mesa> mesas;
    private List<Pedido> pedidosFechados;

    public GerenciamentoRestaurante(int numeroDeMesas) {
        this.mesas = new ArrayList<>();
        this.pedidosFechados = new ArrayList<>();
        for (int i = 1; i <= numeroDeMesas; i++) {
            mesas.add(new Mesa(i));
        }
    }

    public Mesa buscarMesa(int numeroMesa) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumeroMesa() == numeroMesa) {
                return mesa;
            }
        }
        return null;
    }

    public void abrirPedidoMesa(int numeroMesa) {
        Mesa mesa = buscarMesa(numeroMesa);
        if (mesa != null) {
            mesa.abrirPedido();
        } else {
            System.out.println("Mesa não encontrada.");
        }
    }

    public void adicionarItemPedido(int numeroMesa, String nomeItem, int quantidade, double preco) {
        Mesa mesa = buscarMesa(numeroMesa);
        if (mesa != null && mesa.isOcupada()) {
            mesa.getPedidoAtual().adicionarItem(new ItemDoPedido(nomeItem, quantidade, preco));
            System.out.println("Item adicionado ao pedido da mesa " + numeroMesa);
        } else {
            System.out.println("Pedido não aberto para a mesa " + numeroMesa);
        }
    }

    public void fecharPedidoMesa(int numeroMesa) {
        Mesa mesa = buscarMesa(numeroMesa);
        if (mesa != null && mesa.isOcupada()) {
            mesa.fecharPedido();
            pedidosFechados.add(mesa.getPedidoAtual());
        } else {
            System.out.println("A mesa " + numeroMesa + " não possui um pedido para ser fechado.");
        }
    }

    public void gerarRelatorioVendas() {
        System.out.println("Relatório de Vendas:");
        double totalVendas = 0;
        for (Pedido pedido : pedidosFechados) {
            System.out.println("Pedido " + pedido.getNumeroPedido() + ": R$" + pedido.calcularTotal());
            totalVendas += pedido.calcularTotal();
        }
        System.out.println("Total das Vendas: R$" + totalVendas);
    }
}

