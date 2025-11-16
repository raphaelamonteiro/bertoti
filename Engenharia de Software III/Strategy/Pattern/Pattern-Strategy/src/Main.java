public class Main {
    public static void main(String[] args) {
        // Um bardo com estilo musical
        Personagem bardo = new Personagem("Lyra", 8, 12, 10, 10, 12, 16, new EstiloMusical());
        bardo.executarEstilo(); // "O bardo toca uma música inspiradora!"

        // Ele pode mudar para usar magia também
        bardo.setEstilo(new EstiloMagia());
        bardo.executarEstilo(); // "O mago lança uma bola de fogo!"

        // Ou virar paladino na prática
        bardo.setEstilo(new EstiloCombate());
        bardo.executarEstilo(); // "O paladino golpeia com sua espada sagrada!"
    }
}
