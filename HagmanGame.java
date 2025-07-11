import java.util.ArrayList;
import java.util.List;
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

        char[] hideWord = secretWord.printHiddenWord(wordSelected);

        while (!hasPlayerWon(hideWord, wordSelected) && !hasPlayerLost(player.life)){
            System.out.print("Entre com uma letra: ");
            char letter = scanner.nextLine().charAt(0);
            if (secretWord.updateHiddenWord(letter, wordSelected) == false){
                player.updateLife();
            }
            System.out.println("");
            System.out.println("Chances Restantes: " + player.life);
            System.out.println("");
        }
        
        if(hasPlayerLost(player.life) == true){
            System.out.println("");
            System.out.println("GAME OVER !");
            System.out.println("");
        }
        else if (hasPlayerWon(hideWord,wordSelected) == true){
            System.out.println("");
            System.out.println("YOU WIN !");
            System.out.println("");
        }
    }

    public boolean hasPlayerWon(char[] hideWord, String wordSelected){
        boolean win;
        String hideWordString = new String(hideWord);
        if(hideWordString.equals(wordSelected)){
            win = true;
        }
        else{
            win = false;
        }
        return win;
    }

    public boolean hasPlayerLost(int life){
        boolean lost = false;
        if (life == 0){
            lost = true;
        }
        return lost;
    }
}
