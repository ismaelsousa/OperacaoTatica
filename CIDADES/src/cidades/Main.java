/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ismae
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Lista de cidades atacadas
        Cidade cidades[] = {
            new Cidade("Barroquinha"),
            new Cidade("Chaval"),
            new Cidade("Jijoca+de+jericoacoara"),
            new Cidade("Acaraú"),     
            new Cidade("Itarema"),    
            new Cidade("Marco"),    
            new Cidade("Morrinhos"),    
            new Cidade("Tururu"),    
            new Cidade("Massapê"),    
            new Cidade("Tianguá"),

            new Cidade("São+Benedito"),    
            new Cidade("Sobral"),    
            new Cidade("Forquilha"),    
            new Cidade("Umirim"),    
            new Cidade("Caucaia"),    
            new Cidade("São+Gonçalo+do+Amarante"),    
            new Cidade("Paracuru"),    
            new Cidade("Maranguape"),    
            new Cidade("Maracanaú"),    
            new Cidade("Pacatuba"),

            new Cidade("Fortaleza"),    
            new Cidade("Aquiraz"),    
            new Cidade("Eusébio"),    
            new Cidade("Guaiúba"),    
            new Cidade("Pacoti"),    
            new Cidade("Reriutaba"),    
            new Cidade("Varjota"),    
            new Cidade("Canindé"),    
            new Cidade("Horizonte"),    
            new Cidade("Baturité"),    

            new Cidade("Itatira"),    
            new Cidade("Crateús"),    
            new Cidade("Piquet+Carneiro"),    
            new Cidade("Saboeiro"),    
            new Cidade("Iguatu"),    
            new Cidade("Icó"),    
            new Cidade("Juazeiro+do+Norte"),    
            new Cidade("Limoeiro+do+Norte"),    
            new Cidade("Tabuleiro+do+Norte"),    
            new Cidade("Morada+Nova"),  

            new Cidade("Quixadá"),    
            new Cidade("Ibaretama"),    
            new Cidade("Aracoiba"),    
            new Cidade("Jaguaruana"),    
            new Cidade("Icapuí"),    
            new Cidade("Aracati"),    
            new Cidade("Chorozinho"),    
            new Cidade("Pacajus"),    
            new Cidade("Pindoretama")  
         };
        
        
        //Hash Com a chave sendo o nome da cidade e o valor sendo a posicao que ela está no array       
        HashMap<String, Integer> hash = new HashMap<String, Integer>();        
        
        // Mapeando às cidades para a hash        
        for (int i = 0; i < cidades.length; i++) {
            hash.put(cidades[i].getNome(), i);           
        }        
        
        // Matriz com as distância entre as cidades
        double[][] matriz = new double[49][49];
        
        // Lendo as distância entre as cidades do arquivo
        try {
            BufferedReader br = new BufferedReader(
                    // Colocar caminho para o arquivo com as distancia, vc pode encontrar no github https://github.com/ismaelsousa/MatrixDistanceWithGoogleMaps
                    // mapCitys.txt
                    
                    new FileReader(
                    "C:\\Users\\ismae\\Google Drive\\UFC-RUSSAS\\SEMESTRES\\7 "
                            + "semestre\\IA\\2 trabalho\\Segurança publica\\"
                            + "SegurancaTrabalhoIA\\src\\app\\mapCitys.txt"));
            while (br.ready()) {
                String linha = br.readLine(); 
                // Quebrando a informação do arquivo
                // no arquivo está CidadeA-CidadeB-DaDistancia
                String partes[] = linha.split("-");  
                //Preechendo os valores na matriz de distâncias
                matriz[hash.get(partes[0])][hash.get(partes[1])] = Double.parseDouble(partes[2]);
                matriz[hash.get(partes[1])][hash.get(partes[0])] = Double.parseDouble(partes[2]);                
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }               
        
        // Criar 5 Unidade tática em cidades aleatórias
        UnidadeTatica undTs[] = {
            new UnidadeTatica(Cidade.random.nextInt(49)),
            new UnidadeTatica(Cidade.random.nextInt(49)),
            new UnidadeTatica(Cidade.random.nextInt(49)),
            new UnidadeTatica(Cidade.random.nextInt(49)),
            new UnidadeTatica(Cidade.random.nextInt(49))
        };
        
        // Este vetor de lista vai guardar cada cidade que foi visitada e por quem
        ArrayList<Integer> vetorDeCidadesVisitadas[] = new ArrayList[5];
        
        // Iniciando o arrayList
        for (int i = 0; i < vetorDeCidadesVisitadas.length; i++) {
            vetorDeCidadesVisitadas[i] = new ArrayList<>();
            // Colocando a primeira cidade que cada policia está
            vetorDeCidadesVisitadas[i].add(undTs[i].getCidade_atual());
        }
                
        int qtdDias = 0;
        // Cada volta do while representa um dia e só será quebrado quando todas cidades forem visitadas e com índice 0
        while(!Cidade.todasCidadesVizitadasEPacificadas(cidades)){                                                      
            // Fazer lógica que ver todas as cidades que as undades estão
            // Para cada unidade tatica vamos reduzir o niveldeSegurança da cidade que ela está
            // Atualizar o número de vitima a cada volta do while que vai representar um dia
            // Se alguma und estiver na cidade que o nivel de segurança zerou, 
            // então busca nova cidade com a heuristica gulosa
            
            // Conta quantos dias foram necessários para pacificar tudo
            qtdDias++;            
            System.out.println("Dia "+qtdDias);
                        
            // Para cada unidade tática vai ser atualizado tudo relacionado a ela
            for (UnidadeTatica undT : undTs) {                               
                // Marca a cidade como visitada a cidade que ela está
                cidades[undT.getCidade_atual()].setVisitada(true);                              
                
                // Aqui decrementa o número de segurança já que a unidade está nessa cidade tendo o nivel > 0
                if(cidades[undT.getCidade_atual()].getNivelDeSeguranca()>0){
                     cidades[undT.getCidade_atual()]
                             .setNivelDeSeguranca(
                                     cidades[undT.getCidade_atual()].getNivelDeSeguranca()-1
                             );
                }else{
                    //Se n for > 0 então ele vai mudar de cidade, pois já pacificou
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Unidade "+undT.getId());
                    System.out.println("Está na cidade "+cidades[undT.getCidade_atual()].getNome());
                    System.out.println("O número de vítimas "+cidades[undT.getCidade_atual()].getNumVitima());                
                    System.out.println("O nível de segurança "+cidades[undT.getCidade_atual()].getNivelDeSeguranca());
                    
                    // Busca nova cidade para ir, Chama a central que calcula a próxima cidade para se ir
                    int cidadeNova = Central.heuristicaCalculaDistancia(matriz, undT.getCidade_atual(), cidades);                    
                    System.out.println("A unidade "+undT.getId()+" precisa mudar para outra cidade "+cidadeNova );
                    
                    // Caso não possua cidade nova para ser visitada ele passa, para as outras unidades 
                    if(cidadeNova==-1) continue;
                    
                    // Atualiza em qual cidade ele está
                    undT.setCidade_atual(cidadeNova);  
                    
                    // Coloca na lista cada cidade visitada 
                    vetorDeCidadesVisitadas[undT.getId()].add(cidadeNova);                    
                }
                   
            }
            
            
            // Se a cidade não foi vizitada então aumenta o número de vítimas e depois o nivelDeSeguranca                
            for (Cidade c : cidades) {               
                if(!c.isVisitada()){
                    c.setNumVitima(c.getNumVitima()+c.getNivelDeSeguranca());
                    
                    // Só aumenta até 10
                    if(c.getNivelDeSeguranca()<10){                        
                        c.setNivelDeSeguranca(c.getNivelDeSeguranca()+1);                        
                    }
                }
            }
            
            // Printa um array com a posição de cada unidade tática
            //[ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][2][ ][ ][ ][3][ ][0][ ][ ][4][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][1][ ][ ][ ][ ][ ][ ]
            System.out.println("");            
            for (int j = 0; j < cidades.length; j++) {
                boolean estava= false;
                for (int i = 0; i < undTs.length; i++) {
                    if(undTs[i].getCidade_atual()==j){
                        estava= true;
                        System.out.print("["+undTs[i].getId()+"]");
                    }
                }
                if(!estava)
                    System.out.print("[ ]");
            }
            System.out.println("");                                                   
        }
        
        // Aqui já finalizou toda operação 
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("Toda operação levou "+qtdDias);
        System.out.println("");
        
        // Printa lista de cada unidade com suas respectivas cidades visitadas e o número de vítimas
        // Unidade 0  Pindoretama 0-> Barroquinha 25-> Iguatu 104-> Morrinhos 222-> Morada+Nova 345-> 
        //     Sobral 467-> Ibaretama 525-> Tururu 675-> Baturité 799-> Fortaleza 900->
        for (int i =0 ; i < undTs.length;i++) {
            System.out.print("Unidade "+ undTs[i].getId()+" ");
            for (int j = 0; j < vetorDeCidadesVisitadas[i].size(); j++) {
                System.out.print(" "+cidades[vetorDeCidadesVisitadas[i].get(j)].getNome()+""
                        + " "+cidades[vetorDeCidadesVisitadas[i].get(j)].getNumVitima()+" ->");
            }
            System.out.println("");
        }        
    }
    
}
