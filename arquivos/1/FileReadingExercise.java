import java.io.*;


public class FileReadingExercise {
    public static void main(String[] args) {
        String fileName = "exemplo.txt"; // Nome do arquivo fixo para leitura


        // efetue a leitura do arquivo
        String root = System.getProperty("user.dir");
        String path = root + File.separator + "arquivos" + File.separator + "1" + File.separator + fileName;
        System.out.println("Conteúdo do arquivo 'exemplo.txt':\n");
        try(BufferedReader reader = new BufferedReader(new FileReader("/home/student_jail/student_repo/arquivos/1/exemplo.txt"))) {
            reader.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nLeitura do arquivo concluída.");
    }
}