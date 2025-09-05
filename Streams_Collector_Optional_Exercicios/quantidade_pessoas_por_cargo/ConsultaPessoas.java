import java.util.*;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static Map<String, List<Pessoa>> obterPessoasPorCargo(List<Pessoa> Pessoas) {
        return Pessoas.stream().collect(
                Collectors.groupingBy(Pessoa::getCargo)
        );
    }

    public static Map<String, List<Integer>> obterIdadePorCargo(List<Pessoa> Pessoas) {
        return Pessoas.stream().collect(
                Collectors.groupingBy(Pessoa::getCargo,
                        Collectors.mapping(Pessoa::getIdade, Collectors.toList()))
        );
    }

    public static Map<String, List<Pessoa>> obterPessoasPorCargoAcimaDe40anos(List<Pessoa> Pessoas) {
        return Pessoas.stream().collect(
                Collectors.groupingBy(Pessoa::getCargo,
                        Collectors.filtering(Pessoa32 -> Pessoa32.getIdade() > 40, Collectors.toList()))
        );
    }

    public static TreeMap<String, TreeSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> Pessoas) {
        return Pessoas.stream().collect(
                Collectors.groupingBy(
                        Pessoa::getCargo,
                        () -> new TreeMap<>(Comparator.reverseOrder()),
                        Collectors.toCollection(TreeSet::new))
        );
    }

    public static Map<String, Long> obterContagemPessoasPorCargo(List<Pessoa> Pessoas) {
        return Pessoas.stream().collect(
                Collectors.groupingBy(
                        Pessoa::getCargo,
                        Collectors.counting()
                )
        );
    }
}