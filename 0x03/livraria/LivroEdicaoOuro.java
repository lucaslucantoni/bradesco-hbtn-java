import exceptions.AutorInvalidoException;
import exceptions.LivroInvalidoException;

public class LivroEdicaoOuro extends Livro_ {
    public LivroEdicaoOuro(String titulo, String autor, double preco) throws AutorInvalidoException, LivroInvalidoException {
        super(titulo, autor, preco);
    }

    @Override
    public double getPreco() {
        double preco = super.getPreco();
        return preco + (preco * 0.3);
    }
}