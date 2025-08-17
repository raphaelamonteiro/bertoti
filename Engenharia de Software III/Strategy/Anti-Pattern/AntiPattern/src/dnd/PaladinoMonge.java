package dnd;

public class PaladinoMonge extends Personagem{
    public PaladinoMonge(String nome) {
        super(nome,8, 15, 14, 10, 12, 14);
    }
    public void atacar() {
        System.out.println(getNome() + " realiza um ataque!");
    }
    public void esquivar() {
        System.out.println(getNome() + " se move rapidamente e desvia do ataques");
    }
}
