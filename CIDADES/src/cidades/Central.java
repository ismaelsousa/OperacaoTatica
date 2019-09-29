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
public class Central {
    static int heuristicaCalculaDistancia(double matriz[][], int cidadeAtual, Cidade cidades[]){
        // buscar cidade que possua a media ponderada
        // (2*Distancia + nivelDePerigo)/3
        int cidadeEscolhida=-1;
        double mediaEscolhida = 0;
        for (int i = 0; i < matriz.length; i++) {
            if(i!=cidadeAtual){
                // Se a cidade ainda não foi vizitada
                if(!cidades[i].isVisitada()){
                    double media = (matriz[cidadeAtual][i] + 2*cidades[i].getNivelDeSeguranca())/3;                    
                    if(mediaEscolhida < media){                        
                        mediaEscolhida=media;
                        cidadeEscolhida=i;
                    }
                }
            }
        }       
        if(cidadeEscolhida!=-1){
            cidades[cidadeEscolhida].setVisitada(true);
        }
        return cidadeEscolhida;
    }      
    
}
