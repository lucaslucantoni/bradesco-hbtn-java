package pedido_livraria;

public class Pedido {

    private double percentualDesconto;
    private ItemPedido[] items;

    public Pedido(double percentualDesconto, ItemPedido[] items) {
        this.percentualDesconto = percentualDesconto;
        this.items = items;
    }

    public double calcularTotal() {

        double total = 0;
        for (ItemPedido itemPedido : this.items) {
            double grossValue = itemPedido.getProduto().obterPrecoLiquido() * itemPedido.getQuantidade();
            total += grossValue - (grossValue * percentualDesconto / 100);
        }
        return total;
    }

}
