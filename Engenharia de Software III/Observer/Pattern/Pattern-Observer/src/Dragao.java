import java.util.ArrayList;
import java.util.List;

public class Dragao implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String estado;

    public void mudarEstado(String novoEstado) {
        this.estado = novoEstado;
        notifyObservers("Dragão está agora: " + novoEstado);
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
    public void notifyObservers(String evento) {
        for (Observer o : observers) {
            o.update(evento);
        }
    }
}
