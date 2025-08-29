package pr13;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
//----------------------------------
// src/pr13/words.txt
//----------------------------------
public class WordChain {
    public static void main(String[] args) throws IOException {
        // Считывание имени файла с консоли
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();
        scanner.close();
        System.out.println(fileName);

        // Чтение слов из файла
        List<String> words = Files.readAllLines(Paths.get(fileName));
        if (words.isEmpty()) {
            System.out.println("Файл пустой.");
            return;
        }

        // Разделение строк на слова
        List<String> wordList = new ArrayList<>();
        for (String line : words) {
            wordList.addAll(Arrays.asList(line.split("\\s+")));
        }

        // Формирование цепочки
        String result = getLine(wordList);
        System.out.println("Результат:");
        System.out.println(result);
    }

    public static String getLine(List<String> words) {
        if (words == null || words.isEmpty()) {
            return "";
        }

        List<String> resultChain = findWordChain(words);
        return String.join(" ", resultChain);
    }

    private static List<String> findWordChain(List<String> words) {
        if (words.size() == 1) {
            return words;
        }

        // Пробуем разные начальные слова
        for (int i = 0; i < words.size(); i++) {
            List<String> currentChain = new ArrayList<>();
            currentChain.add(words.get(i));

            List<String> remainingWords = new ArrayList<>(words);
            remainingWords.remove(i);

            if (buildChain(currentChain, remainingWords)) {
                return currentChain;
            }
        }

        return words;
    }

    private static boolean buildChain(List<String> chain, List<String> remainingWords) {
        if (remainingWords.isEmpty()) {
            return true;
        }

        String lastWord = chain.get(chain.size() - 1);
        char lastChar = Character.toLowerCase(lastWord.charAt(lastWord.length() - 1));

        for (int i = 0; i < remainingWords.size(); i++) {
            String nextWord = remainingWords.get(i);
            char firstChar = Character.toLowerCase(nextWord.charAt(0));

            if (lastChar == firstChar) {
                chain.add(nextWord);
                List<String> nextRemainingWords = new ArrayList<>(remainingWords);
                nextRemainingWords.remove(i);

                if (buildChain(chain, nextRemainingWords)) {
                    return true;
                }

                chain.remove(chain.size() - 1);
            }
        }

        return false;
    }
}
