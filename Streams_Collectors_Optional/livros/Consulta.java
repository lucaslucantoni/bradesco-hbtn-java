import java.util.List;

public class Consulta {
    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedidoV1.getProdutos().stream()
                .filter(produto -> produto.getCategoria().equals(CategoriaProduto.LIVRO))
                .toList();
    }
}