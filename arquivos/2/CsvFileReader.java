import java.io.*;

public class CsvFileReader {
    public static void main(String[] args) {
        String fileName = "funcionarios.csv"; // Nome do arquivo fixo para leitura


        // efetue a leitura do arquivo
        String root = System.getProperty("user.dir");
        String path = root + File.separator + "arquivos" + File.separator + "2" + File.separator + fileName;
        //try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
        try(BufferedReader reader = new BufferedReader(new FileReader("/home/student_jail/student_repo/arquivos/2/funcionarios.csv"))) {
            reader.lines().forEach(line -> {
                String[] split = line.split(",");
                System.out.printf("Funcionário: %s\n", split[0]);
                System.out.printf("Idade: %s\n", split[1]);
                System.out.printf("Departamento: %s\n", split[2]);
                System.out.printf("Salarial: %s\n", split[3]);
                System.out.println("------------------------");
            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Leitura do arquivo concluída.");
    }
}