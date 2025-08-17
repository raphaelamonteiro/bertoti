package dnd;

public class MagoBardo extends Personagem {
    public MagoBardo(String nome) {
        super(nome,8, 12, 14, 14, 10, 15);
    }
    public void lancarMagia() {
        System.out.println(getNome() + "lança magia!");
    }
    public void tocarMusica() {
        System.out.println(getNome() + "Toca uma canção inspiradora!");
    }
}
