package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Resultado;

public class ResultadoDao {

	EntityManager em;
	
	public ResultadoDao(EntityManager em){
		this.em = em;
	}
	
	public void salvarResultado(Resultado resultado){
		this.em.persist(resultado);
	}
	
	public List<Resultado> mostrarPlacar(){
		
		return em.createQuery("SELECT r FROM Resultado r ORDER BY r.acertos DESC", Resultado.class).getResultList();
		
	}
	
	
	
}
