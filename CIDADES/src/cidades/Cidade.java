/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidades;
import java.util.Random;
/**
 *
 * @author ismae
 */
public class Cidade {
    private String nome;
    private int nivelDeSeguranca;
    private int numVitima;
    private boolean visitada = false;
    static Random random = new Random();

    public Cidade(String nome) {
        this.nome = nome;
        this.nivelDeSeguranca = Cidade.random.nextInt(11);
    }
    /*
        Verifica se todas as ciades já foram vizitadas
    */
    static boolean todasCidadesVizitadasEPacificadas(Cidade cidades[]){
        for (Cidade cidade : cidades) {
            // A cidade foi vizitada? e se foi já está passificadas?
            if(!cidade.isVisitada()|| cidade.getNivelDeSeguranca() > 0){
                return false;
            }
        }
        return true;
    }
    public boolean isVisitada() {
        return visitada;
    }

    public void setVisitada(boolean visitada) {
        this.visitada = visitada;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivelDeSeguranca() {
        return nivelDeSeguranca;
    }

    public void setNivelDeSeguranca(int nivelDeSeguranca) {
        this.nivelDeSeguranca = nivelDeSeguranca;
    }

    public int getNumVitima() {
        return numVitima;
    }

    public void setNumVitima(int numVitima) {
        this.numVitima = numVitima;
    }
    
}
