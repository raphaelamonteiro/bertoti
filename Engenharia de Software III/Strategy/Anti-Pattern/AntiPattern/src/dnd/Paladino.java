package dnd;

public class Paladino extends Personagem{
    public Paladino(String nome) {
        super(nome,16, 10, 14, 8, 12, 16);
    }
    public void atacar() {
        System.out.println(getNome() + " realiza um ataque!");
    }
}
