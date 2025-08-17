package dnd;

public class Mago extends Personagem{
    public Mago(String nome) {
        super(nome,8, 16, 15, 16, 12, 8);
    }
    public void lancarMagia() {
        System.out.println(getNome() + " lança magia!");
    }
}
