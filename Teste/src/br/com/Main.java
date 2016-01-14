package br.com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int x = 0; //x da posicao do robo
		int xMax = 0; //x maximo do plano cartesiano
		int yMax = 0; // y maximo do plano cartesiano
		int y = 0; //y da posicao do robo
		String pos = "";// posicao para onde o robo esta olhando

		String maximos = scanner.nextLine(); // string que pega a primeira insercao que e os tamnhos maximos do plano cartesiano
		String[] tamanhos = maximos.split(" ");// vetor que recebe os valores separados por espaco em branco
		xMax = Integer.parseInt(tamanhos[0]);//pega o primeiro valor do vetor e seta no x maximo
		yMax = Integer.parseInt(tamanhos[1]);//pega o segundo valor do vetor e seta no y maximo

		while (scanner.hasNextLine()) { //enquanto tiver praxima linha o programa solicita nova posicao e novos comandos
			String posicoes = scanner.nextLine();//string que pega a segunda linha de insercao que e a posicao do robo e pra onde esta olhando
			String[] posicao = posicoes.split(" ");//vetor que recebe os valores separando pelos espacos em branco
			x = Integer.parseInt(posicao[0]);//pega a primeira posicao do vetor que e o x
			y = Integer.parseInt(posicao[1]);//pega a segunda posicao do vetor que e o y
			pos = posicao[2];//pega a terceira posicao do vetor que e para onde esta olhando

			String comandos = scanner.nextLine();//string que pega a terceira linha de insercao que sao os comandos para andar/virar
			for (int aux = 0; aux < comandos.length(); aux++) {//for para percorrer toda a string
				String comando = comandos.substring(aux, aux+1);//string que recebe cada caracter da string comandos
				if (comando.equals("M")) {//se o comando for M, andar
					if (pos.equals("N")) {//se estiver olhando para Norte y+1
						y++;
					}else if (pos.equals("E")) {//se estiver olhando para Leste x+1
						x++;
					}else if (pos.equals("S")) {//se estiver olhando para o Sul y-1
						y--;
					}else if (pos.equals("W")) {//se estiver olhando para Oeste x-1
						x--;
					}
				}else
				if(comando.equals("L")) {//se o comando for L, virar para esquerda
					if (pos.equals("N")) {//se estiver olhando para norte, vira para Oeste
						pos = "W";
					}else if (pos.equals("W")) {//se estiver olhando para oeste, vira para o Sul
						pos = "S";
					}else if (pos.equals("S")) {//se estiver olhando para sul, vira para o Leste
						pos = "E";
					}else if (pos.equals("E")) {//se estiver olhando para Leste, vira para o Sul
						pos = "N";
					}
				}else
				if (comando.equals("R")) {//se o comando for R, virar para direita
					if (pos.equals("N")) {//se estiver olhando para norte, vira para Leste
						pos = "E";
					}else
					if (pos.equals("E")) {//se estiver olhando para Leste, vira para o Sul
						pos = "S";
					}else
					if (pos.equals("S")) {//se estiver olhando para Sul, vira para Oeste
						pos = "W";
					}else
					if (pos.equals("W")) {//se estiver olhando para Oeste, vira para o Norte
						pos = "N";
					}
				}
			}
			System.out.println(x + " " + y + " " + pos); //mostra os valores 
		}
	}
}
