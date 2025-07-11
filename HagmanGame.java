import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HagmanGame {

    public HagmanGame(){
    }

    public void playGame(){
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        SecretWord secretWord = new SecretWord();
        secretWord.readFileWords(words);
        String wordSelected = secretWord.selectRandomWord(words);

        System.out.println("");
        System.out.print("Entre com o nome do jogador: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println("Olá " + playerName + " Bem vindo(a) ao JOGO DA FORCA! ");
        System.out.println("Você tem " + player.life + " para acertar a palavra secreta.");

        secretWord.printHiddenWord(wordSelected);

        while (player.life > 0) {
            System.out.print("Entre com uma letra: ");
            char letter = scanner.nextLine().charAt(0);
            if (secretWord.updateHiddenWord(letter, wordSelected) == false){
                player.updateLife();
            }
            System.out.println("");
            System.out.println("Chances Restantes: " + player.life);
            System.out.println("");
        }
    }
}
