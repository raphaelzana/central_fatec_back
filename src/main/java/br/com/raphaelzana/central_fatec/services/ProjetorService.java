package br.com.raphaelzana.central_fatec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.raphaelzana.central_fatec.domain.Projetor;
import br.com.raphaelzana.central_fatec.repositories.ProjetorRepository;

@Service
public class ProjetorService {
	
	@Autowired
	private ProjetorRepository repo;
	
	public Projetor find(Integer id) {
		Optional<Projetor> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Projetor> findAll(){
		return repo.findAll();
	}

	@Transactional
	public Projetor insert(Projetor obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	/*public Projetor update(Projetor obj) {
		Projetor newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}*/
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	/*private void updateData(Projetor newObj, Projetor obj) {
		
	}*/
	
}
