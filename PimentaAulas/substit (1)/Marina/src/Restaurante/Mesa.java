package Restaurante;

public class Mesa {
    private int numeroMesa;
    private boolean ocupada;
    private Pedido pedidoAtual;

    public Mesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.ocupada = false;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void abrirPedido() {
        if (!ocupada) {
            pedidoAtual = new Pedido(numeroMesa);
            ocupada = true;
            System.out.println("Pedido aberto para a mesa " + numeroMesa);
        } else {
            System.out.println("A mesa " + numeroMesa + " já está ocupada.");
        }
    }

    public void fecharPedido() {
        if (ocupada && pedidoAtual != null) {
            System.out.println("Total a pagar: R$" + pedidoAtual.calcularTotal());
            pedidoAtual.listarItens();
            ocupada = false;
            pedidoAtual = null;
            System.out.println("Pedido fechado para a mesa " + numeroMesa);
        } else {
            System.out.println("A mesa " + numeroMesa + " não possui um pedido aberto.");
        }
    }

    public Pedido getPedidoAtual() {
        return pedidoAtual;
    }
}

