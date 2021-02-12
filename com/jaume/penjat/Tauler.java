package com.jaume.penjat;

import java.io.Serializable;
import java.util.Arrays;

public class Tauler {

    private char[] paraulaSecreta;
    private String[] paraulaEndivinada;
    private Integer vides;
    private Integer intents;
    private String lletra;
    private Integer comodin;
    private Integer comodin2;
    private String[] imprimir;

    public String[] getImprimir() {
        return imprimir;
    }

    public void setImprimir(String[] imprimir) {
        this.imprimir = imprimir;
    }

    public Integer getComodin2() {
        return comodin2;
    }

    public void setComodin2(Integer comodin2) {
        this.comodin2 = comodin2;
    }

    public char[] getParaulaSecreta() {
        return paraulaSecreta;
    }

    public void setParaulaSecreta(char[] paraulaSecreta) {
        this.paraulaSecreta = paraulaSecreta;
    }

    public String[] getParaulaEndivinada() {
        return paraulaEndivinada;
    }

    public void setParaulaEndivinada(String paraulaEndivinada) {
    }

    public void setParaulaEndivinada(String[] paraulaEndivinada) {
        this.paraulaEndivinada = paraulaEndivinada;
    }

    public Integer getVides() {
        return vides;
    }

    public void setVides(Integer vides) {
        this.vides = vides;
    }

    public Integer getIntents() {
        return intents;
    }

    public void setIntents(Integer intents) {
        this.intents = intents;
    }

    public String getLletra() {
        return lletra;
    }

    public void setLletra(String lletra) {
        this.lletra = lletra;
    }

    public Integer getComodin() {
        return comodin;
    }

    public void setComodin(Integer comodin) {
        this.comodin = comodin;
    }

    public void inicialitzarPartida(String paraula, Integer intents) {
        char[] secret = new char[paraula.length()];
        String[] secret2 = new String[paraula.length()];

        for (int i = 0; i < paraula.length(); i++) {
            secret[i] = paraula.charAt(i);
        }

        this.setParaulaSecreta(secret);
        this.setVides(intents);
        this.setIntents(intents);
        this.setParaulaEndivinada(secret2);
        this.setImprimir(secret2);
        this.setComodin(1);
        this.setComodin2(1);
    }

    public String verificar(String lletra) {
        char miLetra = lletra.charAt(0);
        setLletra(lletra);
        String content = "";

        if (getComodin().equals(1)) {
            for (int i = 0; i < this.paraulaSecreta.length; i++) {
                if (miLetra == this.paraulaSecreta[i]) {
                    this.paraulaEndivinada[i] = lletra;
                    content += lletra;
                } else {
                    this.paraulaEndivinada[i] = null;
                    content += "";
                }
            }
            setComodin(2);
        } else {
            for (int i = 0; i < this.paraulaSecreta.length; i++) {
                if (miLetra == this.paraulaSecreta[i]) {
                    this.paraulaEndivinada[i] = lletra;
                    content += lletra;
                } else {
                    content += "";
                }
            }
        }

        if (content.equals("")) {
            this.intents -= 1;
            return "Lletra incorrecte";
        }
        content = "";
        return "";
    }

    public String imprimir() {
        String content = "";

        if (getComodin2().equals(1)) {
            for (int i = 0; i < getParaulaSecreta().length; i++) {
                this.imprimir[i] = "_";
            }
            setComodin2(2);
            for (int i = 0; i < this.getParaulaEndivinada().length; i++) {
                content += this.imprimir[i];
            }
            return content;

        } else if (getComodin2().equals(2)) {
            for (int i = 0; i < this.paraulaEndivinada.length; i++) {
                if (this.paraulaEndivinada[i] == getLletra()) {
                    this.imprimir[i] = this.paraulaEndivinada[i];
                } else {
                    this.imprimir[i] = "_";
                }
            }
            setLletra("");
            setComodin2(3);
            for (int i = 0; i < this.getParaulaEndivinada().length; i++) {
                content += this.imprimir[i];
            }
            return content;
        } else {
            for (int i = 0; i < this.paraulaEndivinada.length; i++) {
                if (this.paraulaEndivinada[i] == getLletra()) {
                    this.imprimir[i] = this.paraulaEndivinada[i];
                }
            }
        }
        for (int i = 0; i < this.getParaulaEndivinada().length; i++) {
            content += this.imprimir[i];
        }
        return content;
    }

    public String imprimirVides() {

        if (getIntents() == 1) {
            return "Et queda 1 vida de " + getVides();
        } else {
            return "Et queden " + getIntents() + " vides de " + getVides();
        }
    }

    public boolean hasGuanyat() {
        String paraula = "";
        for (int i = 0; i < this.getParaulaEndivinada().length; i++) {
            paraula += this.paraulaEndivinada[i];
        }
        if (String.valueOf(getParaulaSecreta()).equals(paraula) && !getIntents().equals(0)) {
            return true;
        } else {
            return false;
        }
    }
}
