import java.util.*;Pessoa

public class Program {
    public static void main(String[] args) {
        Pessoa Pessoa1 = new Pessoa(1, "John Bannins", "Desenvolvedor", 23, 3200);
        Pessoa Pessoa2 = new Pessoa(2, "Derry Collier", "Desenvolvedor", 45, 8600);
        Pessoa Pessoa3 = new Pessoa(3, "Mikey Berg", "Product Owner", 51, 11350);
        Pessoa Pessoa4 = new Pessoa(4, "Diana Hayes", "Product Owner", 33, 7400);
        Pessoa Pessoa5 = new Pessoa(5, "Ellen Costa", "Product Owner", 51, 12500);
        Pessoa Pessoa6 = new Pessoa(6, "Jane Doe", "Analista QA", 42, 5200);
        Pessoa Pessoa7 = new Pessoa(7, "Haseeb Roche", "Analista QA", 21, 3200);
        Pessoa Pessoa8 = new Pessoa(8, "Jadene Everett", "Analista QA", 39, 4860);
        Pessoa Pessoa9 = new Pessoa(9, "Andrei Melendez", "Analista QA", 42, 5330);
        Pessoa Pessoa10 = new Pessoa(10, "Branden Irwin", "Analista QA", 21, 2800);

        List<Pessoa> todasPessoas = List.of(Pessoa1, Pessoa2, Pessoa3, Pessoa4, Pessoa5,
                Pessoa6, Pessoa7, Pessoa8, Pessoa9, Pessoa10);

        Map<String, List<Pessoa>> pessoasPorCargo1 = ConsultaPessoas0.obterPessoasPorCargo(todasPessoas);
        Map<String, List<Pessoa>> pessoasPorCargo2 = ConsultaPessoas0.obterPessoasPorCargo(
                List.of(Pessoa1, Pessoa4, Pessoa10)
        );
        Map<String, List<Pessoa>> pessoasPorCargo3 = ConsultaPessoas0.obterPessoasPorCargo(
                List.of(Pessoa4, Pessoa9)
        );

        System.out.println(pessoasPorCargo1);
        System.out.println();
        System.out.println(pessoasPorCargo2);
        System.out.println();
        System.out.println(pessoasPorCargo3);
    }
}