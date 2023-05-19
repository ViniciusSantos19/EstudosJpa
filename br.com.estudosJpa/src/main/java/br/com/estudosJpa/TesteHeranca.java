package br.com.estudosJpa;

import java.util.List;

import br.com.estudosJpa.Dao.GenericDAO;
import br.com.estudosJpa.Dao.heranca.Aluno;
import br.com.estudosJpa.Dao.heranca.AlunoBolsista;

public class TesteHeranca {

	public static void main(String[] args) {
		GenericDAO<Aluno> daoAluno = new GenericDAO<>(Aluno.class);
		//AlunoBolsista aluno = new AlunoBolsista("Marco", 1200.50);
		//daoAluno.salvar(aluno);
		List<Aluno> listaAluno;
		listaAluno = daoAluno.listar();
		listaAluno.forEach(a -> {
			System.out.println(a.getMatricula());
			System.out.println(a.getNome());		
		});
	}

}
