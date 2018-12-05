package br.com.raphaelzana.central_fatec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.raphaelzana.central_fatec.domain.Objeto;
import br.com.raphaelzana.central_fatec.repositories.ObjetoRepository;

@Service
public class ObjetoService {
	
	@Autowired
	private ObjetoRepository repo;
	
	public Objeto find(Integer id) {
		Optional<Objeto> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Objeto> findAll(){
		return repo.findAll();
	}
	
	public Page<Objeto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageResquest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageResquest);
	}
	
	@Transactional
	public Objeto insert(Objeto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Objeto update(Objeto obj) {
		Objeto newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	private void updateData(Objeto newObj, Objeto obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setData(obj.getData());
		newObj.setLocal(obj.getLocal());
	}

}
