//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Player model = new Player();
        PlayerView view = new PlayerView(model);
        PlayerController controller = new PlayerController();

        // Estratégia 1: atacar
        controller.setStrategy(new AttackStrategy());
        controller.execute(model);

        // Estratégia 2: curar
        controller.setStrategy(new HealStrategy());
        controller.execute(model);
    }
}