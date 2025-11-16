import java.util.ArrayList;
import java.util.List;

public class Player implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private int hp = 100;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        notifyObservers(); // <<< Notifica a View
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }
}
