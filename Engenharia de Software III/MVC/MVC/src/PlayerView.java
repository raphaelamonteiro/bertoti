public class PlayerView implements Observer {
    private Player player;

    public PlayerView(Player player) {
        this.player = player;
        this.player.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("HP atualizado na View: " + player.getHp());
    }
}
