package Restaurante;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numeroPedido;
    private List<ItemDoPedido> itens;

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.itens = new ArrayList<>();
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void adicionarItem(ItemDoPedido item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemDoPedido item : itens) {
            total += item.calcularTotal();
        }
        return total;
    }

    public void listarItens() {
        System.out.println("Itens do Pedido " + numeroPedido + ":");
        for (ItemDoPedido item : itens) {
            System.out.println(item.getQuantidade() + " x " + item.getNome() + " - R$" + item.getPreco());
        }
    }
}
