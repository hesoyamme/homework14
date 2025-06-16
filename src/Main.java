import java.io.*;

public class Main {
    public static void main(String[] args) {
        String inputFile = "romeo_and_juliet.txt";
        String outputFile = "longest_word.txt";
        String longestWord = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String s;
            while ((s = reader.readLine()) != null) {
                String[] words = s.split("[\\s.,;:!?()\"'-]+");
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write("Самое длинное слово: " + longestWord);
            }
            System.out.printf("Самое длинное слово %s записано в файл", longestWord);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
        }
    }
}