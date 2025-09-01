import java.lang.reflect.Method;
import java.util.*;
import java.util.function.*;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        Produto produtoOld11 = new Produto("Cafe Chocolate Trufado Baggio",
                21.99, 250, 120, TiposProduto.COZINHA);

        Produto produtoOld12 = new Produto("Leite Condensado Moca",
                6.29, 395, 200, TiposProduto.COZINHA);

        Produto produtoOld13 = new Produto("Carro Vortex",
                799.90, 1560, 5, TiposProduto.BRINQUEDO);

        Produto produtoOld14 = new Produto("Smart TV LED 32 HD LG",
                1452.55, 6300, 7, TiposProduto.ELETRONICO);

        Produto produtoOld15 = new Produto("Nintendo Switch",
                2990.00, 1700, 12, TiposProduto.ELETRONICO);

        List<Produto> produtoOld1s = Arrays.asList(
                produtoOld11, produtoOld12, produtoOld13, produtoOld14, produtoOld15);

        List<Produto> produtosPrecoMaiorQue100 = ConsultaProdutos.filtrar(produtoOld1s,
                p -> p.getPreco() > 100);

        List<Produto> produtosPesoMenorOuIgual1600 = ConsultaProdutos.filtrar(produtoOld1s,
                p -> p.getPeso() <= 1600);

        List<Produto> produtosCozinha = ConsultaProdutos.filtrar(produtoOld1s,
                p -> p.getTipo() == TiposProduto.COZINHA);

        List<Produto> produtosBaixoEstoque = ConsultaProdutos.filtrar(produtoOld1s,
                p -> p.getQuantidadeEmEstoque() <= 10);

        try
        {
            Method method = ConsultaProdutos.class.getMethod("filtrar", List.class, Predicate.class);
            if (method != null) {
                System.out.println("Metodo encontrado");
            }
        } catch(NoSuchMethodException ex) {
            System.out.println("Metodo nao encontrado");
        }

        System.out.println(produtosPrecoMaiorQue100);
        System.out.println(produtosPesoMenorOuIgual1600);
        System.out.println(produtosCozinha);
        System.out.println(produtosBaixoEstoque);
    }
}