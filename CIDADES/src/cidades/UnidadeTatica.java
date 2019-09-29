/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidades;

/**
 *
 * @author ismae
 */
public class UnidadeTatica {

    private int cidade_atual;
    private int id;
    static int ids = 0;

    public UnidadeTatica() {
        this.id = ids;
        ids++;
    }

    public UnidadeTatica(int cidade_atual) {
        this.id = ids;
        ids++;
        this.cidade_atual = cidade_atual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCidade_atual() {
        return cidade_atual;
    }

    public void setCidade_atual(int cidade_atual) {
        this.cidade_atual = cidade_atual;
    }

}
