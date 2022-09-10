package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Questao;

public class QuestaoDao {

	EntityManager em;
	
	public QuestaoDao(EntityManager em){
		this.em = em;
	}
	
	public List<Questao> buscarQuestoes(){
		return em.createQuery("SELECT q FROM Questao q WHERE q.ativa = true", Questao.class).getResultList();
	}
	
}
