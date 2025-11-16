public class AttackStrategy implements ActionStrategy {
    @Override
    public void execute(Player player) {
        player.setHp(player.getHp() - 10);
        System.out.println("O player levou dano! -10 HP");
    }
}
