public class Bruxo implements Observer {
    @Override
    public void update(String evento) {
        System.out.println("Bruxo reage: " + evento);
    }
}
