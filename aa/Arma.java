public class Arma extends Personagem {
    private String nomeArma;
    private int ataque;
    private double defesa;

    public Arma() {
    }

    public String getNomeArma() {
        return this.nomeArma;
    }

    public void setNomeArma(String nomeArma) {
        this.nomeArma = nomeArma;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public double getDefesa() {
        return this.defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
}