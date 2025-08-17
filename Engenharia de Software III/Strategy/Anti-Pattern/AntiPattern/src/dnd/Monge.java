package dnd;

public class Monge extends Personagem {
    public Monge(String nome) {
        super(nome,8, 15, 14, 10, 14, 10);
    }
    public void esquivar() {
        System.out.println(getNome() + " se move rapidamente e desvia do ataques");
    }
}
