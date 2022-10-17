import java.util.Scanner;
import java.util.ArrayList;

public class Personagem {
    private int ataque;
    private double defesa;
    private int vida;
    private String nomePersonagem;
    private Arma armaPersonagem;


    public Personagem() {
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

    public int getVida() {
        return this.vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNomePersonagem() {
        return this.nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public void name() {
    }

    public Arma getArmaPersonagem() {
        return this.armaPersonagem;
    }

    public void setArmaPersonagem(Arma armaPersonagem) {
        this.armaPersonagem = armaPersonagem;
        this.ataque += armaPersonagem.getAtaque();
        this.defesa += armaPersonagem.getDefesa();
    }

    public double receberAtaque(int ataque) {
        if (ataque > defesa)
            vida -= (ataque - defesa);
        return vida;
    }

    public double defender() {
        return defesa += defesa * 0.10;
    }


    public String toString() {
        return
                nomePersonagem;
    }

}

