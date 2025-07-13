package pedido_livraria;

public class Pedido {

    private double percentualDesconto;
    private ItemPedido[] items;

    public Pedido(double percentualDesconto, ItemPedido[] items) {
        this.percentualDesconto = percentualDesconto;
        this.items = items;
    }

    public double calcularTotal() {
        return 0;
    }

}
