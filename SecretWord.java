import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SecretWord {
    Random random = new Random();
    char[] hideWord;

    public SecretWord(){
    }

    // Ler o arquivo txt que contém as palavras e armazena dentro da lista de palavras
    public List<String> readFileWords(List<String> words){
        try {
            Scanner scanner = new Scanner(new File("Words.txt"));
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                words.add(word.toUpperCase());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado" + e.getMessage());
        }
        return words;
    }

    // Seleciona uma palavra aleatoria dentro da lista de palavras
    public String selectRandomWord(List<String> words){
        int index = random.nextInt(words.size());
        String selectedWord = words.get(index);
        System.out.println("Palavra Selecionada: " + selectedWord);
        return selectedWord;
    }

    // imprime a palavra escondida
    public char[] printHiddenWord (String word){
        hideWord = new char[word.length()];
        for (int i=0;i<word.length();i++) {
            hideWord[i] = ('_');
        }
        System.out.println(hideWord);
        return hideWord;
    }

    public boolean updateHiddenWord(char letter, String word){
        boolean findLetter = false;
        for (int i=0;i<word.length();i++){
            if(word.charAt(i) == Character.toUpperCase(letter)){
                hideWord[i] = Character.toUpperCase(letter);
                findLetter = true;
            }
        }
        System.out.print(hideWord);
        System.out.println("");
        return findLetter;
    }
}
