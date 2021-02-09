package com.jaume.penjat;

import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Tauler {

    private char[] paraulaSecreta;
    private String[] paraulaEndivinada;
    private Integer intents;
    private String lletra;

    public Integer getIntents() {
        return intents;
    }

    public void setIntents(Integer intents) {
        this.intents = intents;
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

    public void setParaulaEndivinada(String[] paraulaEndivinada) {
        this.paraulaEndivinada = paraulaEndivinada;
    }

    public String getLletra() {
        return lletra;
    }

    public void setLletra(String lletra) {
        this.lletra = lletra;
    }


    public void inicialitzarPartida(String paraula, Integer intents) {
        char[] secret = new char[paraula.length()];
        String[] secret2 = new String[paraula.length()];
        for (int i = 0; i < paraula.length(); i++) {
            secret[i] = paraula.charAt(i);

        }
        this.setParaulaSecreta(secret);
        this.setIntents(intents);
        this.setParaulaEndivinada(secret2);

    }

    public String verificar(String lletra) {
        char miLetra = lletra.charAt(0);
        String content = "";
        for (int i = 0; i < this.paraulaSecreta.length; i++) {
            if (miLetra == this.paraulaSecreta[i]) {
                this.paraulaEndivinada[i] = lletra;
                content += lletra;
            } else {
                this.paraulaEndivinada[i] = null;
                content = "";
            }
        }

        if (content.equals("")) {
            this.intents -= 1;
            return "Lletra incorrecte";
        }
        content = "";
        return String.valueOf(this.getParaulaEndivinada());
    }

    public String imprimir() {
        String content = "";
        for (int i = 0; i < paraulaSecreta.length; i++) {
            content += "_";
        }
        System.out.println(content);
        return content;
    }

    public String imprimirAmbLletres() {

        return "Hola";
    }

    public String imprimirVides() {
        Integer vides = getIntents();

        if (vides == 1) {
            return "Et queda 1 vida";
        } else {
            return "Et queden " + vides + " vides";
        }
    }

    public String imprimirVidesSingular() {

        return "Hola";
    }

    public boolean hasGuanyat() {
        return true;
    }
}
