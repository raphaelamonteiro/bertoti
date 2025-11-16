public class Mago implements Observer {
    @Override
    public void update(String evento) {
        System.out.println("Mago reage: " + evento);
    }
}
