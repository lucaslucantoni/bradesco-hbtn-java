import java.util.Arrays;
import java.util.Locale;

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

    private double getTotalValue() {
        double sum = Arrays.stream(items)
                .mapToDouble(i -> i.getQuantidade() * i.getProduto().obterPrecoLiquido())
                .sum();
        return sum;
    }

    private double getDesconto(double soma) {
        return (soma * (percentualDesconto/100));
    }

    public void apresentarResumoPedido() {
        Locale.setDefault(new Locale("pt", "BR"));
        System.out.println("------- RESUMO PEDIDO -------");
        Arrays.
                stream(items)
                .forEach(i -> System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                        i.getProduto().getClass().getName().replace("produtos.",""),
                        i.getProduto().getTitulo(),
                        i.getProduto().obterPrecoLiquido(),
                        i.getQuantidade(),
                        i.getQuantidade() * i.getProduto().obterPrecoLiquido()));
        System.out.println("----------------------------");
        System.out.printf("DESCONTO: %.2f\n", getDesconto(getTotalValue()));
        System.out.printf("TOTAL PRODUTOS: %.2f\n", getTotalValue());
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f\n", calcularTotal());
        System.out.println("----------------------------");
    }

}
