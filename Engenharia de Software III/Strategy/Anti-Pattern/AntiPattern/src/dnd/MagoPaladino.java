package dnd;

public class MagoPaladino extends Personagem {
    public MagoPaladino(String nome) {
        super(nome,15, 8, 14, 14, 10, 14);
    }
    public void lancarMagia() {
        System.out.println(getNome() + " lança magia!");
    }
    public void atacar() {
        System.out.println(getNome() + " realiza um ataque!");
    }
}
