public class Clerigo implements Observer {
    @Override
    public void update(String evento) {
        System.out.println("Clérigo reage: " + evento);
    }
}
