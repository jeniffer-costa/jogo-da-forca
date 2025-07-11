public class Player {
    int life = 5;
    String nome;

    public Player(String nome){
        this.nome = nome;
    }

    public void updateLife(){
        life = life -1;
    }
    
}
