public class Dragao {

    private int vida;
    private String estado;

    // Observadores com tipos CONCRETOS → acoplamento forte
    private Clerigo clerigo;
    private Mago mago;
    private Bruxo bruxo;

    public Dragao(int vidaInicial) {
        this.vida = vidaInicial;
        this.estado = "Calmo";
    }

    // Setters manuais para cada observador
    public void setClerigo(Clerigo c) { this.clerigo = c; }
    public void setMago(Mago m) { this.mago = m; }
    public void setBruxo(Bruxo a) { this.bruxo = a; }

    public void mudarEstado(String novoEstado) {
        this.estado = novoEstado;

        // RUIM: ordem fixa e chamada manual
        if (clerigo != null) clerigo.reagirAoDragao(this);
        if (mago != null) mago.reagirAoDragao(this);
        if (bruxo != null) bruxo.reagirAoDragao(this);
    }

    // Observadores dependem desses detalhes internos:
    public int getVida() { return vida; }
    public String getEstado() { return estado; }
}
