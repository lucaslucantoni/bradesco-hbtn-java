import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        Produto produtoOld1 = new Produto("Cafe Chocolate Trufado Baggio",
                21.99, 250, 120, TiposProduto.COZINHA);

        Produto produtoOld2 = new Produto("Leite Condensado Moca",
                6.29, 395, 200, TiposProduto.COZINHA);

        Produto produtoOld3 = new Produto("Carro Vortex",
                799.90, 1560, 5, TiposProduto.BRINQUEDO);

        Produto produtoOld4 = new Produto("Smart TV LED 32 HD LG",
                1452.55, 6300, 7, TiposProduto.ELETRONICO);

        Produto produtoOld5 = new Produto("Nintendo Switch",
                2990.00, 1700, 12, TiposProduto.ELETRONICO);

        List<Produto> produtoOlds = Arrays.asList(
                produtoOld1, produtoOld2, produtoOld3, produtoOld4, produtoOld5);

        List<Produto> produtosPrecoMaiorQue100 = ConsultaProdutos.filtrar(produtoOlds,
                p -> p.getPreco() > 100);

        List<Produto> produtosPesoMenorOuIgual1600 = ConsultaProdutos.filtrar(produtoOlds,
                p -> p.getPeso() <= 1600);

        List<Produto> produtosCozinha = ConsultaProdutos.filtrar(produtoOlds,
                p -> p.getTipo() == TiposProduto.COZINHA);

        List<Produto> produtosBaixoEstoque = ConsultaProdutos.filtrar(produtoOlds,
                p -> p.getQuantidadeEmEstoque() <= 10);

        System.out.println(produtosPrecoMaiorQue100);
        System.out.println(produtosPesoMenorOuIgual1600);
        System.out.println(produtosCozinha);
        System.out.println(produtosBaixoEstoque);
    }
}