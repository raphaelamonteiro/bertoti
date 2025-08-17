package dnd;

public class Personagem {
    private String nome;
    private int forca;
    private int destreza;
    private int constituicao;
    private int inteligencia;
    private int sabedoria;
    private int carisma;

    public Personagem(String nome, int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma) {
        this.nome = nome;
        this.forca = forca;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
    }

    //getters & setters
public String getNome() {
        return nome;
}
public void setNome(String nome) {
        this.nome = nome;
}

public int getForca(){
    return forca;
}

public void setForca(int forca) {
    this.forca = forca;
}

public int getDestreza(){
    return destreza;
}

public void setDestreza(int destreza) {
        this.destreza = destreza;
}

public int getConstituicao(){
    return constituicao;
}

public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
}

public int getInteligencia(){
    return inteligencia;
}

public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
}

public int getSabedoria(){
    return sabedoria;
}
public void setSabedoria(int sabedoria) {
    this.sabedoria = sabedoria;
}

public int getCarisma(){
    return carisma;
}
public void setCarisma(int carisma) {
    this.carisma = carisma;
}


}