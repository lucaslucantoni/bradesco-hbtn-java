import java.util.List;

public class Consulta {
    public static List<Produto> obterLivrosDoPedido(Pedido pedidoV1) {
        return pedidoV1.getProdutos().stream()
                .filter(produtoV1 -> produtoV1.getCategoria().equals(CategoriaProduto.LIVRO))
                .toList();
    }
}