public class PlayerController {
    private ActionStrategy strategy;

    public void setStrategy(ActionStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute(Player player) {
        if (strategy != null) {
            strategy.execute(player);
        }
    }
}
