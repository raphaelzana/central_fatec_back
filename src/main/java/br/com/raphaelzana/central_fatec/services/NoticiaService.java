package br.com.raphaelzana.central_fatec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.raphaelzana.central_fatec.domain.Noticia;
import br.com.raphaelzana.central_fatec.repositories.NoticiaRepository;

@Service
public class NoticiaService {
	
	@Autowired
	private NoticiaRepository repo;
	
	public Noticia find(Integer id) {
		Optional<Noticia> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Noticia> findAll(){
		return repo.findAll();
	}
	
	public Page<Noticia> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageResquest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageResquest);
	}

	@Transactional
	public Noticia insert(Noticia obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Noticia update(Noticia obj) {
		Noticia newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	private void updateData(Noticia newObj, Noticia obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setDescricao(obj.getDescricao());
	}
	
}
