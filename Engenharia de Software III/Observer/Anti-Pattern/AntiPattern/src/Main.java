//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dragao dragao = new Dragao(300);

        dragao.setClerigo(new Clerigo());
        dragao.setMago(new Mago());
        dragao.setBruxo(new Bruxo());

        dragao.mudarEstado("Furioso");
    }
}