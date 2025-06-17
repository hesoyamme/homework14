import java.io.*;

public class Main {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\mp2dbv86\\IdeaProjects\\homework14\\src\\romeo_and_juliet.txt";
        String outputFile = "C:\\Users\\mp2dbv86\\IdeaProjects\\homework14\\src\\longest_word.txt";
        String longestWord = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)))) {
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

            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)))) {
                writer.write("Самое длинное слово: " + longestWord);
            }
            System.out.printf("Самое длинное слово %s записано в файл", longestWord);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
        }
    }
}