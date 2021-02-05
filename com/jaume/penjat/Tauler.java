package com.jaume.penjat;

import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Tauler {

    private char[] paraulaSecreta;
    private String[] paraulaEndivinada;
    private Integer intents;

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

    public String imprimirVides() {
        Integer vides = getIntents();

        if (vides == 1) {
            return "Et queda 1 vida";
        } else {
            return "Et queden " + vides + " vides";
        }
    }

    public String imprimirVidesSingular() {

    }

    public void inicialitzarPartida(String paraula, Integer intents) {

        char[] secret = new char[paraula.length()];
        for (int i = 0; i < paraula.length(); i++) {
            secret[i] = paraula.charAt(i);
        }
        this.setParaulaSecreta(secret);
        this.setIntents(intents);
    }


    public boolean verificar(String lletra) {

        char miLetra = lletra.charAt(0);
        for (int i = 0; i < paraulaSecreta.length; i++) {
            if (miLetra == paraulaSecreta[i]) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public String imprimir() {

        if (verificar("h")) {
            for (int i = 0; i < paraulaSecreta.length; i++) {
                if (lletra == paraulaSecreta[i]) {
                    System.out.print(lletra);
                } else {
                    System.out.print("_");
                }
            }

        }

    }

    public String imprimirCapEncert() {

        String content = "";
        for (int i = 0; i < paraulaSecreta.length; i++) {
            content += "_";
        }
        System.out.println(content);
        return content;
    }

    public String imprimirAmbLletres() {

        return
    }
}
