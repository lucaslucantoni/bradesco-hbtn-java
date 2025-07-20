import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class Estoque {
    private String fileName = "estoque.csv";
    private String root = System.getProperty("user.dir");
    //private String path = root + File.separator + "arquivos" + File.separator + "3" + File.separator + fileName;
    private String path = "/home/student_jail/student_repo/arquivos/3/estoque.csv";

    public Estoque(String fileName) {
        this.fileName = fileName;
    }

    private List<Produto> leitura() {
        List<String> leitura = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            leitura = reader.lines().toList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return convert(leitura);
        }
    }

    private List<Produto> convert(List<String> leitura) {
        List<Produto> produtos = new ArrayList<>();
        if (!leitura.isEmpty()) {
            produtos = new ArrayList<>(leitura.stream().map(l -> {
                String[] split = l.split(",");
                return new Produto(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]));
            }).toList());
        }
        return produtos;
    }

    private void  gravacao(List<Produto> produtos) {
        try {
            Formatter saida = new Formatter(path);
            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                if (i + 1 == produtos.size())
                    saida.format("%d,%s,%d,%.2f", produto.getId(), produto.getNome(), produto.getQuantidade(), produto.getPreco());
                saida.format("%d,%s,%d,%.2f\n", produto.getId(), produto.getNome(), produto.getQuantidade(), produto.getPreco());
            }
            saida.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private int gerarId(List<Produto> produtos) {
        int id = 1;
        return produtos.isEmpty() ? id : produtos.get(produtos.size() - 1).getId() + id;
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        if(quantidade <= 0)
            throw new IllegalArgumentException("Digite uma quantidade maior que zero");
        if (preco <= 0D)
            throw new IllegalArgumentException("Digite um preço válido para o produto");
        String format = String.format("%.2f", preco);
        actions("A", nome, quantidade, Double.valueOf(format));
    }

    public void excluirProduto(int idExcluir) {
        if (idExcluir <= 0)
            throw new IllegalArgumentException("Digite um id válido");
        actions("X", idExcluir);
    }

    public void exibirEstoque() {
        List<Produto> produtos = leitura();
        produtos.forEach(p -> System.out.println(p.toString()));
    }

    public void atualizarQuantidade(int idAtualizar, int novaQuantidade) {
        if(novaQuantidade <= 0)
            throw new IllegalArgumentException("Digite uma quantidade maior que zero");
        actions("U", idAtualizar, novaQuantidade);
    }

    private void actions(String op, Object... params) {
        List<Produto> produtos = leitura();
        switch (op) {
            case "A" ->  {
                int id = gerarId(produtos);
                if (produtos.stream().noneMatch(produto -> produto.getId() == id)) {
                    produtos.add(new Produto(id,
                        params[0].toString(),
                        Integer.parseInt(params[1].toString()),
                        Double.parseDouble(params[2].toString())));
                }
            }
            case "X" -> produtos.removeIf(produto ->  produto.getId() == Integer.parseInt(params[0].toString()));
            case "U" -> {
                int id = Integer.parseInt(params[0].toString());
                Produto produto = produtos.stream()
                        .filter(produto1 -> produto1.getId() == id)
                        .findFirst()
                        .orElse(new Produto(0, "nao_existe", 0, 0D));
                if (!produto.getNome().equals("nao_existe")) {
                    int index = produtos.indexOf(produto);
                    produto.setQuantidade(Integer.parseInt(params[1].toString()));
                    produtos.set(index, produto);
                }
            }
        }
        gravacao(produtos);
    }
}