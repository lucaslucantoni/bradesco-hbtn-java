public class Programa {
    public static void main(String[] args) {
        GestaoAlunos gestaoAlunos = new GestaoAlunos();

        gestaoAlunos.adicionarAluno("Fulano", 20);
        gestaoAlunos.adicionarAluno("Beltrano", 20);
        gestaoAlunos.adicionarAluno("Cicrano", 20);

        gestaoAlunos.listarAlunos();

        gestaoAlunos.buscarAluno("Fulano");

        gestaoAlunos.excluirAluno("Beltrano");
        gestaoAlunos.excluirAluno("Beltrano2");
        gestaoAlunos.buscarAluno("xpto");

    }
}