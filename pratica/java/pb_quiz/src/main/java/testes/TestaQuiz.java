package testes;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import dao.QuestaoDao;
import dao.ResultadoDao;
import model.Questao;
import model.Resultado;
import util.JPAUtil;

public class TestaQuiz {

	public static void main(String[] args) {
		
		int opcao = 1;
		Boolean isPrimeiraJogada = true;
		Scanner scan = new Scanner(System.in);
		
		EntityManager em;
		em = JPAUtil.getEntityManager();
		ResultadoDao resultadoDao = new ResultadoDao(em);
		QuestaoDao questaoDao = new QuestaoDao(em);
		
		System.out.print("Digite seu nome: ");
		String jogador = scan.nextLine();
				
		while(true){
			if(isPrimeiraJogada) {
				System.out.println("\n1 - Jogar");
			} else {
				System.out.println("\n1 - Jogar novamente");
			}
			System.out.println( "2 - Ver placar");
			System.out.println( "0 - Sair ");
			
			try {
				opcao = scan.nextInt();
				scan.nextLine();
			} catch(InputMismatchException e) {
				System.out.println("Opcao invalida!");
				break;
			}
			if(opcao == 1){
				isPrimeiraJogada = false;
				int erros = 0;
				int acertos = 0;
				
				List<Questao> perguntas = questaoDao.buscarQuestoes();
				for(Questao q : perguntas) {
					
					System.out.println("--------------------------------------------");
					System.out.println(q.getPergunta());
					System.out.print("\n Digite V para verdadeiro ou F para falso: ");
					
					String respostaDigitada = scan.nextLine();
					while(respostaDigitada.contentEquals("V") == false && respostaDigitada.contentEquals("F") == false) {
						System.out.println("Resposta invalida!, Digite novamente: ");
						respostaDigitada = scan.nextLine();
					}
					char respostaDoJogador = respostaDigitada.charAt(0);
					boolean respostaCorreta = q.isVerdadeira();
					
					if ( (respostaDoJogador == 'V' && respostaCorreta == true) || (respostaDoJogador == 'F' && respostaCorreta == false) ) {
						System.out.println("\nResposta correta!");
						acertos++;
					} else {
						System.out.println("\nResposta Errada");
						erros++;
					}
					
				}
				
				System.out.println("\nJogador: " + jogador + "\nAcertos: " + acertos + "\nErros: " + erros);
				
				System.out.println("--------------------------------------------");
				
				Resultado resultado = new Resultado(jogador, acertos, erros);
				
				em.getTransaction().begin();
				resultadoDao.salvarResultado(resultado);
				em.getTransaction().commit();
				
			} else if(opcao == 2) {

				System.out.println("\n--------------------------------------------");
				em.getTransaction().begin();
				List<Resultado> placar = resultadoDao.mostrarPlacar();
			
				for(Resultado r : placar) {
					System.out.println("Jogador: " + r.getJogador() + " Acertos: " + r.getAcertos() + " Data: " + r.getDataDaPartida());
				}
				em.getTransaction().commit();
				System.out.println("--------------------------------------------");
				
			}
			if(opcao == 0) {
				break;
			}
		}

		System.out.println("--------------------------------------------");
		System.out.println("Saindo");
		em.close();
	}
}
