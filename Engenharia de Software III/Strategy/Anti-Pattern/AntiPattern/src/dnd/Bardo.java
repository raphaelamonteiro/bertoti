package dnd;

public class Bardo extends Personagem{
    public Bardo(String nome) {
        super(nome,8, 12, 10, 10, 12, 16);
    }
    public void tocarMusica() {
        System.out.println(getNome() + " toca uma canção inspiradora!");
    }
}
