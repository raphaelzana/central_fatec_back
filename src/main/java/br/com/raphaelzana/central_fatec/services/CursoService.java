package br.com.raphaelzana.central_fatec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.raphaelzana.central_fatec.domain.Curso;
import br.com.raphaelzana.central_fatec.repositories.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repo;
	
	public Curso find(Integer id) {
		Optional<Curso> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Curso> findAll(){
		return repo.findAll();
	}

	@Transactional
	public Curso insert(Curso obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Curso update(Curso obj) {
		Curso newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	private void updateData(Curso newObj, Curso obj) {
		newObj.setNome(obj.getNome());
		newObj.setDuracao(obj.getDuracao());
		newObj.setPeriodo(obj.getPeriodo());
	}
	
}
