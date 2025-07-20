import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileWritingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();


        // implemente o codigo aqui
        System.out.print("Digite o texto, após o término digite \"sair\": ");
        while (true) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
                String line = scanner.nextLine();
                if (line.equals("sair"))
                    break;
                writer.write(line);
                writer.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Arquivo salvo com o nome " + fileName);
        scanner.close();
    }
}