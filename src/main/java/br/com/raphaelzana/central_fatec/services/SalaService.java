package br.com.raphaelzana.central_fatec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.raphaelzana.central_fatec.domain.Sala;
import br.com.raphaelzana.central_fatec.repositories.SalaRepository;

@Service
public class SalaService {
	
	@Autowired
	private SalaRepository repo;
	
	public Sala find(Integer id) {
		Optional<Sala> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Sala> findAll(){
		return repo.findAll();
	}

	@Transactional
	public Sala insert(Sala obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Sala update(Sala obj) {
		Sala newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	private void updateData(Sala newObj, Sala obj) {
		newObj.setNome(obj.getNome());
		newObj.setBloco(obj.getBloco());
	}
	
}
