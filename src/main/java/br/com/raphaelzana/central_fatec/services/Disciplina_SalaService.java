package br.com.raphaelzana.central_fatec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.raphaelzana.central_fatec.domain.Disciplina_Sala;
import br.com.raphaelzana.central_fatec.domain.Disciplina_SalaPK;
import br.com.raphaelzana.central_fatec.repositories.Disciplina_SalaRepository;

@Service
public class Disciplina_SalaService {
	
	@Autowired
	private Disciplina_SalaRepository repo;
	
	@Autowired
	private CursoService service;
	
	@Autowired
	private DisciplinaService dservice;
	
	public List<Disciplina_Sala> busca(Integer curso,Integer semestre){
		
		return repo.findById_CursoAndSemestre(service.find(curso), semestre);
	}
	
	public Disciplina_Sala find(Integer curso, Integer disciplina) {
		Disciplina_SalaPK dspk = new Disciplina_SalaPK();
		dspk.setCurso(service.find(curso));
		dspk.setDisciplina(dservice.find(disciplina));
		Disciplina_Sala obj = repo.findById(dspk);
		return obj;
	}
	
	public List<Disciplina_Sala> findAll(){
		return repo.findAll();
	}

	@Transactional
	public Disciplina_Sala insert(Disciplina_Sala obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	/*public Disciplina_Sala update(Disciplina_Sala obj) {
		Disciplina_Sala newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}*/
	
	public void delete(Integer curso, Integer disciplina) {
		find(curso,disciplina);
		Disciplina_SalaPK dspk = new Disciplina_SalaPK();
		dspk.setCurso(service.find(curso));
		dspk.setDisciplina(dservice.find(disciplina));
		repo.deleteById(dspk);
	}
	
	/*private void updateData(Disciplina_Sala newObj, Disciplina_Sala obj) {
		
	}*/
	
}
