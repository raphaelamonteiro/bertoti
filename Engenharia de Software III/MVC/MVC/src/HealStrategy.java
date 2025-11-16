public class HealStrategy implements ActionStrategy {
    @Override
    public void execute(Player player) {
        player.setHp(player.getHp() + 10);
        System.out.println("O player foi curado! +10 HP");
    }
}
