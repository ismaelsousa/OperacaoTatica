# OperacaoTatica
Este projeto é um algoritmo guloso para resolver o problema dos ataques ao ceará

## Motivação
Motivado pelos eventos ocorridos no início do ano de 2019, no qual inúmeros
ataques terroristas foram realizados pelo estado do Ceará, implemente uma solução
para escalonar a ação de grupos táticos de segurança que deve atuar em cidades do
estado.

## Problema
O problema do escalonamento de grupos táticos para segurança pública consiste
na distribuição e alocação de grupos táticos de segurança em resposta à ataques de
terrorismo localizados em cidades do estado. O secretário de segurança do estado
dispõe de 5 unidades táticas especializadas para combater ataques realizados em 49
cidades do estado. Cada unidade tática está equipada com veículos blindados com os
quais pode se locomover entre as cidades, e comunicar-se com uma central de
inteligência.
A função de uma equipe tática é realizar operações relacionadas à segurança em
uma cidade, pacificá-la, e, em seguida, partir para outra cidade. A função da Central
de Inteligência é monitorar os ataques e, de acordo com a distância e a gravidade da
situação, informar a uma unidade tática para qual cidade ela deve se deslocar.
Para este trabalho, considere que cada cidade possui um nível de segurança inicial
entre 0 e 10, sendo 0 para uma cidade que não está sendo atacada e 10 para uma
cidade que está sendo fortemente atacada. Para cada dia que uma cidade permaneça
sem atendimento, ela terá seu nível de segurança acrescido em 1. Uma vez que a
unidade tática se instale na cidade, o número de vítimas para de aumentar. Para cada
dia que a unidade fique na cidade, o nível de segurança reduz em 1. O papel da
Central de Inteligência é definir quais unidades táticas devem visitar quais cidades e
em qual ordem, de modo a minimizar o número de vítimas e a distância percorrida por
cada unidade. Uma cidade tem um número de vítimas igual ao nível de segurança
atual por dia, assim uma cidade em nível 10 de segurança atacada por 3 dias, deverá
ter um total de 30 vítimas.

## Esta atividade pode ser dividida em duas etapas:
<ul>
  <li>Obter a distância entre todas as cidades atacadas. Um meio de realizar esta tarefa
    é realizando uma consulta ao Google Cloud utilizando a DistanceMatrix API, que
    permite retornar uma matriz de distancias entre N pontos de origem e M pontos
    de destino.
    Código no github: https://github.com/ismaelsousa/MatrixDistanceWithGoogleMaps
  <li>Implementação de uma metaheurística que calcule uma rota para cada unidade
    com a menor distância que resulte no menor número de vítimas
  </li>
  </li>
</ul>

## Para executar
<ul>
  <li>Baixar arquivo mapCitys.txt no repositporio do matrixDistanceWithGoogleMaps citado anteriomente</li>
  <li>Baixar o código desse repositório, que é um projeto do NetBeans</li>
  <li>Na classe Main substituir no FileReader o caminho relativo do arquivo mapCitys.txt</li>
  <li>Agora é só rodar e ser feliz! :) </li>
</ul>

## Saída
_______________________________________________________________________________________________________
Toda operação levou 106 dias

Unidade 0  Icó 0 -> Itarema 62 -> Tabuleiro+do+Norte 179 -> Massapê 304 -> Chorozinho 392 -> Forquilha 494 -> Quixadá 625 -> São+Gonçalo+do+Amarante 735 -> Fortaleza 805 

Unidade 1  Barroquinha 0 -> Juazeiro+do+Norte 0 -> Acaraú 60 -> Limoeiro+do+Norte 177 -> São+Benedito 269 -> Aracati 355 -> Sobral 507 -> Pacajus 599 -> Umirim 720 -> Pacoti 795 -> Maracanaú 905 

Unidade 2  Eusébio 0 -> Saboeiro 44 -> Marco 180 -> Morada+Nova 285 -> Reriutaba 410 -> Pindoretama 475 -> Itatira 627 -> Paracuru 719 -> Guaiúba 840 

Unidade 3  Ibaretama 0 -> Chaval 9 -> Iguatu 114 -> Morrinhos 209 -> Icapuí 325 -> Crateús 395 -> Aquiraz 539 -> Canindé 660 -> Pacatuba 774 -> Caucaia 835 

Unidade 4  Aracoiba 0 -> Jijoca+de+jericoacoara 30 -> Piquet+Carneiro 140 -> Tianguá 224 -> Jaguaruana 360 -> Varjota 479 -> Horizonte 590 -> Tururu 699 -> Baturité 755 -> Maranguape 914 ->
