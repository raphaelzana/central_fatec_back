package br.com.raphaelzana.central_fatec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.raphaelzana.central_fatec.domain.Disciplina;
import br.com.raphaelzana.central_fatec.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {
	
	@Autowired
	private DisciplinaRepository repo;
	
	public Disciplina find(Integer id) {
		Optional<Disciplina> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Disciplina> findAll(){
		return repo.findAll();
	}

	@Transactional
	public Disciplina insert(Disciplina obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Disciplina update(Disciplina obj) {
		Disciplina newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	private void updateData(Disciplina newObj, Disciplina obj) {
		newObj.setNome(obj.getNome());
	}
	
}
