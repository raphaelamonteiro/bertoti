import dnd.*;

public class Main {
    public static void main(String[] args) {
        Mago mago = new Mago("Gandalf");
        mago.lancarMagia();
        System.out.println("Sabedoria: " + mago.getSabedoria());

        Bardo bardo = new Bardo("Lyra");
        bardo.tocarMusica();
        System.out.println("Carisma: " + bardo.getCarisma());

        MagoBardo magoBardo = new MagoBardo("Valen");
        magoBardo.lancarMagia();
        System.out.println("Sabedoria: " + mago.getSabedoria());
        magoBardo.tocarMusica();
        System.out.println("Carisma: " + magoBardo.getCarisma());

        Paladino paladino = new Paladino("Lancelot");
        paladino.atacar();
        System.out.println("Força: " + paladino.getForca());

        MagoPaladino magoPaladino = new MagoPaladino("Astrid");
        magoPaladino.lancarMagia();
        System.out.println("Sabedoria: " + magoPaladino.getSabedoria());
        magoPaladino.atacar();
        System.out.println("Força: " + magoPaladino.getForca());

        Monge monge = new Monge("Ytheshana");
        monge.esquivar();
        System.out.println("Destreza: " + monge.getDestreza());

        PaladinoMonge paladinoMonge = new PaladinoMonge("Lin");
        paladinoMonge.esquivar();
        System.out.println("Destreza: " + paladinoMonge.getDestreza());
        paladinoMonge.atacar();
        System.out.println("Força: " + paladinoMonge.getForca());


    }
}